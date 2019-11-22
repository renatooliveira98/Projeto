package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Curso;
import br.ucsal.roteiro.model.Instituicao;
import br.ucsal.roteiro.model.Onibus;
import br.ucsal.roteiro.util.Conexao;

public class CursoDAO {

	public static List<Curso> listarCursos(){
		List <Curso> cursos = new ArrayList<Curso>();
		Connection c = Conexao.getConnection();
		try {
			String sql = "SELECT * from cursos ;"; 
			PreparedStatement pstmt = c.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				int duracao = Integer.parseInt(rs.getString(3));
				Instituicao instituicao = InstituicaoDAO.buscarBloco(Integer.parseInt(rs.getString(4)));
				Curso curso = new Curso();
				curso.setDuracao(duracao);
				curso.setId(id);
				curso.setNome(nome);
				curso.setInstituicao(instituicao);
				cursos.add(curso);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return cursos;
	}
	
	public static Curso buscarCurso(int idCurso) {
		Connection c = Conexao.getConnection();
		Curso curso = null;
		try {
			String sql = "select * from cursos where id=?;";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, idCurso);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				int duracao = Integer.parseInt(rs.getString(3));
				Instituicao instituicao = InstituicaoDAO.buscarInstituicao(Integer.parseInt(rs.getString(4)));
				curso = new Curso(id, instituicao, nome, duracao);
			}
		}catch (Exception e) {
			
		}
		
		return curso;
	}
}
