package br.com.iofile.util.strategy;

import br.com.iofile.interfaces.IHeaderStrategy;
import br.com.iofile.util.HeaderPrint;

/**
 * Strategy que define o comportamento padrão não exibindo o header
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 17/06/2017 00:14:41
 */
public class NoneHeaderStrategy implements IHeaderStrategy {

	@Override
	public HeaderPrint processHeader(Integer position, Integer row, String value, String headerName) {
		return new HeaderPrint(position, row, null, null, value, "");
	}

}
