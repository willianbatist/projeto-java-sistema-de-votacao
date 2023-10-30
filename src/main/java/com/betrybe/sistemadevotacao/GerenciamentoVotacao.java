package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<String> cpfsComputados;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<PessoaCandidata> pessoasCandidatas;

  /**
   * Instantiates a new Gerenciamento votacao.
   */
  public GerenciamentoVotacao() {
    cpfsComputados = new ArrayList<>();
    pessoasEleitoras = new ArrayList<>();
    pessoasCandidatas = new ArrayList<>();
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean numeroEmUso = false;

    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numero) {
        numeroEmUso = true;
        System.out.println("Número da pessoa candidata já utilizado!");
        break;
      }
    }
    if (!numeroEmUso) {
      pessoasCandidatas.add(new PessoaCandidata(nome, numero));
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean numeroEmUso = false;

    for (PessoaEleitora eleitor : pessoasEleitoras) {
      if (Objects.equals(eleitor.getCpf(), cpf)) {
        numeroEmUso = true;
        System.out.println("Pessoa eleitora já cadastrada!");
        break;
      }
    }
    if (!numeroEmUso) {
      pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean jaVotou = false;
    for (String cpf : cpfsComputados) {
      if (Objects.equals(cpf, cpfPessoaEleitora)) {
        jaVotou = true;
        System.out.println("Pessoa eleitora já votou!");
        break;
      }
    }
    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numeroPessoaCandidata && !jaVotou) {
        candidata.receberVoto();
      }
    }
    if (!jaVotou) {
      cpfsComputados.add(cpfPessoaEleitora);
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      for (PessoaCandidata candidata : pessoasCandidatas) {
        System.out.printf("Nome: %s - %s votos ( %s%s )%n", candidata.getNome(),
            candidata.getVotos(), candidata.getVotos() * 100 / cpfsComputados.size(), "%");
      }
      System.out.printf("Total de votos: %s%n", cpfsComputados.size());
    }
  }
}
