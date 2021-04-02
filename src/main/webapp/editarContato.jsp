<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.robson.agenda.entidades.Contato"%>
<%
Contato contato = (Contato) request.getAttribute("contato");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Contato</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="home-titulo mt-5">Editar Contato</h1>
				<form class="mt-5" name="formContato" action="atualizar" method="post"
					onsubmit="return validar()">
					<div class="form-group">
						<div hidden="hidden" class="mb-4">
							<input type="hidden" readonly="readonly" name="id" value="<%=contato.getId()%>">
						</div>
						<div class="mb-4">
							<input type="text" class="form-control" name="nome"
								placeholder="Nome" value="<%=contato.getNome()%>">
							<div class="invalid-feedback" id="feedbackNome">Preencha o nome</div>
						</div>
						<div class="mb-4">
							<input type="text" class="form-control" name="telefone" id="txttelefone"
								placeholder="Telefone" value="<%=contato.getTelefone()%>" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}">
							<div class="invalid-feedback" id="feedbackTelefone">Preencha o telefone</div>
						</div>
						<div class="mb-4">
							<input type="email" class="form-control" name="email"
								placeholder="Email" value="<%=contato.getEmail()%>">
						</div>
					</div>
					<div class="row px-3">
						<button type="submit" class="btn btn-custom col mr-2">Salvar</button>
						<a href="home" class="btn btn-primary col ml-2">Cancelar</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="scripts/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="scripts/jquery.mask.min.js"></script>
	<script type="text/javascript" src="scripts/validador.js"></script>
</body>
</html>