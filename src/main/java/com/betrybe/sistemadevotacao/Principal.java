package com.betrybe.sistemadevotacao;

import java.util.Objects;
import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    GerenciamentoVotacao gerVotacao = new GerenciamentoVotacao();
    Scanner scanInput = new Scanner(System.in);
    while (true) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      String opcaoCandidata = scanInput.next();
      if (Objects.equals(opcaoCandidata, "2")) {
        break;
      }
      System.out.println("Entre com o nome da pessoa candidata:");
      String nomeCandidata = scanInput.next();
      System.out.println("Entre com o número da pessoa candidata:");
      int numeroCandidata = Integer.parseInt(scanInput.next());
      gerVotacao.cadastrarPessoaCandidata(nomeCandidata, numeroCandidata);
    }
    while (true) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      String opcaoEleitora = scanInput.next();
      if (Objects.equals(opcaoEleitora, "2")) {
        break;
      }
      System.out.println("Entre com o nome da pessoa eleitora:");
      String nomeElitor = scanInput.next();
      System.out.println("Entre com o cpf da pessoa eleitora:");
      String numeroEleitor = scanInput.next();
      gerVotacao.cadastrarPessoaEleitora(nomeElitor, numeroEleitor);
    }
    while (true) {
      System.out.println(" Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      String opcaoVotar = scanInput.next();
      if (Objects.equals(opcaoVotar, "1")) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanInput.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = Integer.parseInt(scanInput.next());
        gerVotacao.votar(cpf, numeroCandidato);
      }
      if (Objects.equals(opcaoVotar, "2")) {
        gerVotacao.mostrarResultado();
      }
      if (Objects.equals(opcaoVotar, "3")) {
        gerVotacao.mostrarResultado();
        break;
      }
    }
    scanInput.close();
  }

}
