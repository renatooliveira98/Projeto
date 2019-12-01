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
<title>Lista de roteiros</title>
</head>
<body>
	<a class="btn btn-default" href="./RoteiroForm">Cadastrar Roteiro</a>

	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>

			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
					<table class="table">
						<tr>
							<th>Id</th>
							<th>Codigo</th>
							<th>Descrição</th>
							<th>Tipo</th>
							<th><a href="./RoteiroForm">Novo Roteiro</a></th>
						</tr>

						<c:forEach var="r" items="${roteiros}">
							<tr>
								<th>${r.id}</th>
								<th>${r.codigo}</th>
								<th>${r.descricao}</th>
								<th>${r.tipo}</th>
								<th><a href='./RoteiroForm?id=${r.id}'>Editar</a> | 
								<a	href='./RoteiroForm?id=${r.id}'>Excluir</a></th>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<a href="./Painel">Painel</a>
</body>
</html>