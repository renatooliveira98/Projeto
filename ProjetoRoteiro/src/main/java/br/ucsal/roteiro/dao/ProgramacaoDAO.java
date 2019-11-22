package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public static List<Programacao> listarProgramacoes(){
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
		
		List <Programacao> programacoes = new ArrayList<Programacao>();
		Connection c = Conexao.getConnection();
		try {
			String sql = "SELECT * from programacao;"; 
			PreparedStatement pstmt = c.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
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
				
				Programacao programacao = new Programacao();
				programacao.setDia(dia);
				programacao.setHoraIda(horaIda);
				programacao.setHoraVolta(horaVolta);
				programacao.setId(id);
				programacao.setMotorista(motorista);
				programacao.setOnibus(onibus);
				programacoes.add(programacao);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return programacoes;
	}
	
}
