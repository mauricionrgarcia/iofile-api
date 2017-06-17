package br.com.iofile.util.strategy;

import br.com.iofile.interfaces.IHeaderStrategy;
import br.com.iofile.util.HeaderPrint;

/**
 * Strategy que define o comportamento padrão<br>
 * HeaderName | Value<br>
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 17/06/2017 00:04:37
 */
public class LinearHeaderStrategy implements IHeaderStrategy {

	@Override
	public HeaderPrint processHeader(Integer position, Integer row, String value, String headerName) {
		return new HeaderPrint(position + 1, row, position, row, value, headerName);
	}

}
