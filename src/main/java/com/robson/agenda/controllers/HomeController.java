package com.robson.agenda.controllers;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.robson.agenda.entidades.Contato;
import com.robson.agenda.services.ContatoService;

@Named
@RequestScoped
@WebServlet(urlPatterns = { "/HomeController", "/home" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	ContatoService service;
	
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		if (action.equals("/home") || action.equals("/HomeController")) {
			contatos(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	private void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			List<Contato> contatos = service.buscarTodos();
			request.setAttribute("contatos", contatos);
			request.getRequestDispatcher("agenda.jsp").forward(request, response);			
		} catch (Exception e) {
			System.out.println("Erro ao listar contatos: " + e.getMessage());
		}
	}
}
