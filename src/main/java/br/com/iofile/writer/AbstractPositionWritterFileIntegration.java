package br.com.iofile.writer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.IIOException;

import br.com.iofile.annotations.Header;
import br.com.iofile.annotations.HeaderValues;
import br.com.iofile.annotations.Section;
import br.com.iofile.annotations.Values;
import br.com.iofile.enums.HeaderStrategyEnum;
import br.com.iofile.interfaces.IBean;
import br.com.iofile.interfaces.IFormatterValues;
import br.com.iofile.interfaces.IHeaderStrategy;
import br.com.iofile.interfaces.ITab;
import br.com.iofile.interfaces.Writer;
import br.com.iofile.util.Util;

/**
 * Classe responsavel por efetuar a escrita de arquivos
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version 1
 * @sinse 15/06/2017 12:40:33
 */
public abstract class AbstractPositionWritterFileIntegration {

	/**
	 * Atributo que representa o nome do arquivo gerado
	 */
	private String fileName;

	/**
	 * Atributo responsável por manter os fildes de cada {@link IBean}
	 */
	private Map<Class<? extends IBean>, List<Field>> mapFields;

	/**
	 * Atributo responsavel por manter o metodo de acesso de cada field
	 */
	private Map<Field, Method> mapMethod;

	/**
	 * Representa o que sera impresso
	 */
	private List<IBean> values;

	/**
	 * Representa o filtro
	 */
	private IBean header;

	/**
	 * Representa a section
	 */
	private ITab tab;

	/**
	 * Representa a classe que mantem a escrita do arquivo
	 */
	private Writer writter;

	/**
	 *
	 * Construtor padrão
	 *
	 * @param fileName full path file
	 * @param tab Tab
	 * @throws Exception
	 */
	public AbstractPositionWritterFileIntegration(String fileName, ITab tab) throws Exception {
		this.fileName = fileName;
		this.init();
		constructFilds(tab);
		processTab();
		this.writter.finish();
	}

	/**
	 *
	 * Construtor padrão
	 *
	 * @param fileName full path file
	 * @param tab Tab
	 * @throws Exception
	 */
	public AbstractPositionWritterFileIntegration(String fileName, ITab[] tab) throws Exception {
		this.fileName = fileName;
		init();
		for (ITab iTab : tab) {
			constructFilds(iTab);
			processTab();
		}
		this.writter.finish();
	}

	/**
	 *
	 * Construtor padrão
	 *
	 * @param fileName full path file
	 * @param header Filtro de pesquisa utilizado
	 * @throws Exception
	 */
	@Deprecated
	public AbstractPositionWritterFileIntegration(String fileName, IBean header, List<IBean> objects) throws Exception {
		this.fileName = fileName;
		this.values = objects;
		this.header = header;
		this.init();
	}

	/**
	 * Method constructFilds responsavel por preecnher os mapas que atendem a
	 * leitura e validação de uma celula
	 *
	 * @throws Exception
	 */
	private void constructFilds(ITab tab) throws Exception {

		this.tab = tab;

		this.header = tab.getHeader();
		this.values = tab.getBody();

		this.mapFields = new HashMap<>();
		this.mapMethod = new HashMap<>();

		if (tab.getBody() != null && !tab.getBody().isEmpty()) {
			loadFieldsValid(tab.getBody().get(0).getClass());
		}

		loadHeader(tab.getHeader().getClass());

	}

	/**
	 * Método process que inicia o processo de carregamento e leitura de um
	 * arquivo
	 *
	 * @throws Exception
	 */
	private void init() throws Exception {
		this.writter = new WriterExcelFile(this.fileName);
	}

	/**
	 *
	 * Processa o conteduo de cada tab
	 *
	 * @throws Exception
	 */
	private void processTab() throws Exception {

		Section tab = this.tab.getClass().getAnnotation(Section.class);
		this.writter.createSection(tab != null ? tab.name() : "Aba1");

		int i = 0;
		if (this.header != null) {
			Header headerBean = this.header.getClass().getAnnotation(Header.class);
			IHeaderStrategy headerStrategy = HeaderStrategyEnum.DEFAULT.getStrategy();
			if (headerBean != null) {
				i = headerBean.size();
				headerStrategy = headerBean.headerStrategy().getStrategy();
			}

			// header
			for (Field f : this.mapFields.get(this.header.getClass())) {
				Object valueObject = this.mapMethod.get(f).invoke(this.header);
				HeaderValues values = f.getAnnotation(HeaderValues.class);
				IFormatterValues<?> formatted = values.formatted().newInstance();

				String value = formatted.format(values.pattern(), valueObject);
				Integer position = values.position();
				Integer row = values.row();

				this.writter.print(headerStrategy.processHeader(position, row, value, values.headerName()));
			}
		}

		if (this.values != null && !this.values.isEmpty()) {

			this.writter.createRow(i);

			Boolean hasTitle = Boolean.FALSE;

			for (Field f : this.mapFields.get(this.values.get(0).getClass())) {
				Values values = f.getAnnotation(Values.class);
				if (!values.title().isEmpty()) {
					hasTitle = Boolean.TRUE;
					this.writter.print(values.position(), values.title());
				}
			}

			if (hasTitle) {
				i++;
			}

			for (IBean interator : this.values) {

				this.writter.createRow(i);

				for (Field f : this.mapFields.get(interator.getClass())) {
					Object valueObject = this.mapMethod.get(f).invoke(interator);
					Values values = f.getAnnotation(Values.class);
					IFormatterValues<?> formatted = values.formatted().newInstance();
					String value = formatted.format(values.pattern(), valueObject);
					Integer position = values.position();

					this.writter.print(position, value);
				}
				i++;
			}
		}

	}

	/**
	 * Metodo loadFieldsValid responsável por recuperar os filds validos
	 *
	 * @param clazz
	 *
	 * @throws Exception exception
	 */
	private void loadFieldsValid(Class<? extends IBean> clazz) throws Exception {

		List<Field> fildsValid = this.mapFields.get(clazz);
		if (fildsValid == null) {
			fildsValid = new LinkedList<>();
		}

		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			Values values = f.getAnnotation(Values.class);
			if (!java.lang.reflect.Modifier.isStatic(f.getModifiers()) && values != null) {
				fildsValid.add(f);
				this.mapMethod.put(f, method(clazz, f.getName()));
			}
		}

		this.mapFields.put(clazz, fildsValid);

	}

	/**
	 * Metodo loadFieldsValid responsável por recuperar os filds validos do
	 * header
	 *
	 * @param clazz classe que implementa {@link IBean}
	 * @throws Exception exception
	 */
	private void loadHeader(Class<? extends IBean> clazz) throws Exception {

		List<Field> fildsValid = this.mapFields.get(clazz);
		if (fildsValid == null) {
			fildsValid = new LinkedList<>();
		}

		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			HeaderValues values = f.getAnnotation(HeaderValues.class);
			if (!java.lang.reflect.Modifier.isStatic(f.getModifiers()) && values != null) {
				fildsValid.add(f);
				this.mapMethod.put(f, method(clazz, f.getName()));
			}
		}

		this.mapFields.put(clazz, fildsValid);

	}

	/**
	 * Método responspavel por recuperar o method pelo filed Name {@link IBean}
	 *
	 * @param clazz {@link IBean}
	 * @param fieldName nome do atributo
	 * @return {@link Method}' fildName
	 * @throws IIOException exception
	 */
	private Method method(Class<? extends IBean> clazz, String fieldName) throws IIOException {
		return Util.methodGet(clazz, fieldName);
	}

}