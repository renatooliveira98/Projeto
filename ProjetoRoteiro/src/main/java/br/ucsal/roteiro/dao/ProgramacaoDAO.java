package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Curso;
import br.ucsal.roteiro.model.Instituicao;
import br.ucsal.roteiro.model.Motorista;
import br.ucsal.roteiro.model.Onibus;
import br.ucsal.roteiro.model.Programacao;
import br.ucsal.roteiro.model.Roteiro;
import br.ucsal.roteiro.util.Conexao;

public class ProgramacaoDAO {
	private static Connection con = Conexao.getConnection();
	
	public static List<Programacao> listarProgramacoes(){
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
		
		List <Programacao> programacoes = new ArrayList<Programacao>();
		try {
			String sql = "SELECT * from programacao;"; 
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				LocalDate dia = LocalDate.parse(rs.getString(2), dateFormat);
				LocalTime horaIda = LocalTime.parse(rs.getString(3), timeFormat);
				LocalTime horaVolta = LocalTime.parse(rs.getString(4), timeFormat);
				Onibus onibus = OnibusDAO.buscarOnibus(Integer.parseInt(rs.getString(5)));
				Motorista motorista = MotoristaDAO.buscarMotorista(Integer.parseInt(rs.getString(6)));
				Roteiro roteiro = RoteiroDAO.obterRoteiro(Integer.parseInt(rs.getString(7)));
				
				Programacao programacao = new Programacao(id, roteiro, dia, onibus, horaIda, horaVolta, motorista);
				programacoes.add(programacao);
				
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return programacoes;
	}
	
	public static Programacao buscarProgramacao(Integer idProgramacao) {
		Programacao programacao = null;
		try {
			String sql = "select * from programacao where id=?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idProgramacao);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String diaAux = rs.getString(2);
				LocalDate dia = LocalDate.parse(diaAux);
				String horaIdaAux = rs.getString(3);
				LocalTime horaIda = LocalTime.parse(horaIdaAux);
				String horaVoltaAux = rs.getString(4);
				LocalTime horaVolta = LocalTime.parse(horaVoltaAux);
				Onibus onibus = OnibusDAO.buscarOnibus(Integer.parseInt(rs.getString(5)));
				Motorista motorista = MotoristaDAO.buscarMotorista(Integer.parseInt(rs.getString(6)));
				Roteiro roteiro = RoteiroDAO.obterRoteiro(Integer.parseInt(rs.getString(7)));
				programacao = new Programacao(id, roteiro, dia, onibus, horaIda, horaVolta, motorista);
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			
		}
		return programacao;
	}
	
	
}
