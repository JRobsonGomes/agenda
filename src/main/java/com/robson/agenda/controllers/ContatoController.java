package com.robson.agenda.controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.robson.agenda.entidades.Contato;
import com.robson.agenda.services.ContatoService;

@WebServlet("/ContatoController")
public class ContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	ContatoService service;
	
	
    public ContatoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setTelefone(telefone);
		contato.setEmail(email);
		
		service.salvar(contato);
		response.sendRedirect("/Home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
