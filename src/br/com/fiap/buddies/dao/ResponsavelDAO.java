package br.com.fiap.buddies.dao;

import br.com.fiap.buddies.entities.Responsavel;
import br.com.fiap.buddies.exceptions.DBException;

public interface ResponsavelDAO extends GenericDAO<Responsavel, Integer> {

	Responsavel logar(String username, String password) throws DBException;
	
}
