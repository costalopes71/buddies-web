package br.com.fiap.buddies.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.buddies.dao.FotoDAO;
import br.com.fiap.buddies.entities.Foto;
import br.com.fiap.buddies.exceptions.DBException;

@Service
public class FotoBO {

	@Autowired
	private FotoDAO fotoDAO;
	
	public List<Foto> listar() throws DBException {
		try {
			return fotoDAO.listar();
		} catch (Exception e) {
			throw new DBException("Erro ao tentar listar as fotos dos idosos. Erro: " + e.getMessage());
		}
	}

	public List<Foto> listarPorIdoso(int id) throws DBException {
		try {
			return fotoDAO.listarPorIdoso(id);
		} catch (Exception e) {
			throw new DBException("Erro ao tentar listar as fotos do idoso. Erro: " + e.getMessage());
		}
	}
	
}
