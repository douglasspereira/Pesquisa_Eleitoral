package model;

public class Pesquisa {
	
	private int id;
	private Candidato candidatos;
	private TipoPesquisa pesquisa;
	private int votos;
	
	public Pesquisa(int id, Candidato candidatos, TipoPesquisa pesquisa, int votos) {
		this.id = id;
		this.candidatos = candidatos;
		this.pesquisa = pesquisa;
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
	public Candidato getCandidatos() {
		return candidatos;
	}
	public void setCandidatos(Candidato candidatos) {
		this.candidatos = candidatos;
	}
	public TipoPesquisa getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(TipoPesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
	
	public String toString(){
		return id + " - " + votos;
	}

}
