package com.jardimdigital.marvel.entities.dto;

import java.io.Serializable;

import com.jardimdigital.marvel.entities.Personagem;

public class PersonagemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String url_foto;
	private int aparicoes;
	private double popularidade;

	public PersonagemDTO() {
	}

	public PersonagemDTO(Long id, String nome, String url_foto, int aparicoes, double popularidade) {
		this.id = id;
		this.nome = nome;
		this.url_foto = url_foto;
		this.aparicoes = aparicoes;
		this.popularidade = popularidade;
	}

	public PersonagemDTO(Personagem entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.url_foto = entity.getUrl_foto();
		this.aparicoes = entity.getAparicoes();
		this.popularidade = entity.getPopularidade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}

	public int getAparicoes() {
		return aparicoes;
	}

	public void setAparicoes(int aparicoes) {
		this.aparicoes = aparicoes;
	}

	public double getPopularidade() {
		return popularidade;
	}

	public void setPopularidade(double popularidade) {
		this.popularidade = popularidade;
	}

}