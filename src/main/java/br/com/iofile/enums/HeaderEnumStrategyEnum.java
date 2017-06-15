package br.com.iofile.enums;

import br.com.iofile.interfaces.IHeaderStrategy;
import br.com.iofile.util.DefaultHeaderStrategy;

/**
 *
 * Enum que representa as estrategias para posicionamento
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 17:42:52
 */
public enum HeaderEnumStrategyEnum {

	DEFAULT {
		@Override
		public IHeaderStrategy getStrategy() {
			return new DefaultHeaderStrategy();
		}
	};

	/**
	 * Metodo que retorna uma {@link IHeaderStrategy}
	 *
	 * @return {@link IHeaderStrategy}
	 */
	public abstract IHeaderStrategy getStrategy();

}
