package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Papel;
import br.ucsal.roteiro.model.Usuario;
import br.ucsal.roteiro.util.Conexao;

public class UsuarioDAO {
	private static Connection con = Conexao.getConnection();
	
	public static List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			String sql = "select * from usuarios;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Integer id= rs.getInt("id");
				String nome= rs.getString("nome");
				String nomeSocial = rs.getString("nome_social");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				Integer idEndereco = rs.getInt("id_endereco");
				Integer idPapel = rs.getInt("id_papel");
				Papel p = PapelDAO.buscarPapel(idPapel);
				//Usuario usuario = new Usuario(idPapel, nome, nomeSocial, login, email, cpf, senha, endereco, papel);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	
	public static Usuario buscarUsuario(Integer id) {
		Usuario usuario = null;	
		
		try {
			String sql = "select * from usuarios where id=?;";
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				Integer idUser= rs.getInt("id");
				String nome= rs.getString("nome");
				String nomeSocial = rs.getString("nome_social");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				Integer idEndereco = rs.getInt("id_endereco");
				Integer idPapel = rs.getInt("id_papel");
				Papel p = PapelDAO.buscarPapel(idPapel);
				//usuario = new Usuario(id, nome, nomeSocial, login, email, cpf, senha, endereco, papel)
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return usuario;
		
	}
}
