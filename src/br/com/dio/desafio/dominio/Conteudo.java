package br.com.dio.desafio.dominio;

import java.util.Objects;

public abstract class Conteudo {
	protected static final double XP_PADRAO = 10;

	private String titulo;
	private String descricao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	abstract double calcularXp();

	@Override
	public int hashCode() {
		return Objects.hash(descricao, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conteudo other = (Conteudo) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(titulo, other.titulo);
	}
}
