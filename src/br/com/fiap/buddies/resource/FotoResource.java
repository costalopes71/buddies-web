package br.com.fiap.buddies.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.buddies.bo.FotoBO;
import br.com.fiap.buddies.entities.Foto;
import br.com.fiap.buddies.exceptions.DBException;

@RestController
@RequestMapping("fotows")
public class FotoResource {

	@Autowired
	private FotoBO fotoBO;
	
	@RequestMapping(value="listar", method=RequestMethod.GET, produces="application/json")
	public List<Foto> listar() {
		
		try {
			return fotoBO.listar();
		} catch (DBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
