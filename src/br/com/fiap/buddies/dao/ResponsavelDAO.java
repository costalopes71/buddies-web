package br.com.fiap.buddies.dao;

import br.com.fiap.buddies.entities.Responsavel;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.security.Login;

public interface ResponsavelDAO extends GenericDAO<Responsavel, Integer> {

	Responsavel logar(Login login) throws DBException;
	void alterarNomeEmail(Responsavel usuario) throws DBException;
	void alterarSenha(int idUsuario, String senhaNova) throws DBException;

}
