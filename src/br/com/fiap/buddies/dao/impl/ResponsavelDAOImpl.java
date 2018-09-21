package br.com.fiap.buddies.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.stereotype.Repository;

import br.com.fiap.buddies.dao.ResponsavelDAO;
import br.com.fiap.buddies.entities.Responsavel;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.security.pbkdf2.PasswordEncryptor;

@Repository
public class ResponsavelDAOImpl extends GenericDAOImpl<Responsavel, Integer> implements ResponsavelDAO {

	@Override
	public Responsavel logar(String username, String password) throws DBException {

		Responsavel usuario = null;

		try {
			usuario = em.createQuery("SELECT DISTINCT(u) FROM Responsavel u WHERE u.email = :pEmail", Responsavel.class).
					setParameter("pEmail", username).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Login ou senha incorreto(s).");
		}

		try {
			boolean validPassword = PasswordEncryptor.validatePassword(password, usuario.getSenha());

			if (!validPassword) {
				throw new DBException("Login ou senha incorreto(s).");
			}

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			throw new DBException("ERRO 2001: Erro interno ao tentar validar a senha. Entre em contato com o suporte do Buddies.");
		}

		return usuario;
	}

}
