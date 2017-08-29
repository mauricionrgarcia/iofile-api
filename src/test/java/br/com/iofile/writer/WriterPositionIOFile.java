package br.com.iofile.writer;

import java.util.List;

import br.com.iofile.interfaces.IBean;
import br.com.iofile.interfaces.ITab;

/**
 * Implementação para defir a criação de arqivo de BodyBean
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:52:01
 */
public class WriterPositionIOFile extends AbstractPositionWritterFileIntegration {

	/**
	 * Construtor
	 *
	 * @param fileName nome do arquivo
	 * @param header header
	 * @param objects lista de objetos
	 * @throws Exception exception
	 */
	public WriterPositionIOFile(String fileName, IBean header, List<IBean> objects) throws Exception {
		super(fileName, header, objects);
	}

	/**
	 * Construtor
	 *
	 * @param fileName nome do arquivo
	 * @param objects lista de objetos
	 * @throws Exception exception
	 */
	public WriterPositionIOFile(String fileName, List<IBean> objects) throws Exception {
		super(fileName, null, objects);
	}

	/**
	 * ontrutor que atende a visao TAB
	 *
	 * @param fileName nome do arquivo
	 * @param tab tab que contem as informações da aba
	 * @throws Exception exception
	 */
	public WriterPositionIOFile(String fileName, ITab tab) throws Exception {
		super(fileName, tab);
	}

	/**
	 * ontrutor que atende a visao TAB
	 *
	 * @param fileName nome do arquivo
	 * @param tab tab que contem as informações da aba
	 * @throws Exception exception
	 */
	public WriterPositionIOFile(String fileName, ITab... tab) throws Exception {
		super(fileName, tab);
	}
}