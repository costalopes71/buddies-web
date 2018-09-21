package br.com.fiap.buddies.exceptions;

public class CampoVazioException extends Exception {
	
	private static final long serialVersionUID = 9041522423402751489L;

	public CampoVazioException() {
		super("Voc� n�o preencheu o(s) campo(s) obrigat�rio(s)");
	}
	
	public CampoVazioException(String mensagem) {
		super(mensagem);
	}

}
