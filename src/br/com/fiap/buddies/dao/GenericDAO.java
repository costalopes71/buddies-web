package br.com.fiap.buddies.dao;

import java.util.List;

import br.com.fiap.buddies.exceptions.DBException;

public interface GenericDAO<T,K> {

	List<T> listar() throws DBException;
	void cadastrar(T entity) throws DBException;
	void alterar(T entity) throws DBException;
	T pesquisar(K codigo) throws DBException;
	void remover(K codigo) throws DBException;
	
}
