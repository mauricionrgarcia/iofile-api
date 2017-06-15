package br.com.iofile.formatters;

import br.com.iofile.interfaces.IFormatterValues;

/**
 * Classe utilitaria para atender o converters para campo tipo {@link Double}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:34:15
 */
public class FormatterDouble implements IFormatterValues<Double> {

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.IFormatterValues#getValue(java.lang.String,
	 * java.lang.String)
	 */
	public Double getValue(String mask, String value) throws Exception {
		return Double.parseDouble(value);
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
	public String format(String mask, Double value) throws Exception {
		return value.toString();
	}
}
