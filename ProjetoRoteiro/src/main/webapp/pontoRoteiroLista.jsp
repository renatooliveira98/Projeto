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
<title>Lista de pontos</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="body2">

	<%@include file="./includes/footer.jsp"%>

	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>

			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
					<a href="./RoteiroForm">Novo Ponto</a>
					<table class="table">
						<tr>
							<th>Id</th>
							<th>Descrição</th>
							<th>X</th>
							<th>Y</th>
							<!-- <th><a href="./RoteiroForm">Novo Roteiro</a></th>  -->
						</tr>

						<c:forEach var="p" items="${pontos}">
							<tr>
								<th>${p.id}</th>
								<th><a href='./PontoRoteiroListar?idRoteiro=${p.id}'>
										${p.descricao}</a></th>
								<th>${p.x}</th>
								<th>${p.y}</th>
								<c:if test="${idRoteiro != null}">
									<th><a href='./RoteiroForm?id=${r.id}'>Editar</a> | <a
										href='./RoteiroExcluir?id=${r.id}'>Excluir</a></th>
								</c:if>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<a href="./Painel">Painel</a>

	<%@include file="./includes/footer.jsp"%>
</body>
</html>