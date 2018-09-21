package br.com.fiap.buddies.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.fiap.buddies.entities.Usuario;

/**
 * Classe respons�vel por verificar e controlar a sess�o do usu�rio logado no portal buddies
 * @author Joao Lopes
 * */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("vai demonio");
		String requestURI = request.getRequestURI();
		if (!requestURI.equals("/login/") || !requestURI.equals("") || !requestURI.equals("/")) {
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
			if (usuario == null) {
				response.sendRedirect(request.getContextPath() + "/login/");
				return false;
			}
		}
		return true;
	}

}
