package br.com.fiap.buddies.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.buddies.dao.ResponsavelDAO;
import br.com.fiap.buddies.entities.Responsavel;

@Controller
@RequestMapping(value={"", "login"})
public class LoginController {

	@Autowired
	private ResponsavelDAO responsavelDAO;
	
	@GetMapping("/")
	public String abrirPaginaLogin() {
		return "home/login";
	}
	
	@PostMapping("logar")
	public ModelAndView logar(String username, String password, HttpServletRequest request) {
		
		System.out.println(username);
		System.out.println(password);
		try {
			Responsavel responsavel = responsavelDAO.logar(username, password);
			request.getSession().setAttribute("usuarioLogado", responsavel);
		} catch (Exception e) {
			ModelAndView model = new ModelAndView("home/login");
			model.addObject("message", e.getMessage());
			return model;
		}
		return new ModelAndView("home/welcome");
	}

}
