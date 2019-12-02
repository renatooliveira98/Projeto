<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="atv.css">
<title>Insert title here</title>
<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body class="body2">
	<nav class="navbar navbar-light barraNavegacao">
		
	</nav>

	<nav class="navbar  navbar-expand-lg navbar-light barraNavegacao2" >
		<a class="navbar-brand" href="#">LOGO</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active itensNavbar">
					<a class="nav-link " href="./Perfil">INÍCIO<span class="sr-only">(current)</span></a>
				</li>

				<li class="nav-item dropdown itensNavbar">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						SERVIÇOS
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="./EstudanteListar">ESTUDANTES</a>
						<a class="dropdown-item" href="./InstituicaoListar">INSTITUIÇÕES</a>
						<a class="dropdown-item" href="./RoteiroListar">ROTEIROS</a>
						<a class="dropdown-item" href="./PontoListar">PONTOS</a>
						<a class="dropdown-item" href="./CursoListar">CURSOS</a>
						<a class="dropdown-item" href="./OnibusListar">VEÍCULOS</a>
					</div>
				</li>

				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						FUNCIONARIOS
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="./MotoristaListar">MOTORISTAS</a>
						<a class="dropdown-item" href="./AdministradorListar">ADMINISTRADORES</a>
					</div>
				</li>

				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						NOTIFICAÇÕES
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="#">OPÇÃO 1</a>
						<a class="dropdown-item" href="#">OPÇÃO 2</a>
					</div>
				</li>
				
			</ul>
		</div>
	</nav>

	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>
			
			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
					<div class="row centered">
						<h4 class="titulo">PERFIL</h4>
						<h1>Olá ${usuario.nome}</h1>
					</div>
					<hr>
					<div class="row">
						<div class="col-lg-4">
							
						</div>
						<div class="col-lg-8">
							
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="col-lg-1"></div>
		</div>
	</div>

   
            <footer class="footer">
                <p class="labelFooter">&copy; 2019 Região Metropolitana LTDA.</p>
            </footer>


</body>
</html>