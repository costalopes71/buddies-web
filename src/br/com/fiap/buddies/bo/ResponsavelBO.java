package br.com.fiap.buddies.bo;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.buddies.dao.ResponsavelDAO;
import br.com.fiap.buddies.entities.Responsavel;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.security.Login;
import br.com.fiap.buddies.security.pbkdf2.PasswordEncryptor;

@Service
public class ResponsavelBO {

	@Autowired
	private ResponsavelDAO responsavelDAO;

	public Responsavel logar(Login login) throws Exception {
		try {
			return responsavelDAO.logar(login);
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
	}
	
	public void atualizarNomeEmailUsuarioLogado(Responsavel usuario) throws DBException {
		try {
			validarNomeEmail(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		
		try {
			responsavelDAO.alterarNomeEmail(usuario);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar atualizar os dados do usuário. Erro: " + e.getMessage());
		}
	}
	
	private void validarNomeEmail(Responsavel usuario) throws IllegalStateException {
		if (usuario.getEmail().equals("") || usuario.getEmail() == null) {
			throw new IllegalStateException("Não é possível cadastrar/editar um usuário sem e-mail.");
		}
		
		if (usuario.getEmail().length() < 4) {
			throw new IllegalStateException("O e-mail que você tentou inserir para é inválido. Exemplo de e-mail válido: nomeusuario@dominio.com");
		}
		
		if (usuario.getNome().length() < 3 || usuario.getNome() == null) {
			throw new IllegalStateException("Não é possível cadastrar/editar um usuário com nome menor que 3 (três) caracteres.");
		}
	}

	public void atualizarSenha(int idUsuario, String senhaNova) throws DBException {
		
		try {
			validarSenha(senhaNova);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		
		try {
			senhaNova = criptografarPassword(senhaNova);
			responsavelDAO.alterarSenha(idUsuario, senhaNova);
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
	}

	private void validarSenha(String senhaNova) throws IllegalStateException {
		if (senhaNova == null || senhaNova.length() < 5) {
			throw new IllegalStateException("Senha inválida. Por favor escolha uma senha com 5 (cinco) ou mais caracteres.");
		}
	}
	
	private String criptografarPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		try {
			return PasswordEncryptor.generateStorngPasswordHash(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new NoSuchAlgorithmException("Erro ao tentar criptografar o password. Entre em contato com o suporte./nErro: " + e.getMessage());
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
			throw new InvalidKeySpecException("Erro ao tentar criptografar o password. Entre em contato com o suporte./nErro: " + e.getMessage());
		}
	}

	public List<Responsavel> listar() throws DBException {
		
		try {
			return responsavelDAO.listar();
		} catch (Exception e) {
			throw new DBException("Erro ao tentar listar os responsáveis. Erro: " + e.getMessage());
		}

	}
	
}
