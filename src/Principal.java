

import controller.CandidatoController;
import controller.PesquisaController;
import controller.TipoPesquisaController;
import model.Candidato;
import model.Pesquisa;
import model.TipoPesquisa;
import util.ConnectionUtil;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.LocalDate;

public class Principal {
	
	public static void main(String[] args) {
		
		listaPesquisa();
		System.out.println("-------------------------------");
//		salvar();
//		atualizar();
//		excluir();
//		listar();
//		System.out.println("-------------------------------");
			
	//	testeCandidato();
	//	testeTipoPesquisa();
	//	testePesquisa();
			
	}
	
	public static void salvar() {
		Candidato c1 = new Candidato();
		c1.setId(12);
		c1.setNome("Maria Santos");
		c1.setPartido("PSL");
		c1.setFichaLimpa("Sim");
		
		Candidato c2 = new Candidato();
		c2.setId(13);
		c2.setNome("Paulo Pereira");
		c2.setPartido("PT");
		c2.setFichaLimpa("Não");
		
		CandidatoController controller = new CandidatoController();
		try {
			controller.salvar(c1);
			controller.salvar(c2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Candidato c : controller.listar()) {
			System.out.println(c.toString());
		}
		
	}
	
	public static void atualizar() {
		Candidato c1 = new Candidato();
		c1.setId(11);
		c1.setNome("Chico Gomes");
		c1.setPartido("PT");
		c1.setFichaLimpa("Não");
		CandidatoController controller = new CandidatoController();
		try {
			controller.atualizar(c1);;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Candidato c : controller.listar()) {
			System.out.println(c.toString());
		}
		
	}
	
	public static void excluir() {
		CandidatoController controller = new CandidatoController();
		try {
			controller.excluir(11);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Candidato c : controller.listar()) {
			System.out.println(c.toString());
		}
	}
	
	public static void listar() {
		CandidatoController controller = new CandidatoController();
		try {
			controller.listar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Candidato c : controller.listar()) {
			System.out.println(c.toString());
		}
	}
	
	public static void listaPesquisa() {
		PesquisaController controller = new PesquisaController();
		try {
			controller.listar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Pesquisa p : controller.listar()) {
			System.out.println(p.toString());
		}
	}

}
