package controller;

import java.util.List;

import dao.PesquisaDao;
import model.Pesquisa;

public class PesquisaController {
	
	public void salvar(Pesquisa pesquisa) throws Exception {
		if (pesquisa.getCandidato() == null) {
			throw new Exception("Candidato Inválido");
		}
		if (pesquisa.getPesquisa() == null) {
			throw new Exception("Pesquisa Inválida");
		}
		PesquisaDao.getInstance().salvar(pesquisa);
	}
	
	public List<Pesquisa> listar(){
		return PesquisaDao.getInstance().listar();
	}

}
