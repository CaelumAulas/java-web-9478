<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="br.com.caelum.agenda.dao.ContatoDao, 
				br.com.caelum.agenda.modelo.Contato,
				java.util.*,
				java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Contatos - Agenda</title>
</head>
<body>
	<% 
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	%>

	
	<table>
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>E-mail</td>
			<td>Endereço</td>
			<td>Data de Nascimento</td>
		</tr>
		
		<% for(Contato contato : contatos) { %>
			<tr>
				<td><%= contato.getId() %></td>
				<td><%= contato.getNome() %></td>
				<td><%= contato.getEmail() %></td>
				<td><%= contato.getEndereco() %></td>
				<td><%= format.format(contato.getDataNascimento().getTime()) %></td>
			</tr>
		<% } %>
	</table>
	
</body>
</html>