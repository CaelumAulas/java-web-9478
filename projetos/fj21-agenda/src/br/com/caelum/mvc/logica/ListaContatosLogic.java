package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;

public class ListaContatosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
//		ContatoDao dao = new ContatoDao();
		
		System.out.println("Rodando ListaContatosLogic");
		
		Connection con = (Connection) req.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(con);
		req.setAttribute("contatos", dao.getLista());
		
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}

}
