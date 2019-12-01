package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Motorista;
import br.ucsal.roteiro.model.Onibus;
import br.ucsal.roteiro.model.Programacao;
import br.ucsal.roteiro.model.Roteiro;
import br.ucsal.roteiro.util.Conexao;

public class ProgramacaoDAO {
//	private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//	private static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm:ss");	
	private static Connection con = Conexao.getConnection();
	
	public static void main(String args[]) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm:ss");
		
		
		LocalDate dia = LocalDate.parse("2019-08-17", dateFormat);
		LocalTime horaIda = LocalTime.parse("12:00:50", timeFormat);
		LocalTime horaVolta = LocalTime.parse("17:00:00", timeFormat);
		Programacao programacao = new Programacao();
		programacao.setDia(dia);
		programacao.setHoraIda(horaIda);
		programacao.setHoraVolta(horaVolta);
		programacao.setMotorista(MotoristaDAO.buscarMotorista(4));
		programacao.setOnibus(OnibusDAO.buscarOnibus(9));
		programacao.setRoteiro(RoteiroDAO.obterRoteiro(4));
		inserirProgramacao(programacao);
		
		Programacao p = buscarProgramacao(2);
		
		System.out.println(p.getId());
		System.out.println(p.getHoraIda());
		
		
	}
	
	public static List<Programacao> listarProgramacoes(){
		
		List <Programacao> programacoes = new ArrayList<Programacao>();
		try {
			String sql = "SELECT * FROM programacao;"; 
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				LocalDate dia = LocalDate.parse(rs.getString(2));
				LocalTime horaIda = LocalTime.parse(rs.getString(3));
				LocalTime horaVolta = LocalTime.parse(rs.getString(4));
				Onibus onibus = OnibusDAO.buscarOnibus(Integer.parseInt(rs.getString(5)));
				Motorista motorista = MotoristaDAO.buscarMotorista(Integer.parseInt(rs.getString(6)));
				Roteiro roteiro = RoteiroDAO.obterRoteiro(Integer.parseInt(rs.getString(7)));
				Programacao programacao = new Programacao(id, roteiro, dia, onibus, horaIda, horaVolta, motorista);
				programacoes.add(programacao);
				
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
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
				LocalDate dia = LocalDate.parse(rs.getString(2));
				LocalTime horaIda = LocalTime.parse(rs.getString(3));
				LocalTime horaVolta = LocalTime.parse(rs.getString(4));
				Onibus onibus = OnibusDAO.buscarOnibus(Integer.parseInt(rs.getString(5)));
				Motorista motorista = MotoristaDAO.buscarMotorista(Integer.parseInt(rs.getString(6)));
				Roteiro roteiro = RoteiroDAO.obterRoteiro(Integer.parseInt(rs.getString(7)));
				programacao = new Programacao(id, roteiro, dia, onibus, horaIda, horaVolta, motorista);
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return programacao;
	}
	
	public static void inserirProgramacao(Programacao programacao) {
		
		
		try {
				String sql = "insert into programacao (dia, hora_ida, hora_volta, id_onibus, id_motorista, id_roteiro) values (?, ?, ?, ?, ?, ?);";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setDate(1, Date.valueOf(programacao.getDia()));;
				pstmt.setTime(2, Time.valueOf(programacao.getHoraIda()));
				pstmt.setTime(3, Time.valueOf(programacao.getHoraVolta()));
				pstmt.setInt(4, programacao.getOnibus().getId());
				pstmt.setInt(5, programacao.getMotorista().getId());
				pstmt.setInt(6, programacao.getRoteiro().getId());
				
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public static void removerProgramacao(int idProgramacao) {
		try {
			String sql = "DELETE FROM programacao where id=?;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idProgramacao);
			pstmt.executeUpdate();
			pstmt.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
