package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.TipoPesquisa;
import util.ConnectionUtil;

public class TipoPesquisaDao {

	private static TipoPesquisaDao instance;
	private List<TipoPesquisa> listaTiposPesquisas = new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
	/*
	 * Singleton - Design Pattern
	 */
	
	public static TipoPesquisaDao getInstance() {
		if (instance == null) {
			instance = new TipoPesquisaDao();
		}
		return instance;
	}
	
	public void salvar(TipoPesquisa tipoPesquisa) {
		try {
//			Connection conexao = ConnectionUtil.getConnection();
			String sql = "insert into tipo_pesquisa (id, instituto, data_pesquisa, local, mediaIdade, tipoPesquisa, descricao) values (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tipoPesquisa.getId());
			pstmt.setString(2, tipoPesquisa.getInstituto());
			pstmt.setDate(3, java.sql.Date.valueOf(tipoPesquisa.getDataPesquisa()));
			pstmt.setString(4, tipoPesquisa.getLocal());
			pstmt.setDouble(5, tipoPesquisa.getMediaIdade());
			pstmt.setString(6, tipoPesquisa.getTipoPesquisa());
			pstmt.setString(7, tipoPesquisa.getDescricao());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(TipoPesquisa tipoPesquisa) {
		try {
//			Connection conexao = ConnectionUtil.getConnection();
			String sql = "update tipo_pesquisa set instituto = ?, data_pesquisa = ?, local = ?, mediaIdade = ?, tipoPesquisa = ?, descricao = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tipoPesquisa.getInstituto());
			pstmt.setDate(2, java.sql.Date.valueOf(tipoPesquisa.getDataPesquisa()));
			pstmt.setString(3, tipoPesquisa.getLocal());
			pstmt.setDouble(4, tipoPesquisa.getMediaIdade());
			pstmt.setString(5, tipoPesquisa.getTipoPesquisa());
			pstmt.setString(6, tipoPesquisa.getDescricao());
			pstmt.setInt(7, tipoPesquisa.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void excluir(int idPesquisa) {
		try {
			String sql = "delete from tipo_pesquisa where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idPesquisa);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<TipoPesquisa> listar(){
		List<TipoPesquisa> listaTiposPesquisa = new ArrayList<>();
		try {
//			Connection conexao = ConnectionUtil.getConnection();
			String sql = "select * from tipo_pesquisa";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				TipoPesquisa tp = new TipoPesquisa();
				tp.setId(rs.getInt("id"));
				tp.setInstituto(rs.getString("instistuto"));
				tp.setDataPesquisa(null);
				tp.setLocal(rs.getString("local"));
				tp.setMediaIdade(rs.getDouble("media_idade"));
				tp.setLocal(rs.getString("tipo_pesquisa"));
				tp.setDescricao(rs.getString("descricao"));
				listaTiposPesquisa.add(tp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaTiposPesquisa;
	}
	
}
