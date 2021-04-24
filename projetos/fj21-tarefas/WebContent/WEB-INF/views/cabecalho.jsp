<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

<!-- 	<img src="imagens/caelum.png" width="600" /> -->
	
	<c:url value="/resources/imagens/caelum.png" var="logoCaelum"></c:url>
	<img src="${logoCaelum}" width="600" />
	
	<h2>Agenda de Contatos do(a) Caelum</h2>
	<hr />

</body>
</html>