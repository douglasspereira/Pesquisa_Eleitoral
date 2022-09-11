

import controller.CandidatoController;
import controller.PesquisaController;
import controller.TipoPesquisaController;
import model.Candidato;
import model.Pesquisa;
import model.TipoPesquisa;
import util.ConnectionUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.LocalDate;

public class Principal {
	
	public static void main(String[] args) {
		
		consulta();
		System.out.println("-------------------------------");
		salvar();
		consulta();
		System.out.println("-------------------------------");
			
	//	testeCandidato();
	//	testeTipoPesquisa();
	//	testePesquisa();
			
	}
	

	

	
//	public static void testeCandidato() {
//		Candidato c1 = new Candidato();
//		c1.setId(1);
//		c1.setNome("Bolsonaro");
//		c1.setPartido("PSL");
//		c1.setFichaLimpa("Sim");
//		
//		Candidato c2 = new Candidato();
//		c2.setId(2);
//		c2.setNome("Lula");
//		c2.setPartido("PT");
//		c2.setFichaLimpa("Não");
//		
//		CandidatoController controller = new CandidatoController();
//		try {
//			controller.salvar(c1);
//			controller.salvar(c2);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		for (Candidato c : controller.listar()) {
//			System.out.println(c.toString());
//		}
//		
//		
//	}
	// comentario teste
//	public static void testeTipoPesquisa() {
//		TipoPesquisa tp1 = new TipoPesquisa();
//		tp1.setId(15);
//		tp1.setInstituto("Data Folha");
//		tp1.setDataPesquisa(LocalDate.now());
//		tp1.setLocal("Florianópolis");
//		tp1.setMediaIdade(45.5);
//		tp1.setTipoPesquisa("Prefeito");
//		tp1.setDescricao("Pesquisa para prefeito");
//		
//		TipoPesquisa tp2 = new TipoPesquisa();
//		tp2.setId(25);
//		tp2.setInstituto("Fake News");
//		tp2.setDataPesquisa(LocalDate.now());
//		tp2.setLocal("Rio de Janeiro");
//		tp2.setMediaIdade(32.7);
//		tp2.setTipoPesquisa("Presidente");
//		tp2.setDescricao("Pesquisa para presidente");
//
//		
//		TipoPesquisaController controller = new TipoPesquisaController();
//		try {
//			controller.salvar(tp1);
//			controller.salvar(tp2);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		for (TipoPesquisa tp : controller.listar()) {
//			System.out.println(tp.toString());
//		}
//	}
	
//	public static void testePesquisa() {
//		Pesquisa p1 = new Pesquisa();
//		p1.setId(1);
////		p1.getCandidatos();
////		p1.getPesquisa();
//		p1.setVotos(100);
//		
//		Pesquisa p2 = new Pesquisa();
//		p2.setId(2);
////		p2.setCandidatos(p2.getCandidatos());
////		p2.setPesquisa(p2.getPesquisa());
//		p2.setVotos(150);
//		
//		PesquisaController controller = new PesquisaController();
//		try {
//			controller.salvar(p1);
//			controller.salvar(p2);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		for (Pesquisa p : controller.listar()) {
//			System.out.println(p.toString());
//		}
//	}

}
