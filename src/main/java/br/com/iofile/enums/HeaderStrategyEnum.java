package br.com.iofile.enums;

import br.com.iofile.interfaces.IHeaderStrategy;
import br.com.iofile.util.strategy.ConcatHeaderStrategy;
import br.com.iofile.util.strategy.DefaultHeaderStrategy;
import br.com.iofile.util.strategy.LinearHeaderStrategy;
import br.com.iofile.util.strategy.NoneHeaderStrategy;

/**
 *
 * Enum que representa as estrategias para posicionamento
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 17:42:52
 */
public enum HeaderStrategyEnum {

	DEFAULT {
		@Override
		public IHeaderStrategy getStrategy() {
			return new DefaultHeaderStrategy();
		}
	},
	CONCAT {
		@Override
		public IHeaderStrategy getStrategy() {
			return new ConcatHeaderStrategy();
		}
	},
	LINEAR {
		@Override
		public IHeaderStrategy getStrategy() {
			return new LinearHeaderStrategy();
		}
	},
	NONE {
		@Override
		public IHeaderStrategy getStrategy() {
			return new NoneHeaderStrategy();
		}

	};

	/**
	 * Metodo que retorna uma {@link IHeaderStrategy}
	 *
	 * @return {@link IHeaderStrategy}
	 */
	public abstract IHeaderStrategy getStrategy();

}
