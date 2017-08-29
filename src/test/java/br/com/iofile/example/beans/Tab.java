package br.com.iofile.example.beans;

import java.util.List;

import br.com.iofile.annotations.Section;
import br.com.iofile.interfaces.IBean;
import br.com.iofile.interfaces.ITab;

/**
 * Classe que representa uma tab da exportação
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 11/08/2017 22:33:34
 */
@Section(name = "Test 1")
public class Tab implements ITab {

	/**
	 * Representa o header
	 */
	IBean header;

	/**
	 * Representa o body
	 */
	List<IBean> body;

	/**
	 * Contrutor sem parametros
	 */
	public Tab() {
	}

	/**
	 * Contrutor parametros:
	 *
	 * @param header header
	 * @param body body
	 */
	public Tab(IBean header, List<IBean> body) {
		super();
		this.header = header;
		this.body = body;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.ITab#getBody()
	 */
	@Override
	public List<IBean> getBody() {
		return this.body;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.iofile.interfaces.ITab#getHeader()
	 */
	@Override
	public IBean getHeader() {
		return this.header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(IBean header) {
		this.header = header;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(List<IBean> body) {
		this.body = body;
	}

}
