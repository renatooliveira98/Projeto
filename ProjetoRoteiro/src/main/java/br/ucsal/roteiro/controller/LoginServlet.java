package br.ucsal.roteiro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.UsuarioDAO;
import br.ucsal.roteiro.model.Usuario;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		if(UsuarioDAO.autenticarUsuario(usuario) != null) {
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect("./PerfilServlet");
		}else {
			request.setAttribute("erro", "E-mail ou senha inválido!");
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		}
	}

}
