package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.ucsal.roteiro.util.Conexao;

public class EnderecoDAO {

	private static Connection con = Conexao.getConnection();
	
	@SuppressWarnings("unused")
	private static void obterPonto(Integer idEndereco) {
		
		try {
			String sql = "select * from enderecos where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, idEndereco);
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
