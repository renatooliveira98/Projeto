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
								<th>Roteiro</th>
								<th>Dia</th>
								<th>Hora Ida</th>
								<th>Hora Volta</th>
								<th>Onibus</th>
								<th>Motorista</th>
								<th><a href="./ProgramacaoForm">Nova Programação</a></th>
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
									<td><a href='./ProgramacaoExcluir?id=${p.id}'>Excluir</a> |
									 <a	href='./ProgramacaoForm?id=${p.id}'>Editar</a></td>

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

