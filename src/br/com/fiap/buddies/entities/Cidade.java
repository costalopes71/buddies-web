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
@Table(name = "TB_BDS_CIDADE")
@SequenceGenerator(name="cidade", sequenceName="SEQ_BDS_CIDADE", allocationSize=1, initialValue=1)
public class Cidade {

	@Id
	@Column(name = "id_cidade")
	@GeneratedValue(generator="cidade", strategy=GenerationType.SEQUENCE)
	private int idCidade;

	@Column(name = "nm_cidade", nullable = false, length = 150)
	private String nomeCidade;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;
	
	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
