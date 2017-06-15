package br.com.iofile.formatters;

import java.text.NumberFormat;

import br.com.iofile.interfaces.IFormatterValues;

/**
 * * Classe utilitaria para atender o converters para campo monetarios
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:33:21
 */
public class FormatterDosh implements IFormatterValues<Double> {

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
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return nf.format(value);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iofile.interfaces.IFormatterValues#format(java.lang.String,
	 * java.io.Serializable)
	 */
	public String format(String mask, Double value) throws Exception {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return nf.format(value);
	}
}
