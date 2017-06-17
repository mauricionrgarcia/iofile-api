package br.com.iofile.writer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.IIOException;

import br.com.iofile.annotations.HeaderBean;
import br.com.iofile.annotations.HeaderValues;
import br.com.iofile.annotations.Values;
import br.com.iofile.enums.HeaderStrategyEnum;
import br.com.iofile.interfaces.IBean;
import br.com.iofile.interfaces.IFormatterValues;
import br.com.iofile.interfaces.IHeaderStrategy;
import br.com.iofile.interfaces.Writer;
import br.com.iofile.util.Util;

/**
 * Classe responsavel por efetuar a escrita de arquivos
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version 1
 * @sinse 15/06/2017 12:40:33
 * @param <H> {@link IBean} que representa o header do arquivo
 * @param <B> {@link IBean} que representa o corpo do arquivo
 */
public abstract class AbstractWritterFileIntegration<H extends IBean, B extends IBean> {

	/**
	 * Atributo BEAN_BODY representa a posição da classe no generics
	 */
	@SuppressWarnings("unused")
	private static final Integer BEAN_HEADER = 0;

	/**
	 * Atributo BEAN_BODY representa a posição da classe no generics
	 */
	private static final Integer BEAN_BODY = 1;

	/**
	 * Atributo que representa o nome do arquivo gerado
	 */
	private String fileName;

	/**
	 * Atributo responsável por manter os fildes de cada {@link IBean}
	 */
	private Map<Class<? extends IBean>, List<Field>> mapFields;

	/**
	 * Atributo responsavel por manter o metoo de acesso de cada field
	 */
	private Map<Field, Method> mapMethod;

	/**
	 * Representa o que sera impresso
	 */
	private List<B> values;

	/**
	 * Representa o filtro
	 */
	private H header;

	/**
	 *
	 * Construtor padrão
	 *
	 * @param fileName full path file
	 * @param header Filtro de pesquisa utilizado
	 * @throws Exception
	 */
	public AbstractWritterFileIntegration(String fileName, H header, List<B> objects) throws Exception {
		this.fileName = fileName;
		this.values = objects;
		this.header = header;
		this.init();
	}

	/**
	 * Método que carregas as informações inicias
	 *
	 * @throws Exception
	 */
	private void init() throws Exception {
		constructFilds();
		execute();
	}

	/**
	 * Method constructFilds responsavel por preecnher os mapas que atendem a
	 * leitura e validação de uma celula
	 *
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void constructFilds() throws Exception {

		this.mapFields = new HashMap<>();
		this.mapMethod = new HashMap<>();

		Type t = this.getClass().getGenericSuperclass();
		if (!ParameterizedType.class.isAssignableFrom(t.getClass())) {
			return;
		}

		for (Type type : ((ParameterizedType) t).getActualTypeArguments()) {
			loadFieldsValid(((Class<? extends IBean>) type).newInstance());
			loadHeader(((Class<? extends IBean>) type).newInstance());
		}

	}

	/**
	 * Método process que inicia o processo de carregamento e leitura de um
	 * arquivo
	 *
	 * @throws Exception
	 */
	private void execute() throws Exception {

		Writer writter = new WriterExcelFile(this.fileName);

		int i = 0;
		if (this.header != null) {
			HeaderBean headerBean = this.header.getClass().getAnnotation(HeaderBean.class);
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

				writter.print(headerStrategy.processHeader(position, row, value, values.headerName()));
			}
		}

		if (this.values != null && !this.values.isEmpty()) {

			writter.createRow(i);

			Boolean hasTitle = Boolean.FALSE;

			for (Field f : this.mapFields.get(this.values.get(0).getClass())) {
				Values values = f.getAnnotation(Values.class);
				if (!values.title().isEmpty()) {
					hasTitle = Boolean.TRUE;
					writter.print(values.position(), values.title());
				}
			}

			if (hasTitle) {
				i++;
			}

			for (B interator : this.values) {

				writter.createRow(i);

				for (Field f : this.mapFields.get(interator.getClass())) {
					Object valueObject = this.mapMethod.get(f).invoke(interator);
					Values values = f.getAnnotation(Values.class);
					IFormatterValues<?> formatted = values.formatted().newInstance();
					String value = formatted.format(values.pattern(), valueObject);
					Integer position = values.position();

					writter.print(position, value);
				}
				i++;
			}
		}
		writter.finish();
	}

	/**
	 * Metodo loadFieldsValid responsável por recuperar os filds validos
	 *
	 * @param model classe que implementa {@link IBean}
	 * @throws Exception exception
	 */
	private void loadFieldsValid(IBean model) throws Exception {

		Type t = this.getClass().getGenericSuperclass();
		if (!ParameterizedType.class.isAssignableFrom(t.getClass())) {

		}
		List<Field> fildsValid = this.mapFields.get(model.getClass());
		if (fildsValid == null) {
			fildsValid = new LinkedList<>();
		}

		Field[] fields = model.getClass().getDeclaredFields();
		for (Field f : fields) {
			Values values = f.getAnnotation(Values.class);
			if (!java.lang.reflect.Modifier.isStatic(f.getModifiers()) && values != null) {
				fildsValid.add(f);
				this.mapMethod.put(f, method(model, f.getName()));
			}
		}

		this.mapFields.put(model.getClass(), fildsValid);

	}

	/**
	 * Metodo loadFieldsValid responsável por recuperar os filds validos do
	 * header
	 *
	 * @param model classe que implementa {@link IBean}
	 * @throws Exception exception
	 */
	private void loadHeader(IBean model) throws Exception {

		Type t = this.getClass().getGenericSuperclass();
		if (!ParameterizedType.class.isAssignableFrom(t.getClass())) {

		}
		List<Field> fildsValid = this.mapFields.get(model.getClass());
		if (fildsValid == null) {
			fildsValid = new LinkedList<>();
		}

		Field[] fields = model.getClass().getDeclaredFields();
		for (Field f : fields) {
			HeaderValues values = f.getAnnotation(HeaderValues.class);
			if (!java.lang.reflect.Modifier.isStatic(f.getModifiers()) && values != null) {
				fildsValid.add(f);
				this.mapMethod.put(f, method(model, f.getName()));
			}
		}

		this.mapFields.put(model.getClass(), fildsValid);

	}

	/**
	 * Método responspavel por recuperar o method pelo filed Name {@link IBean}
	 *
	 * @param model {@link IBean}
	 * @param fieldName nome do atributo
	 * @return {@link Method}' fildName
	 * @throws IIOException exception
	 */
	private <M extends IBean> Method method(M model, String fieldName) throws IIOException {
		return Util.methodGet(model, fieldName);
	}

	/**
	 * Metodo que recupera uma nova intancia da classe que implementa
	 * {@link IBean}
	 *
	 * @return classe que implementa {@link IBean}
	 * @throws Exception exception
	 */
	@SuppressWarnings("unused")
	private B bodyBeanRfi() throws Exception {
		return getBean(BEAN_BODY);
	}

	/**
	 *
	 * Recupera uma nova instancia da implementação de um {@link IBean}
	 *
	 * @param pos da interface
	 * @return objeto
	 * @throws Exception Exception
	 */
	private <M extends IBean> M getBean(int pos) throws Exception {
		Type t = this.getClass().getGenericSuperclass();
		if (!ParameterizedType.class.isAssignableFrom(t.getClass())) {
			return null;
		}
		Type[] iBean = ((ParameterizedType) t).getActualTypeArguments();
		@SuppressWarnings("unchecked")
		M obj = ((Class<M>) iBean[pos]).newInstance();
		return obj;
	}

}