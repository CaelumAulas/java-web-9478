package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.model.Contato;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) throws SQLException {

//		Connection conexao = new ConnectionFactory().getConnection();

		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?,?,?,?)";

		try {

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());

			// Calendar > sql.Date
			java.sql.Date dataSql = new java.sql.Date(contato.getDataNascimento().getTimeInMillis());

			stmt.setDate(4, dataSql);

			System.out.println("Contato adicionado!");

			stmt.execute();
			stmt.close();

			this.connection.close();

		} catch (SQLException ex) {
			throw ex; 
		}

	}

	public List<Contato> getLista() throws Exception {
		
		String sql = "select * from contatos";
		
		List<Contato> contatos = new ArrayList<>();
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet result = stmt.executeQuery();
			// 1(nome=Joao,email=joao@caelum.com,endereco=Rua Xpto,dataNascimento=13/04/2021)
			
			while (result.next()) {
				
				String nome = result.getString("nome");
				String email = result.getString("email");
				String endereco = result.getString("endereco");
				java.sql.Date dataSql =	result.getDate("dataNascimento");
				
//				java.sql.Date > Calendar
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(dataSql);
				
//				Contato contato = new Contato(nome, email, endereco, dataNascimento);
		
				contatos.add(new Contato(nome, email, endereco, dataNascimento));
			}
			
			this.connection.close();
			
			return contatos;
		} catch (SQLException e) {
			throw new Exception(e);
		}

	}
	
}
