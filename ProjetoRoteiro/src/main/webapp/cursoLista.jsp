<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<title>Lista de Cursos</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Instituicao</th>
				<th>Duracao</th>
				<th><a href= "./CursoForm">Novo Curso</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${cursos}">
			<tr>
				<td>${c.id}</td>
				<td>${c.nome}</td>
				<td>${c.instituicao.nome}</td>
				<td>${c.duracao}</td>
				<td><a href='./CursoForm?id=${c.id}'>Editar</a> | <a
					href='./CursoExcluir?id=${c.id}'>Excluir</a></td>
			</tr>
			</c:forEach>
		</tbody>

	</table>
	<a href="./Painel">Painel</a>
</body>
</html>