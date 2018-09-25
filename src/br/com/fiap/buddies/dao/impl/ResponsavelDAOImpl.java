package br.com.fiap.buddies.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.buddies.dao.ResponsavelDAO;
import br.com.fiap.buddies.entities.Responsavel;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.security.Login;
import br.com.fiap.buddies.security.pbkdf2.PasswordEncryptor;

@Repository
public class ResponsavelDAOImpl extends GenericDAOImpl<Responsavel, Integer> implements ResponsavelDAO {

	@Override
	public Responsavel logar(Login login) throws DBException {

		Responsavel usuario = null;

		try {
			usuario = em.createQuery("SELECT DISTINCT(u) FROM Responsavel u WHERE u.email = :pEmail", Responsavel.class).
					setParameter("pEmail", login.getUsername().toLowerCase()).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Login ou senha incorreto(s).");
		}

		try {
			boolean validPassword = PasswordEncryptor.validatePassword(login.getPassword(), usuario.getSenha());

			if (!validPassword) {
				throw new DBException("Login ou senha incorreto(s).");
			}

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			throw new DBException("ERRO 2001: Erro interno ao tentar validar a senha. Entre em contato com o suporte do Buddies.");
		}

		return usuario;
	}

	@Override
	@Transactional
	public void alterarNomeEmail(Responsavel usuario) throws DBException {
		try {
			em.createQuery("UPDATE Responsavel u SET u.nome = :pNome, u.email = :pEmail WHERE u.id = :pId").setParameter("pNome", usuario.getNome()).
				setParameter("pEmail", usuario.getEmail()).setParameter("pId", usuario.getId()).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro tentar atualizar os dados do usuário.\nERRO: " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public void alterarSenha(int idUsuario, String senhaNova) throws DBException {
		try {
			em.createQuery("UPDATE Responsavel u SET u.senha = :pSenha WHERE u.id = :pId").setParameter("pSenha", senhaNova).
				setParameter("pId", idUsuario).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro tentar atualizar a senha do usuário.\nERRO: " + e.getMessage());
		}
	}
	
}
