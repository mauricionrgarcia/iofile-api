package br.com.iofile.interfaces;

import java.io.IOException;

/**
 * Interface para definir os metodos necessarios para escrever os arqivos
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:12:09
 */
public interface Writer {

	/**
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	Writer newInstance(String fileName) throws Exception;

	/**
	 * Criar uma nova linha
	 *
	 * @param i linha do documento
	 */
	public void createRow(Integer i);

	/**
	 * Metodo que insere um novo valor para a posicao
	 *
	 * @param position posicao
	 * @param value valor do objeto
	 */
	public void print(Integer position, String value);

	/**
	 * Metodo que finaliza a criacao do arquivo
	 *
	 * @throws IOException Exception
	 */
	public void finish() throws IOException;
}
