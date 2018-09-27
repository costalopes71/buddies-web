package br.com.fiap.buddies.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.buddies.bo.IdosoBO;
import br.com.fiap.buddies.entities.Idoso;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.resource.entities.LoginResponse;
import br.com.fiap.buddies.security.Login;

@RestController
@RequestMapping("idosows")
public class IdosoResource {

	@Autowired
	private IdosoBO idosoBO;
	
	@RequestMapping(value="listar", method=RequestMethod.GET, produces="application/json")
	public List<Idoso> listar() {
		
		List<Idoso> idosos = null;
		try {
			idosos = idosoBO.listar();
		} catch (DBException e) {
			e.printStackTrace();
			return null;
		}
		
		for (Idoso idoso : idosos) {
			idoso.setSenha("");
		}
		
		return idosos;
	}

	@RequestMapping(value="logar", method=RequestMethod.POST, produces="application/json")
	public LoginResponse validarLogin(@RequestBody Login usuario) {
		
		try {
			Idoso idoso = idosoBO.logar(usuario);
			if (idoso != null) {
				return new LoginResponse(true, "Logado com sucesso!", idoso.getNome(), idoso.getEmail(), idoso.getId());
			} else {
				return new LoginResponse(false, "Login inválido.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new LoginResponse(false, e.getMessage());
		}
		
	}
	
}
