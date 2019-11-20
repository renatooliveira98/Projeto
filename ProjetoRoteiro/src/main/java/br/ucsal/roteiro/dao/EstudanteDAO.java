package br.ucsal.roteiro.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ucsal.roteiro.model.Estudante;
import br.ucsal.roteiro.util.Conexao;

public class EstudanteDAO {
	private static Connection con = Conexao.getConnection();
	
	public static List<Estudante> listarEstudantes() {
		List<Estudante> estudantes = new ArrayList<>();
		
		try {
			String sql = "select * from estudantes;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Integer id= rs.getInt("id");
				Integer idCurso= rs.getInt("id_curso");
				Integer idUsuario=rs.getInt("id_usuario");
				
				
				//Estudante estudante = new Estudante(idUsuario, usuario, roteiros, curso);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return estudantes;
	}
	
	public static Estudante buscarEstudante(Integer id) {
		Estudante estudante=null;
		
		try {
			String sql = "select * from estudantes where id=?;";
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				Integer idEstudante= rs.getInt("id");
				Integer idCurso= rs.getInt("id_curso");
				Integer idUsuario=rs.getInt("id_usuario");
				
				//estudante= new Estudante(idEstudante, usuario, roteiros, curso)
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return estudante;
		
	}
}
