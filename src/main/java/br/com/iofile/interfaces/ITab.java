package br.com.iofile.interfaces;

import java.util.List;

/**
 *
 * Representa uma tab
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 11/08/2017 21:48:30
 */
public interface ITab {

	/**
	 * @return body
	 */
	List<IBean> getBody();

	/**
	 * @return header
	 */
	IBean getHeader();

}
