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
						$("#lstTag").append(
					"<li class='list-group-item' value='"+ $(this).val()+ "'>"+ $(this,"option:selected").text()
					+ "<input type='checkbox' name='roteirosSelecionados' id='chkTags' class='chkTags' checked='checked' value='"
					+ $(this,"option:selected").val()+ "'></li>");
					$(this).remove();
					}
					
				});
			
				$('#lstTag').on('click','li',function() {
					$("#listaRoteiro").append("<li class='list-group-item ' name='roteirosSelecionados' value='"
					+ $(this).val() + "'>"+ $(this).text()+ "</li>");
					$(this).remove();
					return false;
				});
				
});
	</script>

<!--  class="form-control"  -->
	<form method="post" action="EstudanteSalvar">
	<input type="hidden" name="id" value="${estudante.id}">
	<input type="text" name="nome" placeholder="Nome" value="${estudante.usuario.nome}">
	<input type="text" name="nomeSocial" placeholder="Nome Social" value="${estudante.usuario.nomeSocial}">
	<input type="email" name="email" placeholder="E-mail" value="${estudante.usuario.email}">
	<input type="text" name="cpf" placeholder="CPF" value="${estudante.usuario.cpf}">
	<input type="password" name="senha" placeholder="Senha" value="${estudante.usuario.senha}">
	
	<hr>
	<label>Curso</label>
	<select name="curso">
	<c:forEach var="c" items="${cursos}">

		<option value="${c.id}" ${ c.id == estudante.curso.id ? 'selected' : ''} >${c.nome} </option>
	</c:forEach>
	</select>
	<hr>
	<label>Endereço</label><br>
	<input type="text" name="cep" placeholder="Cep" value="${estudante.usuario.endereco.cep}">
	<input type="text" name="cidade" placeholder="Cidade" value="${estudante.usuario.endereco.cidade}">
	<input type="text" name="bairro" placeholder="Bairro" value="${estudante.usuario.endereco.bairro}">
	<input type="text" name="rua" placeholder="Rua" value="${estudante.usuario.endereco.rua}">
	<input type="text" name="numero" placeholder="Numero" value="${estudante.usuario.endereco.numero}">
	
	
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
					<ul id="lstTag" class="list-group list-group-flush "></ul>
				</div>
			</div>
		</div>
		<button type="submit">Enviar</button>
		
	</form>
	<br />
</body>
</body>
</html>