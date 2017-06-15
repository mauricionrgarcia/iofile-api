package br.com.iofile.interfaces;

import br.com.iofile.util.HeaderPrint;

/**
 *
 * Interface que define qual a estrategia para posicionamento do header
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 17:45:15
 */
public interface IHeaderStrategy {

	/**
	 *
	 * Metodo que recupera a posição para a estrategy definida
	 *
	 * @param position posicao
	 * @param row linha
	 * @param value valor
	 * @param headerName header
	 * @return HeaderPrint
	 */
	HeaderPrint processHeader(Integer position, Integer row, String value, String headerName);

}
