package br.com.iofile.formatters;

import java.text.SimpleDateFormat;

import br.com.iofile.interfaces.IFormatterValues;
import br.com.iofile.util.Period;

/**
 * Classe utilitaria para atender o converters para campo tipo {@link Period}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:34:15
 */
public class FormatterPeriod implements IFormatterValues<Period> {

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.IFormatterValues#getValue(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Period getValue(String mask, String value) throws Exception {
		return new Period();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.IFormatterValues#format(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public String format(String mask, Object value) throws Exception {
		if (value == null) {
			return "-";
		}
		Period period = (Period) value;

		if (mask == null || mask.isEmpty()) {
			mask = "";
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			if (period.getDtBegin() != null) {
				mask = "De ";
				mask = mask.concat(sdf.format(period.getDtBegin()));
			}

			if (period.getDtBegin() != null) {
				mask = mask.concat(" Até ");
				mask = mask.concat(sdf.format(period.getDtBegin()));
			}
		}
		return mask.isEmpty() ? "-" : mask;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.IFormatterValues#format(java.lang.String,
	 * java.io.Serializable)
	 */
	@Override
	public String format(String mask, Period value) throws Exception {
		if (value == null) {
			return "-";
		}

		if (mask == null || mask.isEmpty()) {
			mask = "-";
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			if (value.getDtBegin() != null) {
				mask = "De ";
				mask = mask.concat(sdf.format(value.getDtBegin()));
			}

			if (value.getDtBegin() != null) {
				mask = " Até ";
				mask = mask.concat(sdf.format(value.getDtBegin()));
			}
		}
		return value.toString();
	}
}
