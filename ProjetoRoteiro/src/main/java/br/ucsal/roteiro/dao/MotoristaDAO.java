package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Motorista;
import br.ucsal.roteiro.util.Conexao;

public class MotoristaDAO {

	public static List<Motorista> listarMotoristas(){
		List <Motorista> motoristas = new ArrayList<Motorista>();
		Connection c = Conexao.getConnection();
		try {
			String sql = "SELECT * from motoristas;"; 
			PreparedStatement pstmt = c.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				String situacao = rs.getString(4);
				
				Motorista motorista = new Motorista(id, nome, descricao, situacao);
				motoristas.add(motorista);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return motoristas;
	}
	
	public static Motorista buscarMotorista(int idMotorista) {
		Connection c = Conexao.getConnection();
		Motorista motorista = null;
		try {
			String sql = "select * from motorista where id=?;";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, idMotorista);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				String situacao = rs.getString(4);
				motorista = new Motorista(id, nome, descricao, situacao);
			}
		}catch (Exception e) {
			
		}
		
		return motorista;
	}
}
