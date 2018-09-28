package br.com.fiap.buddies.dao;

import java.util.List;

import br.com.fiap.buddies.entities.HistoricoConversa;
import br.com.fiap.buddies.exceptions.DBException;

public interface HistoricoConversaDAO extends GenericDAO<HistoricoConversa , Integer>{

	List<HistoricoConversa> listarPorIdoso(int id) throws DBException;

	HistoricoConversa pesquisarPorIdosoConversa(HistoricoConversa conversa) throws Exception;

}
