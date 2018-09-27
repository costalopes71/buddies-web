package br.com.fiap.buddies.resource.entities;

public class LoginResponse {

	private boolean sucesso;
	private String mensagem;
	private String nome;
	private String email;
	private int id;

	public LoginResponse(boolean sucesso, String mensagem, String nome, String email, int id) {
		this.sucesso = sucesso;
		this.mensagem = mensagem;
		this.nome = nome;
		this.email = email;
		this.id = id;
	}

	public LoginResponse(boolean sucesso, String mensagem) {
		this.sucesso = sucesso;
		this.mensagem = mensagem;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
