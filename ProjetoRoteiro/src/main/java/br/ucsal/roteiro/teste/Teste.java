package br.ucsal.roteiro.teste;

import java.util.List;

import br.ucsal.roteiro.dao.ProgramacaoDAO;
import br.ucsal.roteiro.model.Programacao;

public class Teste {

	public static void main(String[] args) {
		
		List<Programacao> programacoes = ProgramacaoDAO.listarProgramacoes();
		
		for (Programacao programacao : programacoes) {
			System.out.println("Data: "+programacao.getDia()+", Hora ida: "+programacao.getHoraIda()+", Hora volta: "+programacao.getHoraVolta()+", Ônibus: "+programacao.getOnibus().getDetalhes());
		}
	}

}
