package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_BDS_BAIRRO")
@SequenceGenerator(name="bairro", sequenceName="SEQ_BDS_BAIRRO", allocationSize=1, initialValue=1)
public class Bairro {
	
	@Id
	@Column(name="id_bairro")
	@GeneratedValue(generator="bairro", strategy=GenerationType.SEQUENCE)
	private int idBairro;

	@Column(name="nm_bairro", nullable=false, length=150)
	private String nomeBairro;

	@ManyToOne
	@JoinColumn(name="id_cidade")
	private Cidade cidade;
	
	public int getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(int idBairro) {
		this.idBairro = idBairro;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
