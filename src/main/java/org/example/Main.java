package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {
// TODO: método que lê o arquivo txt file.txt
    Scanner input = new Scanner(System.in);
    Menu();
    int option = input.nextInt();
//    System.out.print("Você digitou o número:  " + option);
    switch (option){
      case 1:
//        TODO: método que consulta as tasks concluidas no txt
        System.out.println("Consultar tasks concluidas");
        break;
      case 2:
//        TODO: método que consulta as tasks sendo feitas no txt
        System.out.println("Consultar tasks sendo feitas");
        break;
      case 3:
//        TODO: método que consulta as tasks a fazer no txt
        System.out.println("Consultar tasks a fazer");
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
//        TODO: método que edita uma task no txt
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
    System.out.println("1- Consultar tasks concluidas");
    System.out.println("2- Consultar tasks sendo feitas");
    System.out.println("3- Consultar tasks a fazer");
    System.out.println("4- Adicionar task");
    System.out.println("5- Remover task");
    System.out.println("6- Editar task");
    System.out.println("7- Sair");
  }
}