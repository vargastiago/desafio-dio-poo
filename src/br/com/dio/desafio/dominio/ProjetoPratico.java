package br.com.dio.desafio.dominio;

public class ProjetoPratico extends Conteudo {
	private int dificuldade;

	public int getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	@Override
	public String toString() {
		return "Mentoria [titulo=" + getTitulo() + ", descricao=" + getDescricao() + ", dificuldade=" + dificuldade + "]";
	}

	@Override
	double calcularXp() {
		return XP_PADRAO * dificuldade * 2;
	}
}
