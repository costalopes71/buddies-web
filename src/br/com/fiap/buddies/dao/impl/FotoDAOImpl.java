package br.com.fiap.buddies.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.buddies.dao.FotoDAO;
import br.com.fiap.buddies.entities.Foto;
import br.com.fiap.buddies.exceptions.DBException;

@Repository
public class FotoDAOImpl extends GenericDAOImpl<Foto, Integer> implements FotoDAO {

	@Override
	public List<Foto> listarPorIdoso(int id) throws DBException {
		return em.createQuery("FROM Foto f WHERE f.idoso.id = :pId", Foto.class).setParameter("pId", id).getResultList();
	}
	
}
