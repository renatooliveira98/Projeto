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

	<a class="btn btn-default" href="./instituicaoForm.jsp">Cadastrar Instituição</a>


	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>

			<div class="col-lg-10">
				<div class="container centered" id="conteudo">

					<table class="table">
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
									<td><a href="./InstituicaoExcluir?id=${i.id}">Excluir</a>|
									<a href="./InstituicaoForm?id=${i.id}">Editar</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>