package br.com.fiap.buddies.bo;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.naming.SizeLimitExceededException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.buddies.dao.ResponsavelDAO;
import br.com.fiap.buddies.entities.Responsavel;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.exceptions.LimiteCaracteresException;
import br.com.fiap.buddies.security.Login;
import br.com.fiap.buddies.utils.MyUtils;

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

	public void cadastrar(Responsavel usuario) throws DBException {
		try {
			validarUsuario(usuario);
			responsavelDAO.cadastrar(usuario);
		} catch (Exception e) {
			if (e.getMessage().contains("ConstraintViolation")) {
				e.printStackTrace();
				throw new DBException("Já existe responsável cadastrado com o e-mail escolhido. Não é possível cadastrar outro usuário com o mesmo e-mail.");
			}
			e.printStackTrace();
			throw new DBException("Erro ao tentar cadastrar o responsável. Erro: " + e.getMessage());
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
	
	public void atualizar(Responsavel usuario) throws DBException {
		try {
			validarUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		
		try {
			responsavelDAO.alterar(usuario);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar atualizar o responsável. Erro: " + e.getMessage());
		}
	}
	
	public void excluir(int usuarioId) throws DBException {
		try {
			responsavelDAO.remover(usuarioId);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar excluir o usuário. Erro: " + e.getMessage());
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
			senhaNova = MyUtils.criptografarPassword(senhaNova);
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
	
	private void validarUsuario(Responsavel usuario) throws NoSuchAlgorithmException, InvalidKeySpecException, SizeLimitExceededException, LimiteCaracteresException, IllegalStateException {

		if (usuario.getSenha().length() < 5) {
			throw new LimiteCaracteresException("A senha deve ter no mínimo 5 (cinco) caracteres.");
		}
		
		if (usuario.getSenha().length() <= 20) {
			usuario.setSenha(MyUtils.criptografarPassword(usuario.getSenha()));
		}
		
		validarNomeEmail(usuario);
		
	}
	
	public List<Responsavel> listar() throws DBException {
		
		try {
			return responsavelDAO.listar();
		} catch (Exception e) {
			throw new DBException("Erro ao tentar listar os responsáveis. Erro: " + e.getMessage());
		}

	}

	public Responsavel pesquisar(int idUsuario) throws DBException {
		try {
			return responsavelDAO.pesquisar(idUsuario);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar buscar o usuário de código [" + idUsuario + "].\nErro: " + e.getMessage());
		}
	}
	
}
