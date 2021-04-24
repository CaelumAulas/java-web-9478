package br.com.caelum.jdbc;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.model.Contato;

public class TestaInsere {
	
	public static void main(String[] args) throws SQLException {
		
		Contato contato = new Contato("Pedro", "pedro@caelum.com", "Rua Vergueiro", Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
	
		
	}

}
