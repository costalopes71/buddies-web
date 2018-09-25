package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BDS_RESPONSAVEL")
@SequenceGenerator(name = "responsavel", sequenceName = "SEQ_BDS_RESPONSAVEL", allocationSize = 1, initialValue = 1)
public class Responsavel {

	@Id
	@Column(name = "id_responsavel")
	@GeneratedValue(generator = "responsavel", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "nm_responsavel", nullable = false, length = 150)
	private String nome;

	@Column(name = "ds_email", length = 50, unique=true, nullable=false)
	private String email;

	@Column(name = "pw_senha", nullable = false, length = 250)
	private String senha;
	
	@Column(name="st_administrador", nullable=false)
	private boolean administrador;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nomeResponsavel) {
		this.nome = nomeResponsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

}
