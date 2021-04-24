<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostra idade</title>
</head>
<body>

	<c:import url="cabecalho.jsp"></c:import>

	<h3>Idade digitada: ${param.idade}</h3>
	
	
	<c:import url="rodape.jsp"></c:import>


</body>
</html>