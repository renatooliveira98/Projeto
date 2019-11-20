package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Instituicao;
import br.ucsal.roteiro.util.Conexao;

public class InstituicaoDAO {
	private static Connection con = Conexao.getConnection();
	
	public static List<Instituicao> listarInstituicoes() {
		List<Instituicao> instituicoes = new ArrayList<Instituicao>();
		
		try {
			String sql = "select * from instituicoes;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Integer id= rs.getInt("id");
				String nome = rs.getString("nome");
				Integer idEndereco = rs.getInt("id_endereco");
				
				//Instituicao instituicao = new Instituicao(idEndereco, nome, endereco, cursos);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return instituicoes;
	}
	
	
	public static Instituicao buscarInstituicao(Integer id) {
		Instituicao instituicao= null;
		
		try {
			String sql = "select * from instituicoes where id=?;";
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				Integer idInstituicao= rs.getInt("id");
				String nome = rs.getString("nome");
				Integer idEndereco = rs.getInt("id_endereco");
				
				//instituicao = new Instituicao(idEndereco, nome, endereco, cursos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instituicao;
		
	}
	
}
