package br.com.fiap.buddies.exceptions;

public class LimiteCaracteresException extends Exception {
	
	private static final long serialVersionUID = 6146583954613762294L;

	public LimiteCaracteresException() {
		super("O limite de caracteres foi excedido");
	}
	
	public LimiteCaracteresException(String mensagem) {
		super(mensagem);
	}
	

}
