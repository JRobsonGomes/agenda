<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.robson.agenda.entidades.Contato"%>
<%
	List<Contato> contatos = (List<Contato>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html>
<head lang="PT-BR">
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="mt-5">
					<h1 class="home-titulo">Agenda de contatos</h1>
				</div>
				<div class="mt-3">
					<a href="novoContato.html" class="btn btn-lg btn-custom">Novo contato</a>
				</div>
				<%
				if (!contatos.isEmpty() || contatos.size() <= -1) {
				%>
				<div class="mt-5">
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr>
								<th scope="col">Nome</th>
								<th scope="col">Telefone</th>
								<th scope="col">Email</th>
								<th scope="col">Ações</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (Contato contato : contatos) {
							%>
							<tr>
								<td><%=contato.getNome()%></td>
								<td><%=contato.getTelefone()%></td>
								<td><%=contato.getEmail()%></td>
								<td><a href="Editar?id=<%=contato.getId() %>" class="btn btn-primary">Editar</a></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>