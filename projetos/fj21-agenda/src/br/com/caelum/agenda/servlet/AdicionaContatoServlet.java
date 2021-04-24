package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// nome, email, endereco e dataNascimento GET
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");;
		String endereco = req.getParameter("endereco");;
		String dataEmTexto = req.getParameter("dataNascimento");;
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		
		// String > Date > Calendar
		Calendar dataEmCalendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			dataEmCalendar.setTime(format.parse(dataEmTexto));
		} catch (ParseException e) {
			System.out.println("Falha na formatação da data");
		}
		
		contato.setDataNascimento(dataEmCalendar);
		
		// salvar no banco!!
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("contato-adicionado.jsp");
		
		req.setAttribute("sistema", "Agenda - Curso FJ-21");
		
		dispatcher.forward(req, resp);
		
	}

}
