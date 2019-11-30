<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
	<a href="./EstudanteForm">Cadastrar Estudante</a>
	<table border="1px">
		<thead>
			<tr>
				<th>Nome</th>
				<th>CPF</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${estudantes}">
				<tr>
					<td>${ e.nome}</td>
					<td>${e.cpf}</td>
					<td><a href="./EstudanteExcluir?id=${e.id}">Excluir</a>|<a href="./EstudanteForm?id=${e.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>