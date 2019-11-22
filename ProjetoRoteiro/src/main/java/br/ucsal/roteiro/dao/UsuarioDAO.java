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
	
	public static Usuario autenticarUsuario(Usuario user) {
		boolean autenticado = false;
		try {
			String sql = "select * from usuarios where email=? and senha=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getSenha());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				autenticado = true;
				user.setId(Integer.parseInt(rs.getString(1)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(autenticado /*== true*/) {
			return user;
		}else {
			return null;
		}
	}
	
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
