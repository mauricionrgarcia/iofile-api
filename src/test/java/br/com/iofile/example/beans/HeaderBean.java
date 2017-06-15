package br.com.iofile.example.beans;

import br.com.iofile.annotations.HeaderValues;
import br.com.iofile.enums.HeaderStrategyEnum;
import br.com.iofile.formatters.FormatterPeriod;
import br.com.iofile.interfaces.IBean;
import br.com.iofile.util.Period;

/**
 * Classe que reprsenta o header
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 16:55:29
 */
@br.com.iofile.annotations.HeaderBean(size = 4, headerStrategy = HeaderStrategyEnum.DEFAULT)
public class HeaderBean implements IBean {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -1386584488847728896L;

	/**
	 * Atributo que representa o filtro por nome
	 */
	@HeaderValues(position = 0, row = 0, headerName = "Nome: ")
	private String name;

	/**
	 * Atributo que representa o filtro pelo periodo
	 */
	@HeaderValues(position = 1, row = 0, headerName = "Período: ", formatted = FormatterPeriod.class)
	private Period dtPeriod;

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dtPeriod
	 */
	public Period getDtPeriod() {
		return this.dtPeriod;
	}

	/**
	 * @param dtPeriod the dtPeriod to set
	 */
	public void setDtPeriod(Period dtPeriod) {
		this.dtPeriod = dtPeriod;
	}

}
