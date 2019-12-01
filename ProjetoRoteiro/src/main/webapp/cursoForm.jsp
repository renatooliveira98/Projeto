<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<title>Gerenciar Cursos</title>
<link rel="stylesheet" type="text/css" href="atv.css">
</head>
<body>
	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>
			
			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
	<form action="./CursoSalvar" method="post">
	
		<input name="id" type="hidden" value="${curso.id}">
		<h1 class="tituloForm">Cadastrar Curso</h1>
		<hr>
		<div class="row">
		
		<div class="form-group col-lg-6"> 
		<label for="nome">Nome do Curso </label>
		<input id="nome" class="form-control" type="text" name="nome" value="${curso.nome}">
		
		</div>
		
		
		<div class="form-group col-lg-6"> 
		<label for="duracao">Duração</label> 
		<input class="form-control"  type="text" id="duracao" name="duracao" value="${curso.duracao}">
		
		</div>
		</div>
		
		<div class="form-group col-lg-12"> 
		<label for="instituicao">Instituição</label> 
		<select class="form-control" name="instituicao" id="instituicao">
						<option value="">Selecione</option>
							<c:forEach var="instituicao" items="${instituicoes}">
							<option value="${instituicao.id}"
							${ instituicao.id == curso.instituicao.id ? 'selected' : ''}>${instituicao.nome}
							</c:forEach>
						</option>
		</select> 
		</div>
		<button class="btn btnPadrao" type="submit">Salvar</button>
	</form>
	</div>
	</div>
	</div>
	</div>

</body>
</html>