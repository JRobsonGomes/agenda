<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Hello JSP</title>
</head>
<body>
	<p>Hello Horld!</p>
	<% out.println("Olá, José Robson");	%>
	<%! SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy'T'HH:mm:ss"); %>
	<%! int contador = 1; %>
	<p>Data: <%= sdf.format(new Date())%> </p>
	<p>Vistas: <%= contador++ %></p>
</body>
</html>