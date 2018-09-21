package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BDS_PROFISSAO")
@SequenceGenerator(name="profissao", sequenceName="SEQ_BDS_PROFISSAO", allocationSize=1, initialValue=1)
public class Profissao {

	@Id
	@Column(name = "id_profissao")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="profissao")
	private int idProfissao;

	@Column(name = "nm_profissao", nullable = false, length = 150)
	private String nomeProfissao;

	public int getIdProfissao() {
		return idProfissao;
	}

	public void setIdProfissao(int idProfissao) {
		this.idProfissao = idProfissao;
	}

	public String getNomeProfissao() {
		return nomeProfissao;
	}

	public void setNomeProfissao(String nomeProfissao) {
		this.nomeProfissao = nomeProfissao;
	}

}
