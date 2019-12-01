<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<title>Insert title here</title>
<title>Cadastrar estudante</title>

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

	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>
			
			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
	<form method="post" action="EstudanteSalvar">
	
	<input type="hidden" name="id" value="${estudante.id}">
	<h1 class="tituloForm">Cadastrar Estudante</h1>
		<hr>
	<div class="row">
		<div class="form-group col-lg-6"> 
		<label for="nome">Nome</label> 
			<input class="form-control"  type="text" name="nome"  id="nome" value="${estudante.usuario.nome}">
		</div>
		<div class="form-group col-lg-6"> 
		<label for="nomeSocial">Nome Social</label> 
			<input class="form-control"  type="text" name="nomeSocial" id="nomeSocial" value="${estudante.usuario.nomeSocial}">
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-lg-12"> 
		<label for="email">Email</label> 
			<input class="form-control"  type="email" name="email" id="email" value="${estudante.usuario.email}">
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-lg-6">
			<label for="cpf">CPF</label> 
			<input class="form-control"  type="text" name="cpf" id=cpf value="${estudante.usuario.cpf}">
		</div>
		<div class="form-group col-lg-6">
			<label for="senha">Senha</label> 
			<input class="form-control"  type="password" name="senha" id="senha" value="${estudante.usuario.senha}">
		</div>
	</div>
	
	<hr>
	<label>Curso</label>
	
	<div class="form-group col-lg-12"> 
	<select class="form-control"  name="curso">
	<c:forEach var="c" items="${cursos}">

		<option value="${c.id}" ${ c.id == estudante.curso.id ? 'selected' : ''} >${c.nome} </option>
	</c:forEach>
	</select>
	</div>
	
	<hr>
	
	<label>Endereço</label><br>
	<div class="row">
		<div class="form-group col-lg-6">
		<label for="cep">CEP</label> 
			<input type="text" name="cep" id="Cep" value="${estudante.usuario.endereco.cep}">
		</div>
		<div class="form-group col-lg-6">
		<label for="cidade">Cidade</label> 
			<input type="text" name="cidade" id="cidade" value="${estudante.usuario.endereco.cidade}">
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-lg-4">
		<label for="bairro">Bairro</label> 
			<input type="text" name="bairro" id="bairro" value="${estudante.usuario.endereco.bairro}">
		</div>
		<div class="form-group col-lg-4">
			<label for="rua">rua</label> 
			<input type="text" name="rua" id="rua" value="${estudante.usuario.endereco.rua}">
		</div>
		<div class="form-group col-lg-4">
			<label for="numero">numero</label> 
			<input type="text" name="numero" id="numero" value="${estudante.usuario.endereco.numero}">
		</div>
	</div>
	
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
		<button class="btn" type="submit">Enviar</button>
		
	</form>
	</div>
	</div>
	</div>
	</div>
	<br />
</body>
</body>
</html>