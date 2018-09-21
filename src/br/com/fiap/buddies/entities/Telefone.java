package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BDS_TELEFONE")
@SequenceGenerator(name="telefone", sequenceName="SEQ_BDS_TELEFONE", allocationSize=1, initialValue=1)
public class Telefone {

	@Id
	@Column(name = "id_telefone")
	@GeneratedValue(generator="telefone", strategy=GenerationType.SEQUENCE)
	private int idTelefone;

	@Column(name = "nr_telefone", nullable = false)
	private int numeroTelefone;

	@Column(name = "ds_telefone", nullable = false, length =6)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "id_ddd")
	private DiscagemDiretaDistancia ddd;

	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public int getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public DiscagemDiretaDistancia getDdd() {
		return ddd;
	}

	public void setDdd(DiscagemDiretaDistancia ddd) {
		this.ddd = ddd;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
