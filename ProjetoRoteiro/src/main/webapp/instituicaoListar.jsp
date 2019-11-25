<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="./instituicaoForm.jsp">Cadastrar Instituição</a>
	<table border="1px">
		<thead>
			<tr>
				<th>Nome</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${instituicoes}">
				<tr>
					<td>${i.nome}</td>
					<td><a href="./InstituicaoExcluir?id=${i.id}">Excluir</a>|<a>Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>