package com.robson.agenda.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.robson.agenda.entidades.Contato;
import com.robson.agenda.services.ContatoService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@WebServlet(urlPatterns = { "/ContatoController", "/editar", "/atualizar", "/deletar", "/relatorio" })
public class ContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	ContatoService service;

	private Contato contato;

	public ContatoController() {
		super();
	}

	//Referencia: https://youtu.be/S9p-ytIHDII
	private void gerarRelatorio(HttpServletResponse response) {
		try {

			List<Contato> contatos = service.buscarTodos();
			
			URL url = getClass().getResource("/relatorios/RelatorioContatos.jasper");
    		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(url);
    		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();    		
    		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(contatos));//null: caso nao existam filtros
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			response.reset();
			response.setContentType("application/pdf");
			response.setContentLength(outputStream.size());
			response.setHeader("Content-disposition", "inline; filename=Relatorio.pdf");
			response.getOutputStream().write(outputStream.toByteArray());
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch (Exception e) {
			System.out.println("Erro ao gerar relatório: " + e.getMessage());
		}
	}

	private void deletarContato(HttpServletRequest request, HttpServletResponse response) {
		try {
			contato = new Contato();

			contato = getContato(request, contato);
			service.excluir(contato.getId());
			response.sendRedirect("home");
		} catch (Exception e) {
			System.out.println("Erro ao excluir contato: " + e.getMessage());
		}
	}

	private void editarContato(HttpServletRequest request, HttpServletResponse response) {
		try {
			contato = new Contato();

			contato = getContato(request, contato);
			request.setAttribute("contato", contato);
			request.getRequestDispatcher("editarContato.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Erro ao editar contato: " + e.getMessage());
		}
	}

	protected void salvarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			contato = new Contato();

			request.setCharacterEncoding("UTF-8");
			String action = request.getServletPath();
			if (action.equals("/ContatoController")) {
				setContato(request);
				service.salvar(contato);
			} else if (action.equals("/atualizar")) {
				contato = getContato(request, contato);
				setContato(request);
				service.editar(contato);
			}
			response.sendRedirect("home");
		} catch (Exception e) {
			System.out.println("Erro ao salvar contato: " + e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		salvarContato(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/editar")) {

			editarContato(request, response);
		} else if (action.equals("/deletar")) {
			deletarContato(request, response);
		} else if (action.equals("/relatorio")) {
			gerarRelatorio(response);
		}
	}

	private void setContato(HttpServletRequest request) {
		try {

			request.setCharacterEncoding("UTF-8");
			// Buscar paremtros do formulário
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
