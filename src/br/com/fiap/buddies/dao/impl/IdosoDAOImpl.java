package br.com.fiap.buddies.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.buddies.dao.IdosoDAO;
import br.com.fiap.buddies.entities.Idoso;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.security.Login;
import br.com.fiap.buddies.security.pbkdf2.PasswordEncryptor;

@Repository
public class IdosoDAOImpl extends GenericDAOImpl<Idoso, Integer> implements IdosoDAO {

	@Override
	public List<Idoso> pesquisarPorResponsavel(int idResponsavel) throws DBException {
		try {
			return em.createQuery("SELECT i FROM Idoso i WHERE i.responsavel.id = :pId", Idoso.class).setParameter("pId", idResponsavel).
			getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro tentar atualizar os dados do usuário.\nERRO: " + e.getMessage());
		}
	}

	@Override
	public List<Idoso> listarComResponsavel() throws DBException {
		try {
			return em.createQuery("SELECT i FROM Idoso i JOIN FETCH i.responsavel", Idoso.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro tentar atualizar os dados do usuário.\nERRO: " + e.getMessage());
		}
	}
	
	@Override
	public Idoso logar(Login login) throws DBException {

		Idoso idoso = null;

		try {
			idoso = em.createQuery("SELECT DISTINCT(i) FROM Idoso i WHERE i.email = :pEmail", Idoso.class).
					setParameter("pEmail", login.getUsername().toLowerCase()).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Login ou senha incorreto(s).");
		}

		try {
			boolean validPassword = PasswordEncryptor.validatePassword(login.getPassword(), idoso.getSenha());

			if (!validPassword) {
				throw new DBException("Login ou senha incorreto(s).");
			}

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			throw new DBException("ERRO 2001: Erro interno ao tentar validar a senha. Entre em contato com o suporte do Buddies.");
		}

		return idoso;
	}
	
}
