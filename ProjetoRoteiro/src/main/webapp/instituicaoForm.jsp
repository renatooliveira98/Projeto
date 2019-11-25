<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="./InstituicaoSalvar">
		<input type="text" name="nome" placeholder="Nome da Instituição">
		<hr>
		<label>Endereço</label><br>
		<input type="text" name="cep" placeholder="Cep">
		<input type="text" name="cidade" placeholder="Cidade">
		<input type="text" name="bairro" placeholder="Bairro">
		<input type="text" name="rua" placeholder="Rua">
		<input type="text" name="numero" placeholder="Numero">
		<button type="submit">Enviar</button>
	</form>
</body>
</html>