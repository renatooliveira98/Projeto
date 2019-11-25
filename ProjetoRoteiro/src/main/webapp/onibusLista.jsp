<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Placa</th>
				<th>Detalhes</th>
				<th>Situacao</th>
				<th><a href= "./OnibusForm">Novo Onibus</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="o" items="${onibus}">
			<tr>
				<td>${o.id}</td>
				<td>${o.placa}</td>
				<td>${o.detalhes}</td>
				<td>${o.situacao}</td>
				<td><a href='./OnibusForm?id=${o.id}'>Editar</a> | <a
					href='./OnibusExcluir?id=${o.id}'>Excluir</a></td>
			</tr>
			</c:forEach>
		</tbody>

	</table>
	<a href="./Painel">Painel</a>
</body>
</html>