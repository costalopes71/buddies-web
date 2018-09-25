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
	private int id;

	@Column(name = "nm_profissao", nullable = false, length = 150)
	private String nome;

	public int getId() {
		return id;
	}

	public void setId(int idProfissao) {
		this.id = idProfissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeProfissao) {
		this.nome = nomeProfissao;
	}

}
