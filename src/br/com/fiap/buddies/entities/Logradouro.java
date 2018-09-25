package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_BDS_LOGRADOURO")
@SequenceGenerator(name="logradouro", sequenceName="SEQ_BDS_LOGRADOURO", allocationSize=1, initialValue=1)
public class Logradouro {

	@Id
	@Column(name="id_logradouro")
	@GeneratedValue(generator="logradouro", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nr_cep", length=8)
	private String cep;

	@Column(name="ds_logradouro", nullable=false, length=150)
	private String nome;
	
	@Column(name="nr_logradouro", nullable=false, length=10)
	private String numero;

	@Column(name="nm_bairro")
	private String bairro;
	
	@Column(name="nm_cidade")
	private String cidade;

	@Column(name="nm_estado")
	private String estado;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String logradouro) {
		this.nome = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
