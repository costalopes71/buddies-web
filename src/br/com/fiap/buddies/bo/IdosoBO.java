package br.com.fiap.buddies.bo;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.naming.SizeLimitExceededException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.buddies.dao.IdosoDAO;
import br.com.fiap.buddies.entities.Idoso;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.exceptions.LimiteCaracteresException;
import br.com.fiap.buddies.security.Login;
import br.com.fiap.buddies.utils.MyUtils;

@Service
public class IdosoBO {

	@Autowired
	private IdosoDAO idosoDAO;
	
	public List<Idoso> listarComResponsavel() throws DBException {
		try {
			return idosoDAO.listarComResponsavel();
		} catch (Exception e) {
			throw new DBException("Erro ao tentar listar os idosos. Erro: " + e.getMessage());
		}
	}

	public List<Idoso> listar() throws DBException {
		try {
			return idosoDAO.listar();
		} catch (Exception e) {
			throw new DBException("Erro ao tentar listar os idosos. Erro: " + e.getMessage());
		}
	}
	
	public List<Idoso> pesquisarPorResponsavel(int  idResponsavel) throws DBException {
		try {
			return idosoDAO.pesquisarPorResponsavel(idResponsavel);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar listar os idosos. Erro: " + e.getMessage());
		}
	}

	public void cadastrar(Idoso idoso) throws DBException {
		try {
			validarIdoso(idoso);
			idosoDAO.cadastrar(idoso);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar cadastrar o idoso. Erro: " + e.getMessage());
		}
	}

	public void excluir(int usuarioId) throws DBException {
		try {
			idosoDAO.remover(usuarioId);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar excluir o idoso. Erro: " + e.getMessage());
		}
	}
	
	private void validarIdoso(Idoso idoso) throws NoSuchAlgorithmException, InvalidKeySpecException, LimiteCaracteresException {
		
		if (idoso.getSenha().length() < 5) {
			throw new LimiteCaracteresException("A senha deve ter no mínimo 5 (cinco) caracteres.");
		}
		
		if (idoso.getSenha().length() <= 20) {
			idoso.setSenha(MyUtils.criptografarPassword(idoso.getSenha()));
		}
		
		if (idoso.getEmail().equals("") || idoso.getEmail() == null) {
			throw new IllegalStateException("Não é possível cadastrar/editar um usuário sem e-mail.");
		}
		
		if (idoso.getEmail().length() < 4) {
			throw new IllegalStateException("O e-mail que você tentou inserir para é inválido. Exemplo de e-mail válido: nomeusuario@dominio.com");
		}
		
		if (idoso.getNome().length() < 3 || idoso.getNome() == null) {
			throw new IllegalStateException("Não é possível cadastrar/editar um usuário com nome menor que 3 (três) caracteres.");
		}
		
	}

	public Idoso pesquisar(int idUsuario) throws DBException {
		try {
			return idosoDAO.pesquisar(idUsuario);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar buscar o usuário de código [" + idUsuario + "].\nErro: " + e.getMessage());
		}
	}

	public Idoso logar(Login login) throws Exception {
		try {
			return idosoDAO.logar(login);
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
	}

	public void atualizar(Idoso idoso) throws DBException {
		try {
			validarUsuario(idoso);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		
		try {
			idosoDAO.alterar(idoso);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar atualizar o responsável. Erro: " + e.getMessage());
		}		
	}

	private void validarUsuario(Idoso idoso) throws NoSuchAlgorithmException, InvalidKeySpecException, SizeLimitExceededException, LimiteCaracteresException, IllegalStateException {

		if (idoso.getSenha().length() < 5) {
			throw new LimiteCaracteresException("A senha deve ter no mínimo 5 (cinco) caracteres.");
		}
		
		if (idoso.getSenha().length() <= 20) {
			idoso.setSenha(MyUtils.criptografarPassword(idoso.getSenha()));
		}
		
		validarNomeEmail(idoso);
		
	}
	
	private void validarNomeEmail(Idoso idoso) throws IllegalStateException {
		if (idoso.getEmail().equals("") || idoso.getEmail() == null) {
			throw new IllegalStateException("Não é possível cadastrar/editar um usuário sem e-mail.");
		}
		
		if (idoso.getEmail().length() < 4) {
			throw new IllegalStateException("O e-mail que você tentou inserir para é inválido. Exemplo de e-mail válido: nomeusuario@dominio.com");
		}
		
		if (idoso.getNome().length() < 3 || idoso.getNome() == null) {
			throw new IllegalStateException("Não é possível cadastrar/editar um usuário com nome menor que 3 (três) caracteres.");
		}
	}
	
}
