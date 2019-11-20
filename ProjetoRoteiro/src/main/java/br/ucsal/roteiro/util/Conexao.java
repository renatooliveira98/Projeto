package br.ucsal.roteiro.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.cmdline.SqlFile;

public class Conexao {

	 private static Connection con;
	// public static void main(String[] args) throws SQLException {
	 static {
	       String url = "jdbc:hsqldb:hsql://localhost/roteiros";
	        String user = "SA";
	        String password = "";
	        
	        try {
				Class.forName("org.hsqldb.jdbcDriver");
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e1) {
				System.out.println("erro");
				e1.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("erro2");
				e.printStackTrace();
			}
	 }

	    public static Connection getConnection(){
	       
	    	return con;
	    }
	 }

//	PROFESSOR PEGOU NA NET NA SALA E JOGOU AI(NÃO ENTENDI NADA POR ISSO FIZ DO JEITO DE DA PRA ENTENDER E NÃO SEI SE FUNCIONA)
//	        String connUrl = "jdbc:hsqldb:file:banco/db";
//	        String username = "SA";
//	        String password = "";
//	        
//	        try {
//				Class.forName("org.hsqldb.jdbcDriver");
//			} catch (ClassNotFoundException e1) {
//				e1.printStackTrace();
//			}
//
//	        try (Connection conn = DriverManager.getConnection(connUrl, username, password)) {
//	            // clear out previous test data
//	            try (Statement st = conn.createStatement()) {
//	                st.executeUpdate("DELETE FROM table1 WHERE ID > 1");
//	            }
//
//	            System.out.println("Before:");
//	            dumpTable(conn);
//
//	            // execute the commands in the .sql file
//	            SqlFile sf = new SqlFile(new File("C:/Users/Public/test/hsqldbCommands.sql"));
//	            sf.setConnection(conn);
//	            sf.execute();
//
//	            System.out.println();
//	            System.out.println("After:");
//	            dumpTable(conn);
//
//	            try (Statement st = conn.createStatement()) {
//	                st.execute("SHUTDOWN");
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace(System.err);
//	        }
//	    }
//
//	    private static void dumpTable(Connection conn) throws SQLException {
//	        try (
//	                Statement st = conn.createStatement(); 
//	                ResultSet rs = st.executeQuery("SELECT id, textcol FROM table1")) {
//	            while (rs.next()) {
//	                System.out.printf("%d - %s%n", rs.getInt("id"), rs.getString("textcol"));
//	            }
//	        }
//	    }

