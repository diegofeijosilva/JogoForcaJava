package com.jogoforca.model;

public class Ranking {
	
	private Integer id;
	private Float pontos;
	private Jogador jogador;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getPontos() {
		return pontos;
	}
	public void setPontos(Float pontos) {
		this.pontos = pontos;
	}
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

}
