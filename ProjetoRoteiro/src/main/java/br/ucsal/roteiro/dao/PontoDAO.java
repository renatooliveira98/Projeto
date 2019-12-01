package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Ponto;
import br.ucsal.roteiro.util.Conexao;

public class PontoDAO {
	private static Connection con = Conexao.getConnection();
	
	public static List<Ponto> listarPontos() {
		
		List<Ponto> pontos = new ArrayList<Ponto>();
		
		try {
			String sql = "select * from pontos";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Integer id = rs.getInt("id");
				String descricao = rs.getString("descricao");
				Float x = Float.parseFloat(rs.getString("x"));
				Float y = Float.parseFloat(rs.getString("y"));
				
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
	
	public static Ponto obterPonto(Integer idPonto) {
		Ponto ponto=null;
		try {
			
			String sql = "select * from pontos where id=?"; 
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setInt(1, idPonto);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Integer id = rs.getInt("id");
				String descricao = rs.getString("descricao");
				Float x = rs.getFloat("x");
				Float y = rs.getFloat("y");
				ponto = new Ponto(id, descricao, x, y);
			}
			ps.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ponto;
	} 
	
	public static void inserirPonto(Ponto p) {
		try {
			String sql = "insert into pontos values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			Integer id = p.getId();
			ps.setInt(1, id);
			ps.setString(2, p.getDescricao());
			ps.setFloat(3, p.getX());
			ps.setFloat(4, p.getY());
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();
		}catch(Exception e) {
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
		
		try {
			String sql = "delete from pontos where id=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, idPonto);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void editarPonto(Ponto p) {
		try {
			String sql = "update pontos set id=?, descricao=?, x=?, y=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, p.getId());
			ps.setString(2, p.getDescricao());
			ps.setFloat(3, p.getX());
			ps.setFloat(4, p.getY());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}