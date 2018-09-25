package br.com.fiap.buddies.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.buddies.dao.IdosoDAO;
import br.com.fiap.buddies.entities.Idoso;
import br.com.fiap.buddies.exceptions.DBException;

@Service
public class IdosoBO {

	@Autowired
	private IdosoDAO idosoDAO;
	
	public List<Idoso> listar() throws DBException {
		try {
			return idosoDAO.listar();
		} catch (Exception e) {
			throw new DBException("Erro ao tentar listar os idosos. Erro: " + e.getMessage());
		}
	}

	public List<Idoso> listarPorResponsavel(int  idResponsavel) throws DBException {
		try {
			return idosoDAO.listarPorResponsavel(idResponsavel);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar listar os idosos. Erro: " + e.getMessage());
		}
	}
	
}
