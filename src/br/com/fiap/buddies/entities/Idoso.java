package br.com.fiap.buddies.entities;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_BDS_USUARIO")
@SequenceGenerator(name = "idoso", sequenceName = "SEQ_BDS_IDOSO", allocationSize = 1, initialValue = 1)
public class Idoso {

	@Id
	@Column(name = "id_idoso")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idoso")
	private int id;

	@Column(name = "nm_idoso", nullable = false, length = 150)
	private String nome;

	@Column(name = "ds_apelido", nullable = false, length = 50)
	private String apelido;

	@Column(name = "dt_nascimento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Column(name = "nm_conjuge", length = 150)
	private String nomeConjuge;

	@Column(name = "nm_time", length = 50)
	private String time;

	@Column(name = "nr_cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "ds_email", length = 50)
	private String email;

	@Column(name = "ds_idoso", length = 1000)
	private String descricao;

	@Column(name = "pw_senha", nullable = false, length = 250)
	private String senha;

	@OneToMany(mappedBy = "usuario")
	private List<Telefone> listaTelefones;

	@OneToOne
	@JoinColumn(name = "id_responsavel")
	private Responsavel responsavel;

	@OneToOne
	@JoinColumn(name = "id_profissao")
	private Profissao profissao;

	@OneToOne
	@JoinColumn(name = "id_filme")
	private Filme filme;
	
	@OneToOne
	@JoinColumn(name = "id_logradouro")
	private Logradouro logradouro;
	
	@OneToMany(mappedBy="usuario")
	private Set<Filho> listaFilhos = new HashSet<>();

	@OneToOne
	@JoinColumn(name="id_cantor")
	private Cantor cantor;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricaoUsuario() {
		return descricao;
	}

	public void setDescricaoUsuario(String descricaoUsuario) {
		this.descricao = descricaoUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<Telefone> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Set<Filho> getListaFilhos() {
		return listaFilhos;
	}

	public void setListaFilhos(Set<Filho> listaFilhos) {
		this.listaFilhos = listaFilhos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cantor getCantor() {
		return cantor;
	}

	public void setCantor(Cantor cantor) {
		this.cantor = cantor;
	}

}
