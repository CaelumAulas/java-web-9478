package br.com.caelum.tarefas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.caelum.tarefas.modelo.Usuario;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println("Exec. preHandle");

		String uri = request.getRequestURI();
		
		if (uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") 
				|| uri.contains("resources")) {
			return true;
		}
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		if (usuario != null) {
			return true;
		}
		
		response.sendRedirect("loginForm");
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		System.out.println("Exec. postHandle");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		System.out.println("Exec. afterCompletion");
	}
	

}
