package com.robson.agenda.controllers;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Named
@RequestScoped
@WebServlet(urlPatterns = { "/HomeController", "/Home" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		if (action.equals("/Home")) {
			contatos(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	private void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("agenda.jsp");
	}
}
