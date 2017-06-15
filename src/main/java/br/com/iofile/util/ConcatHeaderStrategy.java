package br.com.iofile.util;

import br.com.iofile.interfaces.IHeaderStrategy;

/**
 * Strategy que define o comportamento do header concatenado<br>
 * HeaderName: Value<br>
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 17:48:32
 */
public class ConcatHeaderStrategy implements IHeaderStrategy {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * br.com.iofile.interfaces.IHeaderStrategy#processHeader(java.lang.Integer,
	 * java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public HeaderPrint processHeader(Integer position, Integer row, String value, String headerName) {
		return new HeaderPrint(position, row, headerName.concat(value));
	}

}
