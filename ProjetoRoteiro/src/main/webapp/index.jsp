<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<link rel="stylesheet" type="text/css" href="atv.css">
</head>
<body class="body">
<div class="container">
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6 ColLogin">
				<form method="post" action="./LoginServlet">
				<div class="row centered">
					<div class="col-lg-1"></div>
					<div class="col-lg-10">
						<br>
						<h4 class="titulo">ACESSO RESTRITO</h4>
						<br>

						
							<div class="form-group centered">
								<label for="login">Login</label><br>
								<input type="text" class="form-control" name="login" id="login">
							</div>
							<div class="form-group centered">
								<label for="senha">Senha</label><br>
								<input type="password" class="form-control" name="senha" id="senha">
							</div>

						
					</div>
					<div class="col-lg-1"></div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-3"></div>
					<div class="col-lg-3">
						<button type="submit" class="btn btnLogin" >Entrar</button>	
					</div>	
					<div class="col-lg-3">
						<input type="button" class="btn btnLogin" name="recuperarSenha" value="Recuperar Senha">
					</div>
					<div class="col-lg-3"></div>
				</div>
				</form>
				<br>
				<hr>
				<br>
				<div class="row centered">
					<div class="col-lg-3"></div>
					<div class="col-lg-6 centered">
						<p class="texto">Transporte Universitário</p>
						<p class="texto">2019© - Qualquer coisa</p>
					</div>
					<div class="col-lg-3"></div>			
				</div>	
			</div>
			<div class="col-lg-3"></div>
		</div>
		
	</div>
</body>
</html>