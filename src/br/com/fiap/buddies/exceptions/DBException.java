package br.com.fiap.buddies.exceptions;

public class DBException extends Exception {
	
	private static final long serialVersionUID = 4735172455995698355L;
	
	private static String mensagemDB = "N�o conseguimos estabelecer uma conex�o com o banco de dados, entre em contato com a Sinapsis para analise do problema.";
	
	public DBException() {
		super(mensagemDB);
	}
	
	public DBException(String metodo) {
		super(metodo);
	}

}
