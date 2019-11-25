<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciar Onibus</title>
</head>
<body>
<form action="./OnibusSalvar" method="get">
		<input name="id" type="hidden" value="${onibus.id}">
		Placa: <input type="text" name="placa" value="${onibus.placa}"><br>
		Detalhes: <input type="text" name="detalhes" value="${onibus.detalhes}"><br>
		Situação:: <input type="text" name="situacao" value="${onibus.situacao}"><br>
		<button type="submit">Salvar</button>
	</form>
</body>
</html>