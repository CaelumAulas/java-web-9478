<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Contato</title>

	<link href="css/jquery.css" rel="stylesheet">
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
</head>
<body>

	<form action="adicionaContato" method="post">
	
		<label>Nome:</label>
		<input type="text" id="nome" name="nome"/> <br/>
		
		<label>E-mail:</label>
		<input type="text" id="email" name="email"/> <br/>
		
		<label>Endereço:</label>
		<input type="text" id="endereco" name="endereco" /> <br/>
		
		<caelum:campoData label="Data de Nascimento" id="dataNascimento"/>
		
		
		<input type="submit" value="Enviar"/>
	</form>

</body>
</html>