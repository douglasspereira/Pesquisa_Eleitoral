package model;

public class Candidato {
	
	private int id;
	private String nome;
	private String partido;
	private String fichaLimpa;
	
	public Candidato(int id, String nome, String partido, String fichaLimpa) {
		this.id = id;
		this.nome = nome;
		this.partido = partido;
		this.fichaLimpa = fichaLimpa;
	}
	
	public Candidato() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public String getFichaLimpa() {
		return fichaLimpa;
	}
	public void setFichaLimpa(String fichaLimpa) {
		this.fichaLimpa = fichaLimpa;
	}
	
	public String toString(){
		return nome + " - " + partido + " - " + fichaLimpa;
	}
	
	

}
