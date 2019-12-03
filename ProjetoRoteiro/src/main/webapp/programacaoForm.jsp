<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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

	<%@include file="./includes/header.jsp"%>

	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>

			<div class="col-lg-10">
				<div class="container centered" id="conteudo">

					<form action="./ProgramacaoSalvar" method="post">

						<div class="row">
							<div class="form-group col-lg-6">
								<label for="roteiro">Código do roteiro</label> <select
									class="form-control" id="roteiro" name="roteiro">
									<option value="">Selecione</option>
									<c:forEach var="r" items="${roteiros}">
										<option value="${r.id}">${r.codigo}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-lg-6">
								<label for="data">Data</label> <input class="form-control"
									type="date" id="data" name="dia">
							</div>
						</div>


						<div class="row">
							<div class="form-group col-lg-6">
								<label for="horaIda">Hora de saída</label> <input
									class="form-control" type="time" name="horaIda" if="horaIda">
							</div>
							<div class="form-group col-lg-6">
								<label for="horaVolta">Hora de retorno</label> <input
									class="form-control" type="time" name="horaVolta"
									id="horaVolta">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-lg-6">
								<label for="onibus">Placa do ônibus</label> <select
									class="form-control" name="onibus" id="onibus">
									<option value="">Selecione</option>
									<c:forEach var="o" items="${onibus}">
										<option value="${o.id}">${o.placa}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-lg-6">
								<label for="motorista">Nome do motorista</label> <select
									class="form-control" id="motorista" name="motorista">
									<option value="">Selecione</option>
									<c:forEach var="m" items="${motoristas}">
										<option value="${m.id}">${m.nome}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<button class="btn btnPadrao" type="submit">Salvar</button>
					</form>

				</div>
			</div>
		</div>
	</div>
	<%@include file="./includes/footer.jsp"%>
</body>
</html>