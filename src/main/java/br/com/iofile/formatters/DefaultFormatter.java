package br.com.iofile.formatters;

import br.com.iofile.interfaces.IFormatterValues;

/**
 * Classe que representa o converter generico para qualquer tipo de dados
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version 1
 * @sinse 15/06/2017 12:09:21
 */
public class DefaultFormatter implements IFormatterValues<String> {

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.IFormatterValues#getValue(java.lang.String,
	 * java.lang.String)
	 */
	public String getValue(String mask, String value) throws Exception {
		return value;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.IFormatterValues#format(java.lang.String,
	 * java.io.Serializable)
	 */
	public String format(String mask, String value) throws Exception {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iofile.interfaces.IFormatterValues#format(java.lang.String,
	 * java.lang.Object)
	 */
	public String format(String mask, Object obj) throws Exception {
		return obj.toString();
	}

}
