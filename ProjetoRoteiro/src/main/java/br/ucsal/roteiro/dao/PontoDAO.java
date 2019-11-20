package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Ponto;
import br.ucsal.roteiro.util.Conexao;

public class PontoDAO {
	
	public static List<Ponto> buscarPontos() {
		
		Connection con = Conexao.getConnection();
		List<Ponto> pontos = new ArrayList<Ponto>();
		
		try {
			String sql = "select * from pontos";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Integer id = Integer.parseInt(rs.getString("id"));
				String descricao = rs.getString("descricao");
				Long x = Long.parseLong(rs.getString("x"));
				Long y = Long.parseLong(rs.getString("y"));
				
				Ponto ponto = new Ponto(id, descricao, x, y);
				pontos.add(ponto);
			}
			ps.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return pontos;
	}
}