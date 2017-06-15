package br.com.iofile.formatters;

import br.com.iofile.interfaces.IFormatterValues;

/**
 * Classe utilitaria para atender o converters para campo tipo {@link Integer}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:34:46
 */
public class FormatterInteger implements IFormatterValues<Integer> {

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.IFormatterValues#getValue(java.lang.String,
	 * java.lang.String)
	 */
	public Integer getValue(String mask, String value) throws Exception {
		return Integer.parseInt(value);
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

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.IFormatterValues#format(java.lang.String,
	 * java.io.Serializable)
	 */
	public String format(String mask, Integer value) throws Exception {
		return value.toString();
	}
}
