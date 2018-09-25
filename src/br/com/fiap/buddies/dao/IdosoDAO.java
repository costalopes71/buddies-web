package br.com.fiap.buddies.dao;

import java.util.List;

import br.com.fiap.buddies.entities.Idoso;
import br.com.fiap.buddies.exceptions.DBException;

public interface IdosoDAO extends GenericDAO<Idoso, Integer> {

	List<Idoso> listarPorResponsavel(int idResponsavel) throws DBException;

}
