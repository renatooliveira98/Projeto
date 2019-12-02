<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<title>Cadastrar Motorista</title>
</head>
<body class="body2">
<form action="./MotoristaSalvar" method="post">
		<input name="id" type="hidden" value="${motorista.id}"> <br>
		Nome: <input type="text" name="nome" value="${motorista.nome}"><br>
		Descricao: <input type="text" name="descricao" value="${motorista.descricao}"><br>
		Situação: <input type="text" name="situacao" value="${motorista.situacao}"><br>
		<button type="submit">Salvar</button>
	</form>

</body>
</html>