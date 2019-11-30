<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<title>Lista de Motoristas</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Descricao</th>
				<th>Situacao</th>
				<th><a href= "./MotoristaForm">Novo Motorista</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="m" items="${motoristas}">
			<tr>
				<td>${m.id}</td>
				<td>${m.nome}</td>
				<td>${m.descricao}</td>
				<td>${m.situacao}</td>
				<td><a href='./MotoristaForm?id=${m.id}'>Editar</a> | <a
					href='./MotoristaExcluir?id=${m.id}'>Excluir</a></td>
			</tr>
			</c:forEach>
		</tbody>

	</table>
	<a href="./Painel">Painel</a>
</body>
</html>