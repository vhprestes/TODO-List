package org.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {
// TODO: método que lê o arquivo txt file.txt
    File file = new File("file.txt");
    Scanner input = new Scanner(System.in);
    Menu();
    int option = input.nextInt();
//    System.out.print("Você digitou o número:  " + option);
    switch (option){
      case 1:
//        TODO: método que consulta as tasks por status no txt
        System.out.println("Consultar tasks por status");
        break;
      case 2:
//        TODO: método que consulta as tasks por prioridade no txt
        System.out.println("Consultar tasks por prioridade");
        break;
      case 3:
//        TODO: método que consulta as tasks a por categoria no txt
        System.out.println("Consultar tasks por categoria");
        break;
      case 4:
//        TODO: método que adiciona uma task no txt
        System.out.println("Adicionar task");
        break;
      case 5:
//        TODO: método que remove uma task no txt
        System.out.println("Remover task");
        break;
      case 6:
//        TODO: método que edita uma task no txt >> ESSE MÉTODO NÃO É OBRIGATÓRIO <<
        System.out.println("Editar task");
        break;
      case 7:
        System.out.println("Sair");
        break;
      default:
        System.out.println("Opção inválida");
    }
  }


  public static void Menu(){
    System.out.println("Escolha uma opção:");
    System.out.println("1- Consultar tasks por status");
    System.out.println("2- Consultar tasks por prioridade");
    System.out.println("3- Consultar tasks por categoria");
    System.out.println("4- Adicionar task");
    System.out.println("5- Remover task");
    System.out.println("6- Editar task");
    System.out.println("7- Sair");
  }



}