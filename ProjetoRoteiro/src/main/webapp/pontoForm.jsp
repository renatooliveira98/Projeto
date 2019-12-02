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
<form action="./PontoSalvar" method="post">
		<input name="id" type="hidden" value="${ponto.id}"> <br>
		Descrição: <input type="text" name="descricao" value="${ponto.descricao}"><br>
		Coordenada X: <input type="text" name="x" value="${ponto.x}"><br>
		Coordenada Y: <input type="text" name="y" value="${ponto.y}"><br>
		<button type="submit">Salvar</button>
	</form>

</body>
</html>