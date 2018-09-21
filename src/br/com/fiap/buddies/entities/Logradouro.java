package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_BDS_LOGRADOURO")
public class Logradouro {

	@Id
	@Column(name="id_logradouro")
	private int id;
	
	@Column(name="nr_cep", length=8)
	private String cep;

	@Column(name="ds_logradouro", nullable=false, length=150)
	private String logradouro;
	
	@Column(name="nr_logradouro", nullable=false, length=10)
	private String numero;

	@ManyToOne
	@JoinColumn(name="id_bairro")
	private Bairro bairro;


	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
