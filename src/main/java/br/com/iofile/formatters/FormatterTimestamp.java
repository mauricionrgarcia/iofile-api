package br.com.iofile.formatters;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import br.com.iofile.interfaces.IFormatterValues;

/**
 * Classe utilitaria para atender o converters para campo tipo {@link Timestamp}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:36:00
 */
public class FormatterTimestamp implements IFormatterValues<Timestamp> {

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.IFormatterValues#getValue(java.lang.String,
	 * java.lang.String)
	 */
	public Timestamp getValue(String pattern, String value) throws Exception {
		if (value == null || value.isEmpty()) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return new Timestamp(sdf.parse(value).getTime());
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
	public String format(String mask, Timestamp value) throws Exception {
		return value.toString();
	}
}