package br.com.fiap.buddies.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.buddies.bo.ResponsavelBO;
import br.com.fiap.buddies.entities.Responsavel;
import br.com.fiap.buddies.security.Login;

@Controller
@RequestMapping(value={"", "login"})
public class LoginController {

	@Autowired
	private ResponsavelBO responsavelBO;
	
	@GetMapping("/")
	public ModelAndView abrirPaginaLogin() {
		ModelAndView model = new ModelAndView("home/login");
		model.addObject("titulo", "Login | Buddies");
		model.addObject("login", new Login());
		return model;
	}
	
	@PostMapping("logar")
	public ModelAndView logar(Login login, HttpServletRequest request) {
		
		try {
			Responsavel responsavel = responsavelBO.logar(login);
			request.getSession().setAttribute("usuarioLogado", responsavel);
		} catch (Exception e) {
			ModelAndView model = new ModelAndView("home/login");
			model.addObject("message", e.getMessage());
			return model;
		}
		
		return this.paginaBoasvindas();
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return abrirPaginaLogin();
	}
	
	@GetMapping("/welcome")
	public ModelAndView voltar2Welcome() {
		return paginaBoasvindas();
	}

	private ModelAndView paginaBoasvindas() {
		ModelAndView  model = new ModelAndView("home/welcome");
		model.addObject("paginaAtiva", "Quem Somos");
		model.addObject("titulo", "Quem Somos | Buddies");
		return model;
	}
	
}
