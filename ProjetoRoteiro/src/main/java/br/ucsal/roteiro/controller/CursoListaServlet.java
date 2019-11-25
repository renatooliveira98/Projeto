package br.ucsal.roteiro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.CursoDAO;
import br.ucsal.roteiro.dao.OnibusDAO;
import br.ucsal.roteiro.model.Curso;
import br.ucsal.roteiro.model.Onibus;

/**
 * Servlet implementation class CursoListaServlet
 */
@WebServlet("/CursoLista")
public class CursoListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CursoListaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Curso> cursos = CursoDAO.listarCursos();
		request.setAttribute("cursos", cursos);
		request.getRequestDispatcher("cursoLista.jsp").forward(request, response);
	}

}
