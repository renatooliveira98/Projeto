package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.ucsal.roteiro.model.Ponto;
import br.ucsal.roteiro.model.Roteiro;
import br.ucsal.roteiro.util.Conexao;

public class RoteiroPontoDAO {
	private static Connection con = Conexao.getConnection();
	
	public static void inserirRoteiroPonto(Roteiro roteiro) {
		String sql="insert into roteiro_ponto (id_roteiro, id_ponto) values(?,?)";
		try {
			for (Ponto p : roteiro.getPontos()) {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, roteiro.getId());
				ps.setInt(2, p.getId());
				ps.executeUpdate();
				ps.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void excluirPonto(Integer idPonto) {
		try {
			String sql = "delete from roteiro_ponto where id_ponto=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, idPonto);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
