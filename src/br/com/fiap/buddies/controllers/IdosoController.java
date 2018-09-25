package br.com.fiap.buddies.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.buddies.bo.IdosoBO;
import br.com.fiap.buddies.bo.ResponsavelBO;
import br.com.fiap.buddies.entities.Idoso;
import br.com.fiap.buddies.entities.Responsavel;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.utils.MyUtils;

@Controller
@RequestMapping("idoso")
public class IdosoController {

	@Autowired
	private IdosoBO idosoBO;
	
	@Autowired
	private ResponsavelBO responsavelBO;
	
	@GetMapping("/idosos-home")
	public ModelAndView abrirTelaIdosos(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/home/idosos");
		
		List<Idoso> idosos = null;
		
		Responsavel responsavelLogado = recuperarUsuarioLogado(request);
		if (responsavelLogado.isAdministrador()) {
			try {
				idosos = idosoBO.listar();
			} catch (Exception e) {
				return MyUtils.redirectToErrorPage(e);
			}
		} else {
			try {
				idosos = idosoBO.listarPorResponsavel(responsavelLogado.getId());
			} catch (Exception e) {
				return MyUtils.redirectToErrorPage(e);
			}
		}
		
		model.addObject("idosos", idosos);
		model.addObject("titulo", "Idosos | Buddies");
		MyUtils.incrementarBreadcrumb(model, "Idosos");
		return model;
	}
	
	@GetMapping("/cadastrar-idoso")
	public ModelAndView abrirCadastrarForm(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/cadastrar/cadastrar-idoso");
		
		Responsavel responsavelLogado = recuperarUsuarioLogado(request);
		
		List<Responsavel> responsaveis = new ArrayList<>();
		if (!responsavelLogado.isAdministrador()) {
			responsaveis.add(responsavelLogado);
		} else {
			try {
				responsaveis = responsavelBO.listar();
			} catch (DBException e) {
				return MyUtils.redirectToErrorPage(e);
			}
		}
		
		model.addObject("estados", this.obterListaEstados());
		model.addObject("responsaveis", responsaveis);
		model.addObject("idoso", new Idoso());
		model.addObject("titulo", "Cadastrar Idoso | Buddies");
		MyUtils.incrementarBreadcrumb(model, "Idosos", "/usuario/idosos-home", "Cadastrar");
		return model;
	}
	
	@PostMapping("/cadastrar-idoso")
	public ModelAndView cadastrar(Idoso idoso) {
		ModelAndView model = new ModelAndView("redirect:/idoso/idosos-home");
		
		System.out.println(idoso.getNome());
		System.out.println(idoso.getApelido());
		System.out.println(idoso.getCpf());
		System.out.println(idoso.getDescricao());
		
		return model;
	}
	
	private List<String> obterListaEstados() {
		String[] lista = {
				"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
		return new ArrayList<>(Arrays.asList(lista));
	}

	private Responsavel recuperarUsuarioLogado(HttpServletRequest request) {
		return (Responsavel) request.getSession().getAttribute("usuarioLogado");
	}
	
}
