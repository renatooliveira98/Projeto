package br.ucsal.roteiro.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.MotoristaDAO;
import br.ucsal.roteiro.dao.OnibusDAO;
import br.ucsal.roteiro.dao.RoteiroDAO;
import br.ucsal.roteiro.model.Motorista;
import br.ucsal.roteiro.model.Onibus;
import br.ucsal.roteiro.model.Roteiro;



/**
 * Servlet implementation class ProgramacaoForm
 */
@WebServlet("/ProgramacaoForm")
public class ProgramacaoForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramacaoForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Roteiro> roteiros = RoteiroDAO.listarRoteiros();
		List<Onibus> onibus = OnibusDAO.listarOnibus();
		List<Motorista> motoristas = MotoristaDAO.listarMotoristas();
		
		
		request.setAttribute("motoristas", motoristas);
		request.setAttribute("onibus", onibus);
		request.setAttribute("roteiros", roteiros);
		request.getRequestDispatcher("programacaoForm.jsp").forward(request, response);
	}


	

}
