package br.com.iofile.example.beans.position;

import java.util.Date;

import br.com.iofile.annotations.Column;
import br.com.iofile.formatters.FormatterDate;
import br.com.iofile.formatters.FormatterDosh;
import br.com.iofile.interfaces.IBean;

/**
 *
 * Classe BodyBean para exemplificar a utilização da leitura do arquivo
 *
 * @author mauricionrgarcia
 *
 */
public class BodyBean implements IBean {
	private static final long serialVersionUID = 1L;

	@Column(title = "Identificação")
	private String identification;

	@Column(title = "Nome")
	private String name;

	@Column(title = "Endereço")
	private String address;

	@Column(title = "Especialidade")
	private String specialty;

	@Column(title = "Documento")
	private String document;

	@Column(formatted = FormatterDate.class, pattern = "dd/MM/yyyy", title = "Data")
	private Date date;

	@Column(formatted = FormatterDosh.class, title = "Valor")
	private Double valor;

	@Override
	public String toString() {
		return "BodyBean [identification=" + this.identification + ", name=" + this.name + ", address=" + this.address
				+ ", specialty=" + this.specialty + ", document=" + this.document + ", date=" + this.date + ", valor = "
				+ this.valor + "]";
	}

	public String getIdentification() {
		return this.identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getDocument() {
		return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
