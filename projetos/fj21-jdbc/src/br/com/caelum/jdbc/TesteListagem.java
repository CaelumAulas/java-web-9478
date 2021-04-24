package br.com.caelum.jdbc;

import java.util.List;

import br.com.caelum.jdbc.model.Contato;

public class TesteListagem {
	
	public static void main(String[] args) throws Exception {
		
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.getLista();
			
//		for (int i = 0; i < contatos.size(); i++) {
//			System.out.println("Nome: " + contatos.get(i).getNome());
//		}
		
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + contato.getDataNascimento().getTime() + "\n");
		}
		
	}

}
