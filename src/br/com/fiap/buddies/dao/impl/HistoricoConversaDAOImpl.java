package br.com.fiap.buddies.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.buddies.dao.HistoricoConversaDAO;
import br.com.fiap.buddies.entities.HistoricoConversa;
import br.com.fiap.buddies.exceptions.DBException;

@Repository
public class HistoricoConversaDAOImpl extends GenericDAOImpl<HistoricoConversa, Integer> implements HistoricoConversaDAO{

	@Override
	public List<HistoricoConversa> listarPorIdoso(int idIdoso) throws DBException {
		return em.createQuery("FROM HistoricoConversa h WHERE h.idIdoso = :pId", HistoricoConversa.class).
				setParameter("pId", idIdoso).getResultList();
	}

	@Override
	public HistoricoConversa pesquisarPorIdosoConversa(HistoricoConversa conversa) throws Exception {
		return em.createQuery("FROM HistoricoConversa h WHERE h.idIdoso = :pIdIdoso AND h.idConversa = :pIdConversa", HistoricoConversa.class).
				setParameter("pIdIdoso", conversa.getIdIdoso()).
				setParameter("pIdConversa", conversa.getIdConversa()).getSingleResult();
	}

}
