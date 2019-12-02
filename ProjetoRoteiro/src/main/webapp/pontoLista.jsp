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
<title>Lista de Pontos</title>
</head>
<body class="body2">
	



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
								<th><a href="./PontoForm">Novo ponto</a>  </th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${pontos}">
								<tr>
									<td>${p.id}</td>
									<td>${p.descricao}</td>
									<td>${p.x}</td>
									<td>${p.y}</td>
									<c:if test="${idRoteiro == null}">
										<td><a href='./PontoForm?id=${p.id}'>Editar</a> |
									 	<a	href='./PontoExcluir?id=${p.id}'>Excluir</a></td>
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