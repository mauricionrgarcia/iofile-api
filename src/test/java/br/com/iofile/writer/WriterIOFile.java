package br.com.iofile.writer;

import java.util.List;

import br.com.iofile.example.beans.BodyBean;

/**
 * Implementação para defir a criação de arqivo de BodyBean
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:52:01
 */
public class WriterIOFile extends AbstractWritterFileIntegration<BodyBean> {

	/**
	 * Construtor
	 *
	 * @param fileName nome do arquivo
	 * @param objects lista de objetos
	 * @throws Exception exception
	 */
	public WriterIOFile(String fileName, List<BodyBean> objects) throws Exception {
		super(fileName, objects);
	}
}