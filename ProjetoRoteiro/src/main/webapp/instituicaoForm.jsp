<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body class="body2">
	<form method="post" action="./InstituicaoSalvar">
		<input type="hidden" name="id" value="${instituicao.id}">
		<input type="text" name="nome" placeholder="Nome da Instituição" value="${instituicao.nome}">
		<hr>
		<label>Endereço</label><br>
		<input type="text" name="cep" placeholder="Cep" value="${instituicao.endereco.cep}">
		<input type="text" name="cidade" placeholder="Cidade" value="${instituicao.endereco.cidade}">
		<input type="text" name="bairro" placeholder="Bairro" value="${instituicao.endereco.bairro}">
		<input type="text" name="rua" placeholder="Rua" value="${instituicao.endereco.rua}">
		<input type="text" name="numero" placeholder="Numero" value="${instituicao.endereco.numero}">
		<button type="submit">Enviar</button>
	</form>
</body>
</html>