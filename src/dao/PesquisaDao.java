package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Pesquisa;
import model.TipoPesquisa;
import util.ConnectionUtil;

public class PesquisaDao {

	private static PesquisaDao instance;
	private List<Pesquisa> listaPesquisas = new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
	public static PesquisaDao getInstance() {
		if (instance == null) {
			instance = new PesquisaDao();
		}
		return instance;
	}
	
	public void salvar(Pesquisa pesquisa) {
		try {
//			Connection conexao = ConnectionUtil.getConnection();
			String sql = "insert into pesquisa (id, candidato_id, tipo_pesquisa_id, votos) values (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pesquisa.getId());
			pstmt.setObject(2, pesquisa.getCandidatos()); ;
			pstmt.setObject(3, pesquisa.getPesquisa()); ;
			pstmt.setInt(4, pesquisa.getVotos());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Pesquisa pesquisa) {
		try {
//			Connection conexao = ConnectionUtil.getConnection();
			String sql = "update pesquisa set candidato_id = ?, tipo_pesquisa_id = ?, votos = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setObject(1, pesquisa.getCandidatos());
			pstmt.setObject(2, pesquisa.getCandidatos()); ;
			pstmt.setObject(3, pesquisa.getPesquisa()); ;
			pstmt.setInt(4, pesquisa.getVotos());
			pstmt.setInt(5, pesquisa.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void excluir(int idPesquisa) {
		try {
			String sql = "delete from pesquisa where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idPesquisa);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Pesquisa> listar(){
		List<Pesquisa> listaPesquisa = new ArrayList<>();
		try {
//			Connection conexao = ConnectionUtil.getConnection();
			String sql = "select * from pesquisa";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Pesquisa p = new Pesquisa();
				p.setId(rs.getInt("id"));
				p.setCandidatos(null); // não entendi como fazer aqui
				p.setPesquisa(null); // não entendi como fazer aqui
				p.setVotos(rs.getInt("votos"));
				listaPesquisa.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaPesquisa;

	}
	
}
