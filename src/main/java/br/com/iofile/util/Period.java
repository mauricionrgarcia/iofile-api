package br.com.iofile.util;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe utilitaria para representar um periodo de datas
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 16:57:10
 */
public class Period implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -604659739229140134L;

	/**
	 * Atributo que representa a data de inicio
	 */
	private Date dtBegin;

	/**
	 * Atributo que representa a data fim
	 */
	private Date dtEnd;

	/**
	 * Construtor vazio
	 */
	public Period() {

	}

	/**
	 * Construtor:
	 *
	 * @param dtBegin {@link Date}
	 * @param dtEnd {@link Date}
	 */
	public Period(Date dtBegin, Date dtEnd) {
		super();
		this.dtBegin = dtBegin;
		this.dtEnd = dtEnd;
	}

	/**
	 * @return the dtBegin
	 */
	public Date getDtBegin() {
		return this.dtBegin;
	}

	/**
	 * @param dtBegin the dtBegin to set
	 */
	public void setDtBegin(Date dtBegin) {
		this.dtBegin = dtBegin;
	}

	/**
	 * @return the dtEnd
	 */
	public Date getDtEnd() {
		return this.dtEnd;
	}

	/**
	 * @param dtEnd the dtEnd to set
	 */
	public void setDtEnd(Date dtEnd) {
		this.dtEnd = dtEnd;
	}

}
