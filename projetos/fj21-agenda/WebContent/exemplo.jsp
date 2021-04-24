<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Primeira JSP :)</title>
</head>
<body>
	
	<!-- comentário em HTML -->
	<%-- comentário em JSP --%>
	
	<% 
		String nome = "Caelum";
	%>
	
	<% System.out.println(nome); %>
	
	<% out.println(nome); %>
	
	<%= nome %>

</body>
</html>