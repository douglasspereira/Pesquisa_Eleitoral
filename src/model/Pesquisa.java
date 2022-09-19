package model;

public class Pesquisa {
	
	private int id;
	private Candidato candidato;
	private TipoPesquisa tipopesquisa;
	private int votos;
	
	public Pesquisa(int id, Candidato candidato, TipoPesquisa tipoPesquisa, int votos) {
		this.id = id;
		this.candidato = candidato;
		this.tipopesquisa = tipoPesquisa;
		this.votos = votos;
	}
	
	public Pesquisa() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public TipoPesquisa getPesquisa() {
		return tipopesquisa;
	}

	public void setPesquisa(TipoPesquisa tipoPesquisa) {
		this.tipopesquisa = tipoPesquisa;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

}
