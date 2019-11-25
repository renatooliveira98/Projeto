package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Roteiro;
import br.ucsal.roteiro.util.Conexao;

public class RoteiroDAO {
	
	private static Connection con = Conexao.getConnection();
	@SuppressWarnings("unused")//so pra tirar o warning
	public static List<Roteiro> listarRoteiros() {
		
		List<Roteiro> roteiros = new ArrayList<Roteiro>();
		
		try {
			String sql = "select * from roteiros";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Integer id = rs.getInt("id");
				String codigo = rs.getString("codigo");
				String descricao = rs.getString("descricao");
				String tipo = rs.getString("tipo");
				
				Roteiro roteiro = new Roteiro(id, codigo, descricao, tipo);
				roteiros.add(roteiro);
			}
			ps.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return roteiros;
	}
	
	public static Roteiro obterRoteiro(Integer idRoteiro) {
		Roteiro roteiro = null;
		try {
			String sql = "select * from roteiros where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, idRoteiro);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String codigo = rs.getString(2);
				String descricao = rs.getString(3);
				String tipo = rs.getString(4);
				roteiro = new Roteiro(id, codigo, descricao, tipo);
			}
			ps.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return roteiro;
	}
	
	public static void inserirRoteiro(Roteiro r) {
		try {
			String sql = "insert into roteiros values(?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);
			
			Integer id = r.getId();
			ps.setInt(1, id);
			ps.setString(2, r.getCodigo());
			ps.setString(3, r.getDescricao());
			ps.setString(4, r.getTipo());
			
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void excluirRoteiro(Integer idRoteiro) {
		try {
			String sql = "delete from roteiros where id=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, idRoteiro);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void editarRoteiro(Roteiro r) {
		try {
			String sql = "update roteiros set id=?, codigo=?, descricao=?, tipo=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, r.getId());
			ps.setString(2, r.getCodigo());
			ps.setString(3, r.getDescricao());
			ps.setString(4, r.getTipo());
			ps.executeUpdate();
			
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}