package br.com.fiap.buddies.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.buddies.dao.IdosoDAO;
import br.com.fiap.buddies.entities.Idoso;
import br.com.fiap.buddies.exceptions.DBException;

@Repository
public class IdosoDAOImpl extends GenericDAOImpl<Idoso, Integer> implements IdosoDAO {

	@Override
	public List<Idoso> listarPorResponsavel(int idResponsavel) throws DBException {
		try {
			return em.createQuery("SELECT i FROM Idoso i WHERE i.responsavel.id = :pId", Idoso.class).setParameter("pId", idResponsavel).
			getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro tentar atualizar os dados do usuário.\nERRO: " + e.getMessage());
		}
	}
	
}
