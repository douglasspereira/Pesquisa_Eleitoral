package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
import util.ConnectionUtil;

public class CandidatoDao {

	private static CandidatoDao instance;
	private List<Candidato> listaCandidatos = new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
	/*
	 * Singleton - Design Pattern
	 */
	
	public static CandidatoDao getInstance() {
		if (instance == null) {
			instance = new CandidatoDao();
		}
		return instance;
	}
	
	public void salvar(Candidato candidato) {
		try {
//			Connection conexao = ConnectionUtil.getConnection();
			String sql = "insert into candidato (id, nome, ficha_limpa, partido) values (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, candidato.getId());
			pstmt.setString(2, candidato.getNome());
			pstmt.setString(3, candidato.getFichaLimpa());
			pstmt.setString(4, candidato.getPartido());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void atualizar(Candidato candidato) {
		try {
//			Connection conexao = ConnectionUtil.getConnection();
			String sql = "update candidato set nome = ?, ficha_limpa = ?, partido = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, candidato.getNome());
			pstmt.setString(2, candidato.getFichaLimpa());
			pstmt.setString(3, candidato.getPartido());
			pstmt.setInt(4, candidato.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idCandidato) {
		try {
			String sql = "delete from candidato where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idCandidato);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Candidato> listar(){
		List<Candidato> listaCandidatos = new ArrayList<>();
		try {
//			Connection conexao = ConnectionUtil.getConnection();
			String sql = "select * from candidato";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Candidato c = new Candidato();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setFichaLimpa(rs.getString("ficha_limpa"));
				c.setPartido(rs.getString("partido"));
				listaCandidatos.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaCandidatos;
	}
	
}
