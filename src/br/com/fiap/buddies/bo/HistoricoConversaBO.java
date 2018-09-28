package br.com.fiap.buddies.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.buddies.dao.HistoricoConversaDAO;
import br.com.fiap.buddies.entities.HistoricoConversa;
import br.com.fiap.buddies.exceptions.DBException;

@Service
public class HistoricoConversaBO {

	@Autowired
	private HistoricoConversaDAO conversaDAO;

	public List<HistoricoConversa> listarPorIdoso(int id) throws DBException {
		
		try {
			return conversaDAO.listarPorIdoso(id);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar recuperar o historico de conversas. Erro: " + e.getMessage());
		}
		
	}

	public void cadastrar(HistoricoConversa conversa) throws DBException {
		try {
			conversaDAO.cadastrar(conversa);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar cadastrar a conversa no banco de dados. Erro: " + e.getMessage());
		}
	}

	public void deletar(HistoricoConversa conversa) throws DBException {
		try {
			int codigo = conversaDAO.pesquisarPorIdosoConversa(conversa).getCodigo();
			conversaDAO.remover(codigo);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar deletar a conversa do banco de dados. Erro: " + e.getMessage());
		}
	}
	
	
}
