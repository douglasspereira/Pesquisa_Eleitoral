package model;

import java.time.LocalDate;

public class TipoPesquisa {
	
	private int id;
	private String instituto;
	private LocalDate dataPesquisa;
	private String local;
	private Double mediaIdade;
	private String tipoPesquisa;
	private String descricao;
	
	public TipoPesquisa(int id, String instituto, LocalDate dataPesquisa, String local, Double mediaIdade,
			String tipoPesquisa, String descricao) {
		this.id = id;
		this.instituto = instituto;
		this.dataPesquisa = dataPesquisa;
		this.local = local;
		this.mediaIdade = mediaIdade;
		this.tipoPesquisa = tipoPesquisa;
		this.descricao = descricao;
	}
	
	public TipoPesquisa() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInstituto() {
		return instituto;
	}
	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}
	public LocalDate getDataPesquisa() {
		return dataPesquisa;
	}
	public void setDataPesquisa(LocalDate dataPesquisa) {
		this.dataPesquisa = dataPesquisa;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Double getMediaIdade() {
		return mediaIdade;
	}
	public void setMediaIdade(Double mediaIdade) {
		this.mediaIdade = mediaIdade;
	}
	public String getTipoPesquisa() {
		return tipoPesquisa;
	}
	public void setTipoPesquisa(String tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString(){
		return instituto + " - " + dataPesquisa + " - " + local + " - " + mediaIdade + " - " + tipoPesquisa + " - " + descricao;
	}
	
}
