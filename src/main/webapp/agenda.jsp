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
					<a href="index.html">
						<h1 class="home-titulo">Agenda de contatos</h1>
					</a>
				</div>
				<div class="row mt-5">
					<div class="col-md-4">
						<div class="row px-3">
							<a href="novoContato.html" class="btn btn-custom mr-3 col">Novo contato</a>
							<a href="relatorio" class="btn btn-primary ml-3 col" target="_blank">Relatório</a>
						</div>
					</div>
				</div>
				<%
				if (!contatos.isEmpty() || contatos.size() <= -1) {
				%>
				<div class="mt-3">
					<table class="table table-striped table-hover table-bordered table-sm">
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
								<td>
									<a href="editar?id=<%=contato.getId() %>" class="btn btn-primary btn-sm ml-3">Editar</a>
									<a href="javascript: confirmar(<%=contato.getId() %>, '<%=contato.getNome()%>')" class="btn btn-danger btn-sm ml-3">Excluir</a>
								</td>
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
	<script type="text/javascript" src="scripts/confirmacao.js"></script>
</body>
</html>