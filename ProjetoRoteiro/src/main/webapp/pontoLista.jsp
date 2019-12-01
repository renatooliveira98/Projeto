<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="atv.css">
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Lista de Motoristas</title>
</head>
<body class="body2">

	<a class="btn btn-default" href="./PontoForm">Cadastrar novo ponto</a>


	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>

			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Descricao</th>
								<th>Coordenada X<br>Latitude</th>
								<th>Coordenada Y<br>Longitude</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${pontos}">
								<tr>
									<td>${p.id}</td>
									<td>${p.descricao}</td>
									<td>${p.x}</td>
									<td>${p.y}</td>
									<td><a href='./PontoForm?id=${p.id}'>Editar</a> |
									 <a	href='./PontoExcluir?id=${p.id}'>Excluir</a></td>
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