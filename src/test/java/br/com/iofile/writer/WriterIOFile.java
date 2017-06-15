package br.com.iofile.writer;

import java.util.List;

import br.com.iofile.example.beans.BodyBean;
import br.com.iofile.example.beans.HeaderBean;

/**
 * Implementação para defir a criação de arqivo de BodyBean
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:52:01
 */
public class WriterIOFile extends AbstractWritterFileIntegration<HeaderBean, BodyBean> {

	/**
	 * Construtor
	 *
	 * @param fileName nome do arquivo
	 * @param header header
	 * @param objects lista de objetos
	 * @throws Exception exception
	 */
	public WriterIOFile(String fileName, HeaderBean header, List<BodyBean> objects) throws Exception {
		super(fileName, header, objects);
	}
}