package br.com.iofile.formatters;

import br.com.iofile.interfaces.IFormatterValues;

/**
 * Classe utilitaria para atender o converters para campo tipo {@link String}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:35:26
 */
public class FormatterString implements IFormatterValues<String> {

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
	 * java.lang.Object)
	 */
	public String format(String mask, Object value) throws Exception {
		return value.toString();
	}
}
