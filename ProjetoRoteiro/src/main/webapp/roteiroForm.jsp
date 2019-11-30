<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<title>Editar Roteiro</title>
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
			$("#listaPontos").on("click","li",function() {
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
					+ "<input type='checkbox' name='pontosSelecionados' id='chkTags' class='chkTags' checked='checked' value='"
					+ $(this,"option:selected").val()+ "'></li>");
					$(this).remove();
					}
					
				});
			
				$('#lstTag').on('click','li',function() {
					$("#listaPontos").append("<li class='list-group-item ' name='pontosSelecionados' value='"
					+ $(this).val() + "'>"+ $(this).text()+ "</li>");
					$(this).remove();
					return false;
				});
				
});
	</script>

	<form action="./RoteiroSalvar" method="get">
		<input name="id" type="hidden" value="${roteiro.id}">
		Codigo: <input name="codigo" type="text" value="${roteiro.codigo}">
		Descrição: <input name="descricao" type="text" value="${roteiro.descricao}">
		Tipo <input name="tipo" type="text" value="${roteiro.tipo}">
		
		<div class="row">
			<div class="col-lg-6 col-sm-12">
				<label>Pontos Cadastrados</label>
				<div class="form-group">
					<div class=" ms-lista">
						<ul class="list-group list-group-flush" id="listaPontos">
							<c:forEach var="p" items="${pontos}">
								<li class="list-group-item" value="${p.id}">${p.descricao}</li>
							</c:forEach>

						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-sm-12">
				<label>Pontos do Roteiro</label>
				<div class="ms-lista">
					<ul id="lstTag" class="list-group list-group-flush"></ul>
				</div>
			</div>
		</div>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>