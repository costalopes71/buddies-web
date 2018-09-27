package br.com.fiap.buddies.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.buddies.bo.FotoBO;
import br.com.fiap.buddies.entities.Foto;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.resource.entities.FotoResponse;

@RestController
@RequestMapping("fotows")
public class FotoResource {

	@Autowired
	private FotoBO fotoBO;
	
	@RequestMapping(value="listar", method=RequestMethod.GET, produces="application/json")
	public List<FotoResponse> listar() {
		
		List<Foto> fotosBD = null;
		try {
			fotosBD = fotoBO.listar();
			return criarListaFotoResponse(fotosBD);
		} catch (DBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="pesquisarfotos/{id}", method=RequestMethod.GET, produces="application/json")
	public List<FotoResponse> listarPorIdoso(@PathVariable("id") int id) {
		
		List<Foto> fotosBD = null;
		try {
			fotosBD = fotoBO.listarPorIdoso(id);
			return criarListaFotoResponse(fotosBD);
		} catch (DBException e) {
			e.printStackTrace();
			return null;
		}
	}

	private List<FotoResponse> criarListaFotoResponse(List<Foto> fotosBD) {
		List<FotoResponse> fotosWS = new ArrayList<>();
		for (Foto foto : fotosBD) {
			fotosWS.add(new FotoResponse(foto.getId(), foto.getUrl()));
		}
		return fotosWS;
	}
	
}
