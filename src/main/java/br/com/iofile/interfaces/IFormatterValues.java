package br.com.iofile.interfaces;

import java.io.Serializable;

/**
 *
 * Interface para definição do converter
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 12:10:51
 * @param <T>
 */
public interface IFormatterValues<T extends Serializable> {

	/**
	 * Metodo responsavel por efetar o parse do valor {@link String} para o
	 * Objeto T
	 *
	 * @param mask representa a mascara
	 * @param value representa o valor string do objeto
	 * @return <T>
	 * @throws Exception erro durante o parse
	 */
	public T getValue(String mask, String value) throws Exception;

	/**
	 * Metodo responsavel por efetuar o parte do objeto para String
	 *
	 * @param mask representa a mascara
	 * @param value representa o valor do objeto
	 * @return {@link String} valor
	 * @throws Exception erro durante o parse
	 */
	public String format(String mask, T value) throws Exception;

	/**
	 * Metodo responsavel por efetuar o parte do objeto para String
	 *
	 * @param mask representa a mascara
	 * @param value representa o valor do objeto
	 * @return {@link String} valor
	 * @throws Exception erro durante o parse
	 */
	public String format(String mask, Object value) throws Exception;

}