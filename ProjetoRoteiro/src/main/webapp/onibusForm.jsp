<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<title>Gerenciar Onibus</title>
</head>
<body class="body2">

<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>
			
			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
	<form action="./OnibusSalvar" method="post">
		<input name="id" type="hidden" value="${onibus.id}">
		
		
		<div class="row">
			<div class="form-group col-lg-6">
				<label for="placa">Placa</label>
				<input class="form-control" type="text" id="placa" name="placa" value="${onibus.placa}">
			</div>
			<div class="form-group col-lg-6">
				<label for="situecao">Situação</label>
				<input class="form-control" type="text" id="" name="situacao" value="${onibus.situacao}">
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-lg-12">
				<label for="detalhes">Detalhes</label>
				<input class="form-control" type="text" id="detalhes" name="detalhes" value="${onibus.detalhes}">
			</div> 
		</div>
		
		
		<button class="btn btnPadrao" type="submit">Salvar</button>
	</form>
	
	</div>
	</div>
	</div>
	</div>
</body>
</html>