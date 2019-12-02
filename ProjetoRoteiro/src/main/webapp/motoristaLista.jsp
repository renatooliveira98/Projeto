<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="atv.css">
<meta charset="UTF-8">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Lista de Motoristas</title>
</head>
<body class="body2">

	


	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>

			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
				<a class="btn btn-default" href="./MotoristaForm">Novo Motorista</a>
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nome</th>
								<th>Descricao</th>
								<th>Situacao</th>
								<!-- <th></th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="m" items="${motoristas}">
								<tr>
									<td>${m.id}</td>
									<td>${m.nome}</td>
									<td>${m.descricao}</td>
									<td>${m.situacao}</td>
									<c:if test="${usuario.papel.id == 2}">
									  <td><a href='./MotoristaForm?id=${m.id}'>Editar</a> |
									 <a	href='./MotoristaExcluir?id=${m.id}'>Excluir</a></td>
									 </c:if>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>
		</div>
	</div>

	<a href="./Painel">Painel</a>
</body>
</html>