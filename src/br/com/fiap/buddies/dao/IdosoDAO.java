package br.com.fiap.buddies.dao;

import java.util.List;

import br.com.fiap.buddies.entities.Idoso;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.security.Login;

public interface IdosoDAO extends GenericDAO<Idoso, Integer> {

	List<Idoso> pesquisarPorResponsavel(int idResponsavel) throws DBException;

	List<Idoso> listarComResponsavel() throws DBException;

	Idoso logar(Login login) throws DBException;

}
