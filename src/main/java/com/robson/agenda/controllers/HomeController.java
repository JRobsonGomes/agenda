package com.robson.agenda.controllers;

import java.io.IOException;

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
@WebServlet(urlPatterns = { "/HomeController", "/Home" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ContatoService service;
	
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contato contato = new Contato(null, "Alex", "(11) 2989-2548", "alex@gmail.com");
		service.salvar(contato);
		response.getWriter().append("Contato: " + contato);
	}

}
