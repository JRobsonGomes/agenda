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

@WebServlet(urlPatterns = { "/ContatoController", "/Editar", "/Atualizar" })
public class ContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	ContatoService service;
	
	private Contato contato;

	public ContatoController() {
		super();
	}
	
	private void editarContato(HttpServletRequest request, HttpServletResponse response) {
		try {
			Contato contato = new Contato();
			
			contato = getContato(request, contato);
			request.setAttribute("contato", contato);
			request.getRequestDispatcher("editarContato.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Erro ao editar contato: " + e.getMessage());
		}
	}

	protected void salvarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			contato = new Contato();

			request.setCharacterEncoding("UTF-8");
			String action = request.getServletPath();			
			if (action.equals("/ContatoController")) {
				setContato(request);
				service.salvar(contato);
			} else if (action.equals("/Atualizar")) {
				contato = getContato(request, contato);
				setContato(request);
				service.editar(contato);
			}
			response.sendRedirect("Home");
		} catch (Exception e) {
			System.out.println("Erro ao salvar contato: " + e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		salvarContato(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		editarContato(request, response);
	}
	private void setContato(HttpServletRequest request) {
	
		try {
			request.setCharacterEncoding("UTF-8");
			//Buscar paremtros do formulário
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			String email = request.getParameter("email");
			contato.setNome(nome);
			contato.setTelefone(telefone);
			contato.setEmail(email);
			
		} catch (Exception e) {
			System.out.println("Erro ao setar contato!");
		}
	}
	
	private Contato getContato(HttpServletRequest request, Contato contato) {
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			contato = service.buscarPorId(id);
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar contato!");
		}
		return contato;
	}
}
