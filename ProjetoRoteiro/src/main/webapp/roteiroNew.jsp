<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<title>Novo Roteiro</title>
</head>
<body>
	<form action="./RoteiroSalvar" method="get">
		Código: <input name="codigo" type="text" id="codigo">
		Descrição: <input name="tipo" type="text" id="tipo">
		Tipo: <input name="descricao" type="text" id="descricao">
		<br>
		Pontos: <select name="pontos">
					<option value="">Selecione</option>
					<c:forEach var="p" items="pontos">
						<option value="${pontos.id}" ${pontos.id == roteiro.pontos.id ? 'select' : ''}>${pontos.descricao}
					</c:forEach>
				</select>
		
		<button type="submit">Salvar</button>
	</form>

</body>
</html>