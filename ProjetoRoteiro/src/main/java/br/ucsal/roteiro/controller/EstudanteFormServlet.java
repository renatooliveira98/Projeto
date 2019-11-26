package br.ucsal.roteiro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.CursoDAO;
import br.ucsal.roteiro.dao.InstituicaoDAO;
import br.ucsal.roteiro.dao.RoteiroDAO;

/**
 * Servlet implementation class EstudanteFormServlet
 */
@WebServlet("/EstudanteForm")
public class EstudanteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public EstudanteFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("roteiros", RoteiroDAO.listarRoteiros());
		request.setAttribute("instituicoes", InstituicaoDAO.listarInstituicoes());
		request.setAttribute("cursos", CursoDAO.listarCursos());
		request.getRequestDispatcher("cadastrarEstudante.jsp").forward(request, response);
	}
	

}
