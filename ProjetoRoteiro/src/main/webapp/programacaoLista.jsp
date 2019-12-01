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
				<th>Roteiro</th>
				<th>Dia</th>
				<th>Hora Ida</th>
				<th>Hora Volta</th>
				<th>Onibus</th>
				<th>Motorista</th>
				<th><a href= "./ProgramacaoForm">Nova Programação</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${programacoes}">
			<tr>
				<td>${p.id}</td>
				<td>${p.roteiro.codigo}</td>
				<td>${p.dia}</td>
				<td>${p.horaIda}</td>
				<td>${p.horaVolta}</td>
				<td>${p.onibus.placa}</td>
				<td>${p.motorista.nome}</td>
				<td><a href='./ProgramacaoExcluir?id=${c.id}'>Excluir</a></td>
			</tr>
			</c:forEach>
		</tbody>

	</table>
	<a href="./Painel">Painel</a>

</body>
</html>