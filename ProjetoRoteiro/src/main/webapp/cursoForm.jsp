<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciar Cursos</title>
</head>
<body>
	<form action="./CursoSalvar" method="get">
		<input name="id" type="hidden" value="${curso.id}"> Nome do
		Curso: <input type="text" name="nome" value="${curso.nome}">
		Instituição: <select name="instituicao">
						<option value="">Selecione</option>
							<c:forEach var="instituicao" items="${instituicoes}">
							<option value="${instituicao.id}"
							${ instituicao.id == curso.instituicao.id ? 'selected' : ''}>${instituicao.nome}
							</c:forEach>
						</option>
					</select> 
		Duração:: <input type="text" name="duracao" value="${curso.nome}">
		<button type="submit">Salvar</button>
	</form>

</body>
</html>