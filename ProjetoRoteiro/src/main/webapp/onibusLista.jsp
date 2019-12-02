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
<title>Insert title here</title>
</head>
<body class="body2">

	


	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>

			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
				
				<a  href="./OnibusForm">Novo Onibus</a>
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Placa</th>
								<th>Detalhes</th>
								<th>Situacao</th>
								<!-- <th><a  href="./OnibusForm">Novo Onibus</a></th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="o" items="${onibus}">
								<tr>
									<td>${o.id}</td>
									<td>${o.placa}</td>
									<td>${o.detalhes}</td>
									<td>${o.situacao}</td>
									<!-- <td><a href='./OnibusForm?id=${o.id}'>Editar</a> | 
									<a href='./OnibusExcluir?id=${o.id}'>Excluir</a></td> -->
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