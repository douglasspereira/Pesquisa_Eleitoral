package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
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
			pstmt.setInt(2, pesquisa.getCandidato().getId()); ;
			pstmt.setInt(3, pesquisa.getPesquisa().getId()); ;
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
			pstmt.setInt(1, pesquisa.getCandidato().getId());
			pstmt.setInt(2, pesquisa.getCandidato().getId()); ;
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
		
		try {
			String sql = "select id, c.id_candidato, votos from pesquisa p join candidato c on p.id_candidato = c.id_candidato";
			Statement stmt = con.createStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<pesquisa> listaPesquisa = new ArrayList<Pesquisa>();
			
			while(rs.next()) {
				Pesquisa pesquisa = new Pesquisa();
				pesquisa.setId(rs.getInt("id"));
				pesquisa.setVotos(rs.getInt("votos"));
				
				Candidato c = new Candidato();
				c.setId(rs.getInt("id"));
				listaPesquisa.add(pesquisa);

			}
			
			return listaPesquisa;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;

	}
	
}
