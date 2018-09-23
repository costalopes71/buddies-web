package br.com.fiap.buddies.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.buddies.bo.ResponsavelBO;
import br.com.fiap.buddies.entities.Responsavel;
import br.com.fiap.buddies.exceptions.DBException;
import br.com.fiap.buddies.security.Login;
import br.com.fiap.buddies.utils.MyUtils;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private ResponsavelBO responsavelBO;

	@GetMapping("/usuarios-home")
	public ModelAndView abrirTelaUsuarios() {
		ModelAndView model = new ModelAndView("/home/usuarios");
		List<Responsavel> usuarios = null;
		try {
			usuarios = responsavelBO.listar();
		} catch (Exception e) {
			return MyUtils.redirectToErrorPage(e);
		}
		model.addObject("usuarios", usuarios);
		MyUtils.incrementarBreadcrumb(model, "Reponsáveis");
		return model;
	}
	
	@GetMapping("/perfil-usuario")
	public ModelAndView abrirPerfilUsuarioLogado(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/home/perfil-usuario");
		Responsavel usuarioLogado = (Responsavel) request.getSession().getAttribute("usuarioLogado");
		model.addObject("usuario", usuarioLogado);
		MyUtils.incrementarBreadcrumb(model, "Minha Conta");
		return model;
	}
	
	@PostMapping("editar-perfil")
	public ModelAndView editarPerfilUsuarioLogado(@ModelAttribute Responsavel usuario, HttpServletRequest request, RedirectAttributes redirectAttribute) {
		ModelAndView model = new ModelAndView("redirect:/usuario/perfil-usuario");
		
		try {
			responsavelBO.atualizarNomeEmailUsuarioLogado(usuario);
		} catch (Exception e) {
			return MyUtils.redirectToErrorPage(e);
		}
		
		Responsavel usuarioLogado = (Responsavel) request.getSession().getAttribute("usuarioLogado");
		usuarioLogado.setEmail(usuario.getEmail());
		usuarioLogado.setNome(usuario.getNome());
		request.getSession().setAttribute("usuarioLogado", usuarioLogado);
		
		redirectAttribute.addFlashAttribute("sucesso", true);
		redirectAttribute.addFlashAttribute("operacao", "Dados alterados ");
		return model;
	}

	@GetMapping("/alterar-senha")
	public ModelAndView abrirTelaAlteracaoSenhaUsuarioLogado() {
		ModelAndView model = new ModelAndView("/editar/editar-senha");
		MyUtils.incrementarBreadcrumb(model, "Minha Conta", "/usuario/perfil-usuario", "Alterar Senha");
		return model;
	}
	
	@PostMapping("/alterar-senha")
	public ModelAndView alterarSenhaUsuarioLogado(@RequestParam("senhaAtual") String senhaAtual, @RequestParam("senhaNova") String senhaNova, 
			@RequestParam("repeticaoSenhaNova") String repeticaoSenha, HttpServletRequest request, RedirectAttributes redirectAttribute) {
		
		ModelAndView model = new ModelAndView("redirect:/usuario/alterar-senha");
		Responsavel usuarioLogado = (Responsavel) request.getSession().getAttribute("usuarioLogado");
		Login login = new Login();
		login.setPassword(senhaAtual);
		login.setUsername(usuarioLogado.getEmail());
		
		if (validaSenhaNova(senhaNova, repeticaoSenha, redirectAttribute) == false || validaSenhaAtual(login, redirectAttribute) == false) {
			MyUtils.incrementarBreadcrumb(model, "Minha Conta", "/usuario/perfil-usuario", "Alterar Senha");
			return model;
		}

		try {
			responsavelBO.atualizarSenha(usuarioLogado.getId(), senhaNova);
		} catch (DBException e) {
			return MyUtils.redirectToErrorPage(e);
		}
	
		redirectAttribute.addFlashAttribute("sucesso", true);
		redirectAttribute.addFlashAttribute("operacao", "Senha alterada com sucesso.");
		MyUtils.incrementarBreadcrumb(model, "Minha Conta", "/usuario/perfil-usuario", "Alterar Senha");
		return model;
	}

	private boolean validaSenhaAtual(Login login, RedirectAttributes redirectAttribute) {
		try {
			responsavelBO.logar(login);
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("operacao", "Erro ao tentar alterar a senha. Senha atual não confere.");
			redirectAttribute.addFlashAttribute("msgSenhaAtual", "Senha atual não confere.");
			redirectAttribute.addFlashAttribute("insucesso", true);
			return false;
		}
		return true;
	}

	private boolean validaSenhaNova(String senhaNova, String repeticaoSenha, RedirectAttributes redirectAttribute) {
		if (!senhaNova.equals(repeticaoSenha)) {
			redirectAttribute.addFlashAttribute("operacao", "Erro ao tentar alterar a senha. A senha nova não coincide com a repetição.");
			redirectAttribute.addFlashAttribute("msgCoincidencia", "Senhas não coincidem.");
			redirectAttribute.addFlashAttribute("insucesso", true);
			return false;
		}
		return true;
	}
	
}
