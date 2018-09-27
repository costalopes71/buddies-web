package br.com.fiap.buddies.dao;

import java.util.List;

import br.com.fiap.buddies.entities.Foto;
import br.com.fiap.buddies.exceptions.DBException;

public interface FotoDAO extends GenericDAO<Foto, Integer>{

	List<Foto> listarPorIdoso(int id) throws DBException;

}
