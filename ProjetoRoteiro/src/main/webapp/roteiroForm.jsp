<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Roteiro</title>
</head>
<body>
	<form action="./RoteiroSalvar" method="get">
		<input name="id" type="hidden" value="${roteiro.id}">
		Codigo: <input name="codigo" type="text" value="${roteiro.codigo}">
		Descrição: <input name="descricao" type="text" value="${roteiro.descricao}">
		Tipo <input name="tipo" type="text" value="${roteiro.tipo}">
	</form>
</body>
</html>