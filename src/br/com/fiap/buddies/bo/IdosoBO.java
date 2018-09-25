package br.com.fiap.buddies.bo;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.buddies.dao.IdosoDAO;
import br.com.fiap.buddies.entities.Idoso;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.exceptions.LimiteCaracteresException;
import br.com.fiap.buddies.utils.MyUtils;

@Service
public class IdosoBO {

	@Autowired
	private IdosoDAO idosoDAO;
	
	public List<Idoso> listar() throws DBException {
		try {
			return idosoDAO.listar();
		} catch (Exception e) {
			throw new DBException("Erro ao tentar listar os idosos. Erro: " + e.getMessage());
		}
	}

	public List<Idoso> listarPorResponsavel(int  idResponsavel) throws DBException {
		try {
			return idosoDAO.listarPorResponsavel(idResponsavel);
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

	private void validarIdoso(Idoso idoso) throws NoSuchAlgorithmException, InvalidKeySpecException, LimiteCaracteresException {
		
		if (idoso.getSenha().length() < 5) {
			throw new LimiteCaracteresException("A senha deve ter no m�nimo 5 (cinco) caracteres.");
		}
		
		if (idoso.getSenha().length() <= 20) {
			idoso.setSenha(MyUtils.criptografarPassword(idoso.getSenha()));
		}
		
		if (idoso.getEmail().equals("") || idoso.getEmail() == null) {
			throw new IllegalStateException("N�o � poss�vel cadastrar/editar um usu�rio sem e-mail.");
		}
		
		if (idoso.getEmail().length() < 4) {
			throw new IllegalStateException("O e-mail que voc� tentou inserir para � inv�lido. Exemplo de e-mail v�lido: nomeusuario@dominio.com");
		}
		
		if (idoso.getNome().length() < 3 || idoso.getNome() == null) {
			throw new IllegalStateException("N�o � poss�vel cadastrar/editar um usu�rio com nome menor que 3 (tr�s) caracteres.");
		}
		
	}
	
}
