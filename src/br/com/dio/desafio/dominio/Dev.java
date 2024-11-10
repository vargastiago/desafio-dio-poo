package br.com.dio.desafio.dominio;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
	private String nome;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
	private Map<Conteudo, Avaliacao> avaliacoes = new HashMap<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}

	public void inscreverBootcamp(Bootcamp bootcamp) {
		conteudosInscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
	}

	public void progredir() {
		Optional<Conteudo> conteudo = conteudosInscritos.stream().findFirst();
		if (conteudo.isPresent()) {
			conteudosConcluidos.add(conteudo.get());
			conteudosInscritos.remove(conteudo.get());
		} else {
			System.err.println("Você não está matriculado em nenhum conteúdo!");
		}
	}

	public double calcularTotalXp() {
		return conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
	}

	public void avaliarConteudo(Conteudo conteudo, double nota, String feedback) {
		if (conteudosConcluidos.contains(conteudo)) {
			avaliacoes.put(conteudo, new Avaliacao(nota, feedback));
		} else {
			System.err.println("Conteúdo não concluído. Não pode ser avaliado!");
		}
	}

	public Certificado gerarCertificado(Bootcamp bootcamp) {
		if (conteudosInscritos.isEmpty()) {
			return new Certificado(this, bootcamp, calcularTotalXp());
		}
		return null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluidos, conteudosInscritos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudosConcluidos, other.conteudosConcluidos)
				&& Objects.equals(conteudosInscritos, other.conteudosInscritos) && Objects.equals(nome, other.nome);
	}
}
