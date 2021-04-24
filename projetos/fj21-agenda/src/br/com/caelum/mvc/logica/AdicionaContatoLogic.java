package br.com.caelum.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AdicionaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		// nome, email, endereco e dataNascimento GET
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataEmTexto = req.getParameter("dataNascimento");

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

		return "contato-adicionado.jsp";

	}

}
