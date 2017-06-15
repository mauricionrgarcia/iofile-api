package br.com.iofile.formatters;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.iofile.interfaces.IFormatterValues;

/**
 * Classe utilitaria para atender o converters para campo tipo {@link Date}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:30:59
 */
public class FormatterDate implements IFormatterValues<Date> {

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.IFormatterValues#getValue(java.lang.String,
	 * java.lang.String)
	 */
	public Date getValue(String pattern, String value) throws Exception {

		if (pattern == null || pattern.isEmpty()) {
			pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(value);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.IFormatterValues#format(java.lang.String,
	 * java.lang.Object)
	 */
	public String format(String mask, Object value) throws Exception {
		if (mask == null || mask.isEmpty()) {
			mask = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(mask);
		return sdf.format(value);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.IFormatterValues#format(java.lang.String,
	 * java.io.Serializable)
	 */
	public String format(String mask, Date value) throws Exception {
		if (mask == null || mask.isEmpty()) {
			mask = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(mask);
		return sdf.format(value);
	}
}
