package br.com.dio.desafio.dominio;

public class Avaliacao {
	private double nota;
	private String feedback;

	public Avaliacao(double nota, String feedback) {
		this.nota = nota;
		this.feedback = feedback;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Avaliacao [nota=" + nota + ", feedback=" + feedback + "]";
	}
}
