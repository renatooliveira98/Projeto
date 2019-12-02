package br.ucsal.roteiro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.PontoDAO;
import br.ucsal.roteiro.model.Ponto;

/**
 * Servlet implementation class PontoListar
 */
@WebServlet("/PontoListar")
public class PontoListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PontoListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ponto> pontos = PontoDAO.listarPontos();
		String sId = request.getParameter("idRoteiro");
		//int id = Integer.parseInt(sId);
		request.setAttribute("idRoteiro", sId);
		request.setAttribute("pontos", pontos);
		request.getRequestDispatcher("pontoLista.jsp").forward(request, response);
	}

}
