package br.com.iofile.util.strategy;

import br.com.iofile.interfaces.IHeaderStrategy;
import br.com.iofile.util.HeaderPrint;

/**
 * Strategy que define o comportamento padrão<br>
 * HeaderName<br>
 * Value<br>
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 17:48:32
 */
public class DefaultHeaderStrategy implements IHeaderStrategy {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * br.com.iofile.interfaces.IHeaderStrategy#processHeader(java.lang.Integer,
	 * java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public HeaderPrint processHeader(Integer position, Integer row, String value, String headerName) {
		return new HeaderPrint(position, row + 1, position, row, value, headerName);
	}

}
