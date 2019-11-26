<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<title></title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="atv.css">
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#listaRoteiro").on("click","li",function() {
				//Váriavel para checar se já existe na lista
				var chkRptTag = false;
				var atv = $(this).text();
					$('#lstTag li').each(function() {
						haveSomeLi = true;
						var current = $(this).text();
							if (current == atv) {
								chkRptTag = true;
							}
					});
					if (!chkRptTag) {
						$("#lstTag").append("<li class='list-group-item' value='"
																			+ $(
																					this)
																					.val()
																			+ "'>"
																			+ $(
																					this,
																					"option:selected")
																					.text()
																			+ "<input type='checkbox' name='reteirosSelecionados' id='chkTags' class='chkTags' checked='checked' value='"
																			+ $(
																					this,
																					"option:selected")
																					.val()
																			+ "'></li>");
													$(this).remove();
												}
											});
							$('#lstTag').on('click','li',function() {
								$("#atvs").append("<li class='list-group-item AtividadeOSId' name='reteirosSelecionados' value='"
														+ $(this).val() + "'>"
														+ $(this).text()
														+ "</li>");
										$(this).remove();
										
										return false;
									});

						});
	</script>
	<style>
.chkTags {
	display: none;
}

#lstTag li {
	cursor: pointer;
}
</style>
<!--  class="form-control"  -->
	<form method="post" action="EstudanteSalvar">
	<input type="text" name="nome" placeholder="Nome">
	<input type="text" name="nomeSocial" placeholder="Nome Social">
	<input type="email" name="email" placeholder="E-mail">
	<input type="text" name="cpf" placeholder="CPF">
	<input type="password" name="senha" placeholder="Senha">
	
	<hr>
	<label>Curso</label>
	<select name="curso">
	<c:forEach var="c" items="${cursos}">
		<option value="${c.id}">${c.nome}</option>
	</c:forEach>
	</select>
	<hr>
	<label>Endereço</label><br>
	<input type="text" name="cep" placeholder="Cep">
	<input type="text" name="cidade" placeholder="Cidade">
	<input type="text" name="bairro" placeholder="Bairro">
	<input type="text" name="rua" placeholder="Rua">
	<input type="text" name="numero" placeholder="Numero">
	
	
		<div class="row">
			<div class="col-lg-6 col-sm-12">
				<label>Roteiros Cadastrados</label>
				<div class="form-group">
					<div class=" ms-lista">
						<ul class="list-group list-group-flush" id="listaRoteiro">
							<c:forEach var="r" items="${roteiros}">
								<li class="list-group-item" value="${r.id}">${r.codigo}</li>
							</c:forEach>

						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-sm-12">
				<label>Roteiros do Estudante</label>
				<div class="ms-lista">
					<ul id="lstTag" class="list-group list-group-flush listaAtv"></ul>
				</div>
			</div>
		</div>
		<button type="submit">Enviar</button>
		
	</form>
	<br />
</body>
</body>
</html>