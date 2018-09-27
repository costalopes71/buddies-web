package br.com.fiap.buddies.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.buddies.bo.ResponsavelBO;
import br.com.fiap.buddies.entities.Responsavel;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.resource.entities.LoginResponse;
import br.com.fiap.buddies.security.Login;

@RestController
@RequestMapping("responsavelws")
public class ResponsavelResource {

	@Autowired
	private ResponsavelBO responsavelBO;
	
	@RequestMapping(value="listar", method=RequestMethod.GET, produces="application/json")
	public List<Responsavel> listar() {
		
		List<Responsavel> responsaveis = null;
		try {
			responsaveis = responsavelBO.listar();
		} catch (DBException e) {
			e.printStackTrace();
			return null;
		}
		
		for (Responsavel responsavel : responsaveis) {
			responsavel.setSenha("");
		}
		
		return responsaveis;
	}

	@RequestMapping(value="logar", method=RequestMethod.POST, produces="application/json")
	public LoginResponse validarLogin(@RequestBody Login usuario) {
		
		try {
			Responsavel responsavel = responsavelBO.logar(usuario); 
			if (responsavel != null) {
				return new LoginResponse(true, "Logado com sucesso!", responsavel.getNome(), responsavel.getEmail(), responsavel.getId());
			} else {
				return new LoginResponse(false, "Login inválido.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new LoginResponse(false, e.getMessage());
		}
		
	}
	
}
