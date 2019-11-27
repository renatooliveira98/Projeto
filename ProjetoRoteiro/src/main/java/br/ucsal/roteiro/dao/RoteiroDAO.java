package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Ponto;
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
			String sql = "insert into roteiros( CODIGO, DESCRICAO, TIPO ) values(?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, r.getCodigo());
			ps.setString(2, r.getDescricao());
			ps.setString(3, r.getTipo());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			Integer idRoteiro = -1;
			
			if(rs.next()) {
				idRoteiro=rs.getInt("id");
			}
			r.setId(idRoteiro);
			inserirRoteiroPonto(r);
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
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