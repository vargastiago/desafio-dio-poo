package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Certificado {
	private Dev dev;
	private Bootcamp bootcamp;
	private LocalDate dataEmissao;
	private double totalXp;

	public Certificado(Dev dev, Bootcamp bootcamp, double totalXp) {
		this.dev = dev;
		this.bootcamp = bootcamp;
		this.dataEmissao = LocalDate.now();
		this.totalXp = totalXp;
	}

	@Override
	public String toString() {
		return String.format("Certificado de Conclusão: %s concluiu o bootcamp %s com um total de %.0f XP. Data: %s",
				dev.getNome(), bootcamp.getNome(), totalXp, dataEmissao);
	}
}
