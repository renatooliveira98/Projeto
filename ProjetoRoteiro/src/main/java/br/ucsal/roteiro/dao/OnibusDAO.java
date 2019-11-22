package br.ucsal.roteiro.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Onibus;
import br.ucsal.roteiro.util.Conexao;

public class OnibusDAO {
	
	public static List<Onibus> listarOnibus(){
		List <Onibus> onibus = new ArrayList<Onibus>();
		Connection c = Conexao.getConnection();
		
		try {
			String sql = "select * from onibus;";
			PreparedStatement pstmt = c.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String detalhes = rs.getString(2);
				String situacao = rs.getString(3);
				String placa = rs.getString(4);
				Onibus bus = new Onibus(id, placa, detalhes, situacao);
				onibus.add(bus);
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
		}
		
		return onibus;
	}
	
	public static Onibus buscarOnibus(int idOnibus) {
		Connection c = Conexao.getConnection();
		Onibus bus = null;
		try {
			String sql = "select * from onibus where id=?;";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, idOnibus);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String detalhes = rs.getString(2);
				String situacao = rs.getString(3);
				String placa = rs.getString(4);
				bus = new Onibus(id, placa, detalhes, situacao);
			}
		}catch (Exception e) {
		}
		
		return bus;
	}
}
