package br.ucsal.roteiro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.PontoDAO;
import br.ucsal.roteiro.dao.RoteiroDAO;
import br.ucsal.roteiro.model.Ponto;
import br.ucsal.roteiro.model.Roteiro;

/**
 * Servlet implementation class RoteiroSalvaServlet
 */
@WebServlet("/RoteiroSalvar")
public class RoteiroSalvarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoteiroSalvarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Roteiro roteiro = new Roteiro();
		String[] idsPonto = request.getParameterValues("pontosSelecionados");
		String id = request.getParameter("id");
		String codigo = request.getParameter("codigo");
		String descricao = request.getParameter("descricao");
		String tipo = request.getParameter("tipo");
	
		
		List<Ponto> pontos = new ArrayList<Ponto>();
		for (String idPonto : idsPonto) {
			pontos.add(PontoDAO.obterPonto(Integer.parseInt(idPonto)));
		}
		roteiro.setPontos(pontos);
		if(id != null && !id.trim().isEmpty()) {
			roteiro.setId(Integer.parseInt(id));
			roteiro.setCodigo(codigo);
			roteiro.setDescricao(descricao);
			roteiro.setTipo(tipo);
			RoteiroDAO.editarRoteiro(roteiro);
		}else {
			roteiro.setCodigo(codigo);
			roteiro.setDescricao(descricao);
			roteiro.setTipo(tipo);
			RoteiroDAO.inserirRoteiro(roteiro);
		}
		response.sendRedirect("RoteiroListar");
	}


}
