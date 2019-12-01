package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.ucsal.roteiro.model.Estudante;
import br.ucsal.roteiro.model.Roteiro;
import br.ucsal.roteiro.util.Conexao;

public class RoteiroEstudanteDAO {
	private static Connection con = Conexao.getConnection();
	
	public static void inserRoteiroEstudante(Estudante estudante) {
		String sql= "insert into roteiro_estudante (id_roteiro, id_estudante) values ( ?, ?);";
		
		try {
			for (Roteiro roteiro : estudante.getRoteiros()) {
				PreparedStatement pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, roteiro.getId());
				pstmt.setInt(2, estudante.getId());
				pstmt.executeUpdate();
				pstmt.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
