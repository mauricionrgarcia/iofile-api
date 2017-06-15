package br.com.iofile.util;

import java.io.Serializable;

public class HeaderPrint implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -4243652783883184262L;

	/**
	 * Atributo que representa a posição da coluna
	 */
	private Integer position;

	/**
	 * Atributo que representa a posição da linha
	 */
	private Integer row;

	/**
	 * Atributo que representa a posição da coluna
	 */
	private Integer positionHeader;

	/**
	 * Atributo que representa a posição da linha
	 */
	private Integer rowHeader;
	/**
	 * Atributo que representa o valor
	 */
	private String value;

	/**
	 * Atributo que representa o header
	 */
	private String headerName;

	/**
	 * Construtor
	 *
	 * @param position
	 * @param row
	 * @param value
	 * @param headerName
	 */
	public HeaderPrint(Integer position, Integer row, String value, String headerName) {
		super();
		this.position = position;
		this.row = row;
		this.value = value;
		this.headerName = headerName;
	}

	/**
	 * Construtor
	 *
	 * @param position
	 * @param row
	 * @param value
	 * @param headerName
	 */
	public HeaderPrint(Integer position, Integer row, String value) {
		super();
		this.position = position;
		this.positionHeader = position;
		this.row = row;
		this.rowHeader = row;
		this.value = value;
	}

	/**
	 * Construtor
	 *
	 * @param position
	 * @param row
	 * @param positionHeader
	 * @param rowHeader
	 * @param value
	 * @param headerName
	 */
	public HeaderPrint(Integer position, Integer row, Integer positionHeader, Integer rowHeader, String value,
			String headerName) {
		super();
		this.position = position;
		this.row = row;
		this.positionHeader = positionHeader;
		this.rowHeader = rowHeader;
		this.value = value;
		this.headerName = headerName;
	}

	/**
	 * @return the position
	 */
	public Integer getPosition() {
		return this.position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Integer position) {
		this.position = position;
	}

	/**
	 * @return the row
	 */
	public Integer getRow() {
		return this.row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(Integer row) {
		this.row = row;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the headerName
	 */
	public String getHeaderName() {
		return this.headerName;
	}

	/**
	 * @param headerName the headerName to set
	 */
	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

	/**
	 * @return the positionHeader
	 */
	public Integer getPositionHeader() {
		return this.positionHeader;
	}

	/**
	 * @param positionHeader the positionHeader to set
	 */
	public void setPositionHeader(Integer positionHeader) {
		this.positionHeader = positionHeader;
	}

	/**
	 * @return the rowHeader
	 */
	public Integer getRowHeader() {
		return this.rowHeader;
	}

	/**
	 * @param rowHeader the rowHeader to set
	 */
	public void setRowHeader(Integer rowHeader) {
		this.rowHeader = rowHeader;
	}

}
