package br.com.fiap.buddies.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	private String senhaSalva;
	
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
				idosos = idosoBO.pesquisarPorResponsavel(responsavelLogado.getId());
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
	public ModelAndView cadastrar(Idoso idoso, RedirectAttributes redirectAttribute) {
		ModelAndView model = new ModelAndView("redirect:/idoso/idosos-home");
		
		try {
			idosoBO.cadastrar(idoso);
		} catch (Exception e) {
			return MyUtils.redirectToErrorPage(e);
		}
		
		redirectAttribute.addFlashAttribute("sucesso", true);
		redirectAttribute.addFlashAttribute("operacao", "cadastrado");
		return model;
	}
	
	@GetMapping("/editar-idoso/{id}")
	public ModelAndView abrirEditarForm(@PathVariable("id") int idUsuario) {
		ModelAndView model = new ModelAndView("/editar/editar-idoso");
		Idoso idoso = null;
		try {
			idoso = idosoBO.pesquisar(idUsuario);
		} catch (Exception e) {
			return MyUtils.redirectToErrorPage(e);
		}
		
		senhaSalva = idoso.getSenha();
		model.addObject("titulo", "Editar Idoso | Buddies");
		model.addObject("idoso", idoso);
		MyUtils.incrementarBreadcrumb(model, "Idosos", "/idoso/idosos-home", "Editar");
		return model;
	}

	@PostMapping("/editar-idoso")
	public ModelAndView editar(Idoso idoso, HttpServletRequest request, RedirectAttributes redirectAttribute) {
		
		System.out.println("ID do responsavel" + idoso.getResponsavel().getId());
		
		if (idoso.getSenha() == null || idoso.getSenha().equals("")) {
			idoso.setSenha(senhaSalva);
			senhaSalva = "";
		}
		
		try {
			idosoBO.atualizar(idoso);
			redirectAttribute.addFlashAttribute("sucesso", true);
			redirectAttribute.addFlashAttribute("operacao", "editado");
			return new ModelAndView("redirect:/idoso/idosos-home");
		} catch (Exception e) {
			return MyUtils.redirectToErrorPage(e);
		}
	}
	
	@PostMapping("/excluir")
	public ModelAndView excluir(int usuarioId, RedirectAttributes redirectAttributes) {
		try {
			idosoBO.excluir(usuarioId);
		} catch (Exception e) {
			return MyUtils.redirectToErrorPage(e);
		}
		
		redirectAttributes.addFlashAttribute("sucesso", true);
		redirectAttributes.addFlashAttribute("operacao", "excluído");
		return new ModelAndView("redirect:/idoso/idosos-home");
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
