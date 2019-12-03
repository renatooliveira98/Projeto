package br.ucsal.roteiro.util;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Properties;


public class Conexao {

	private static Connection con;
	// public static void main(String[] args) throws SQLException {
	static {
		String url = "jdbc:postgresql://localhost/roteiros";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","postegresql"); //coloque a senha aqui
		props.setProperty("ssl","false");

		try {

			con = DriverManager.getConnection(url, props);

		}  catch (SQLException e) {
			System.out.println("erro2");
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){

		return con;
	}
}



