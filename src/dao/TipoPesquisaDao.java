package dao;

import java.util.ArrayList;
import java.util.List;

import model.TipoPesquisa;

public class TipoPesquisaDao {

	private static TipoPesquisaDao instance;
	private List<TipoPesquisa> listaTiposPesquisas = new ArrayList<>();
	
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
		listaTiposPesquisas.add(tipoPesquisa);
	}
	
	public void atualizar(TipoPesquisa tipoPesquisa) {
		listaTiposPesquisas.set(tipoPesquisa.getId(), tipoPesquisa);
	}
	
	public void excluir(int idPesquisa) {
		listaTiposPesquisas.remove(idPesquisa);
	}
	
	public List<TipoPesquisa> listar(){
		return listaTiposPesquisas;
	}
	
}
