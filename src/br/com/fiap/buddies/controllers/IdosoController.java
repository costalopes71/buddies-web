package br.com.fiap.buddies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.buddies.bo.IdosoBO;
import br.com.fiap.buddies.entities.Idoso;
import br.com.fiap.buddies.utils.MyUtils;

@Controller
@RequestMapping("idoso")
public class IdosoController {

	@Autowired
	private IdosoBO idosoBO;
	
	@GetMapping("/idosos-home")
	public ModelAndView abrirTelaIdosos() {
		ModelAndView model = new ModelAndView("/home/idosos");
		
		List<Idoso> idosos = null;
		try {
			idosos = idosoBO.listar();
		} catch (Exception e) {
			return MyUtils.redirectToErrorPage(e);
		}
		
		model.addObject("idosos", idosos);
		model.addObject("titulo", "Idosos | Buddies");
		MyUtils.incrementarBreadcrumb(model, "Idosos");
		return model;
	}
	
	
	
}
