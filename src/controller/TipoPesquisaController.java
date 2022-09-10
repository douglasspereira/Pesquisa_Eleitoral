package controller;

import java.util.List;

import dao.TipoPesquisaDao;
import model.TipoPesquisa;

public class TipoPesquisaController {

	public void salvar(TipoPesquisa instituto) throws Exception {
		if (instituto.getInstituto() == null) {
			throw new Exception("Tipo de pesquisa inválida");
		}
		TipoPesquisaDao.getInstance().salvar(instituto);
	}
	
	public void atualizar(TipoPesquisa instituto) throws Exception {
		if (instituto.getInstituto() == null) {
			throw new Exception("Tipo de pesquisa inválida");
		}
		TipoPesquisaDao.getInstance().atualizar(instituto);
	}
	
	public void excluir(int idTipoPesquisa) throws Exception {
		if (idTipoPesquisa == 0) {
			throw new Exception("Nenhuma pesquisa selecionada");
		}
		TipoPesquisaDao.getInstance().excluir(idTipoPesquisa);
	}
	
	public List<TipoPesquisa> listar(){
		return TipoPesquisaDao.getInstance().listar();
	}
	
}
