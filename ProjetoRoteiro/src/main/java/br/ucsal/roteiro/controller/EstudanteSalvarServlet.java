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
import br.ucsal.roteiro.dao.EnderecoDAO;
import br.ucsal.roteiro.dao.PapelDAO;
import br.ucsal.roteiro.dao.RoteiroDAO;
import br.ucsal.roteiro.model.Endereco;
import br.ucsal.roteiro.model.Estudante;
import br.ucsal.roteiro.model.Papel;
import br.ucsal.roteiro.model.Roteiro;
import br.ucsal.roteiro.model.Usuario;


@WebServlet("/EstudanteSalvar")
public class EstudanteSalvarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public EstudanteSalvarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] r= request.getParameterValues("reteirosSelecionados");
		String nome = request.getParameter("nome");
		String nomeSocial = request.getParameter("nomeSocial");
		String email = request.getParameter("email"); 
		String cpf=request.getParameter("cpf");
		String senha= request.getParameter("senha");
		String sIdCurso= request.getParameter("curso");
		
		String bairro =request.getParameter("bairro");
		String cep=request.getParameter("cep");
		String cidade=request.getParameter("cidade");
		String rua=request.getParameter("rua");
		String numero=request.getParameter("numero");
		
		List<Roteiro> roteiros= new ArrayList<>();
		for (String idRoteiro : r) {
			roteiros.add(RoteiroDAO.obterRoteiro(Integer.parseInt(idRoteiro)));
		}
		
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setRua(rua);
		endereco.setNumero(numero);
		
		Estudante estudante = new Estudante();
		estudante.setCurso(CursoDAO.buscarCurso(Integer.parseInt(sIdCurso)));
		estudante.setRoteiros(roteiros);
		
	
		Papel p=PapelDAO.buscarPapel(2);
		Usuario usuario = new Usuario(null, nome, nomeSocial, email, cpf, senha, endereco, p);
		estudante.setUsuario(usuario);
		usuario.setEstudante(estudante);
		endereco.setUsuario(usuario);
		EnderecoDAO.inserirEndereco(endereco);
		response.sendRedirect("./EstudanteListar");

	}

}
