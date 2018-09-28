package br.com.fiap.buddies.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.buddies.bo.HistoricoConversaBO;
import br.com.fiap.buddies.entities.HistoricoConversa;
import br.com.fiap.buddies.exceptions.DBException;

@RestController
@RequestMapping("conversaws")
public class HistoricoConversaResource {

	@Autowired
	private HistoricoConversaBO conversaBO;
	
	@RequestMapping(value="listar/{id}", method=RequestMethod.GET, produces="application/json")
	public List<HistoricoConversa> listar(@PathVariable("id") int id) {
		
		try {
			return conversaBO.listarPorIdoso(id);
		} catch (DBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping(value="cadastrar")
	public boolean cadastrar(@RequestBody HistoricoConversa conversa) {
		try {
			conversaBO.cadastrar(conversa);
			return true;
		} catch (DBException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@PostMapping(value="deletar")
	public void deletar(@RequestBody HistoricoConversa conversa) {
		try {
			conversaBO.deletar(conversa);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
}
