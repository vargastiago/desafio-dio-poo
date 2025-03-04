package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		Curso curso1 = new Curso();
		curso1.setTitulo("curso java");
		curso1.setDescricao("descrição curso java");
		curso1.setCargaHoraria(8);

		Curso curso2 = new Curso();
		curso2.setTitulo("curso js");
		curso2.setDescricao("descrição curso js");
		curso2.setCargaHoraria(4);

		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("mentoria de java");
		mentoria.setDescricao("descrição mentoria java");
		mentoria.setData(LocalDate.now());

		ProjetoPratico projeto = new ProjetoPratico();
		projeto.setTitulo("projeto java");
		projeto.setDescricao("descrição projeto java");
		projeto.setDificuldade(7);

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcap Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);
		bootcamp.getConteudos().add(projeto);

		Dev devCamila = new Dev();
		devCamila.setNome("Camila");
		devCamila.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos Inscritos Camila" + devCamila.getConteudosInscritos());
		devCamila.progredir();
		devCamila.progredir();

		System.out.println("-");
		System.out.println("Conteúdos Inscritos Camila" + devCamila.getConteudosInscritos());
		System.out.println("Conteúdos Concluídos Camila" + devCamila.getConteudosConcluidos());
		System.out.println("XP: " + devCamila.calcularTotalXp());

		System.out.println("--------");

		Dev devJoao = new Dev();
		devJoao.setNome("João");
		devJoao.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos Inscritos João" + devJoao.getConteudosInscritos());
		devJoao.progredir();
		devJoao.progredir();
		devJoao.progredir();
		devJoao.progredir();
		devJoao.avaliarConteudo(projeto, 5, "Muito bom!");

		System.out.println("-");
		System.out.println("Conteúdos Inscritos João" + devJoao.getConteudosInscritos());
		System.out.println("Conteúdos Concluídos João" + devJoao.getConteudosConcluidos());
		System.out.println("XP: " + devJoao.calcularTotalXp());
		Certificado certificado = devJoao.gerarCertificado(bootcamp);
		System.out.println(certificado);
	}
}
