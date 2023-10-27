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

  }

  @Override
  public void mostrarResultado() {

  }
}
