package org.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Scanner;
import org.interfaces.CategoryModel;
import org.interfaces.StatusModel;
import org.interfaces.Task;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//  TODO: criar um método abstrato que substitua todos os métodos em um só

public class Main {

  public static void main(String[] args) throws IOException {
// DONE: método que lê o arquivo txt file.txt
    String path = "/home/victor/Documentos/projetos/zg-projetos/k1-t3/to-do/src/main/java/org/todo/file.txt";
    File file = new File(path);
    Scanner input = new Scanner(System.in);

//    ConsultarTasksPorPrioridade(file, 1);
//    ConsultarTasksPorCategoria(file, "Estudos");

//    TESTE DE CRIAÇÃO DE TASK - AS TASKS DEVEM SER CRIADAS NESSE FORMATO, UTILIZANDO PARSEDATE PARA A DATA
//    Task task = new Task("Estudar", "Estudar Java", parseDate("10/10/2024"), 1, CategoryModel.ESTUDOS, StatusModel.TODO);
//  //escreve task no arquivo txt, com cada item separado por |
//    System.out.println("A TASK VEIO ASSIM:" + task.toString());

    Menu();
    int option = input.nextInt();

    switch (option){
      case 1:
//        DONE: método que consulta as tasks por status no txt
        System.out.println("Consultar tasks por status");
        ConsultarTaskPorStatusMenu(file);
        break;
      case 2:
//        DONE: método que consulta as tasks por prioridade no txt
        System.out.println("Consultar tasks por prioridade");
        ConsultarTasksPorPrioridadeMenu(file);
        break;
      case 3:
//        DONE: método que consulta as tasks a por categoria no txt
        System.out.println("Consultar tasks por categoria");
        ConsultarTasksPorCategoriaMenu(file);
        break;
      case 4:
//        TODO: método que adiciona uma task no txt
        System.out.println("Adicionar task");
        adicionarTask(file);
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


  public static void ConsultarTaskPorStatusMenu(File file) throws FileNotFoundException {
    System.out.println("Escolha um status para filtrar:");
    System.out.println("1- TODO");
    System.out.println("2- DOING");
    System.out.println("3- DONE");

    Scanner input = new Scanner(System.in);
    int option = input.nextInt();

    switch (option) {
      case 1:
        ConsultarTasksPorStatus(file, "TODO");
        break;
      case 2:
        ConsultarTasksPorStatus(file, "DOING");
        break;
      case 3:
        ConsultarTasksPorStatus(file, "DONE");
        break;
      default:
        System.out.println("Opção inválida");

    }
  }

  public static void ConsultarTasksPorStatus (File file, String status) throws FileNotFoundException {
//    os status são: aTODO, DOING, DONE. O método deve retornar todas as tasks com o status informado
//    DONE
    Scanner input = new Scanner(file);
    while (input.hasNextLine()) {
      String data = input.nextLine();
      if (data.toUpperCase().contains(status)) {
        System.out.println("Aqui é: ConsultarTaskPorStatus: " + data);
      }
    }
  }



  public static void ConsultarTasksPorPrioridadeMenu(File file) throws FileNotFoundException {
    System.out.println("Escolha uma prioridade para filtrar:");
    System.out.println("1- Urgente");
    System.out.println("2- Alta");
    System.out.println("3- Media");
    System.out.println("4- Meh");
    System.out.println("5- Baixa");

    Scanner input = new Scanner(System.in);
    int option = input.nextInt();

    switch (option) {
      case 1:
        ConsultarTasksPorPrioridade(file, 1);
        break;
      case 2:
        ConsultarTasksPorPrioridade(file, 2);
        break;
      case 3:
        ConsultarTasksPorPrioridade(file, 3);
        break;
      case 4:
        ConsultarTasksPorPrioridade(file, 4);
        break;
      case 5:
        ConsultarTasksPorPrioridade(file, 5);
        break;
      default:
        System.out.println("Opção inválida");
        break;

    }
  }
  public static void ConsultarTasksPorPrioridade(File file, Integer prioridade) throws FileNotFoundException {
    Scanner input = new Scanner(file);
    while (input.hasNextLine()) {
      String data = input.nextLine();
      String[] task = data.split("\\|");
//    >>>>>>>>>>>>>  ATENÇÃO MULA (2) TEM QUE TER NOME E DESCRIÇÃO <<<<<<<<<<<<<
//  ao dividir a linha, os índices do array task são:
//  task[0] - Nome da Tarefa
//  task[1] - Descrição
//  task[2] - Data
//  task[3] - >>>>>>> Prioridade <<<<<<<
//  task[4] - Categoria
//  task[5] - Status
//      assim consigo aplicar em todos os filtros sem mudar muito
      int taskPriority = Integer.parseInt(task[3].trim());
      if (taskPriority == prioridade) {
        System.out.println("Aqui é: ConsultarTasksPorPrioridade: " + data);
      }
    }
  }



  public static void ConsultarTasksPorCategoriaMenu(File file) throws FileNotFoundException {
    System.out.println("Escolha uma categoria para filtrar:");
    System.out.println("1- Casa");
    System.out.println("2- Estudos");
    System.out.println("3- Trabalho");
    System.out.println("4- Lazer");

    Scanner input = new Scanner(System.in);
    int option = input.nextInt();

    switch (option) {
      case 1:
        ConsultarTasksPorCategoria(file, "Casa");
        break;
      case 2:
        ConsultarTasksPorCategoria(file, "Estudos");
        break;
      case 3:
        ConsultarTasksPorCategoria(file, "Trabalho");
        break;
      case 4:
        ConsultarTasksPorCategoria(file, "Lazer");
        break;
      default:
        System.out.println("Opção inválida");
        break;

    }
  }
  public static void ConsultarTasksPorCategoria(File file, String categoria) throws FileNotFoundException {
    Scanner input = new Scanner(file);
    while (input.hasNextLine()) {
      String data = input.nextLine();
      String[] task = data.split("\\|");
      String compare = task[4].trim().toUpperCase();
      if (compare.equals(categoria.toUpperCase())) {
        System.out.println("Tarefa: " + data);
      }
    }
  }




  public static void adicionarTask(File file) throws IOException {
    Scanner input = new Scanner(System.in);

    System.out.println("Digite o nome da tarefa:");
    String nome = input.nextLine();

    System.out.println("Digite a descrição da tarefa:");
    String descricao = input.nextLine();

    System.out.println("Digite a data da tarefa (dd/MM/yyyy):");
    String dataStr = input.nextLine();
    try {
      parseDate(dataStr);
    } catch (Exception e) {
      System.out.println("A data foi informada em um formato não válido. Tente novamente com o formato dd/MM/yyyy");
    }
//    Date data = parseDate(dataStr);
//    System.out.println("A data foi informada em um formato não válido. Tente novamente com o formato dd/MM/yyyy");


    System.out.println("Digite um número de 1 a 5 correspondente a prioridade da tarefa:");
    int prioridade = input.nextInt();
    try {
      if (prioridade < 1 || prioridade > 5) {
        throw new Exception();
      }
    } catch (Exception e) {
      System.out.println("A prioridade informada é inválida. Tente novamente com um número de 1 a 5");
    }

    input.nextLine(); // Consumir a nova linha

    System.out.println("Digite a categoria da tarefa. As categorias são: Casa, Estudos, Trabalho e Lazer");
    String categoria = input.nextLine();
    CategoryModel categoryModelOption = null;
    switch (categoria.toUpperCase()) {
      case "CASA":
        categoryModelOption = CategoryModel.CASA;
        break;
      case "ESTUDOS":
        categoryModelOption = CategoryModel.ESTUDOS;
        break;
      case "TRABALHO":
        categoryModelOption = CategoryModel.TRABALHO;
        break;
      case "LAZER":
        categoryModelOption = CategoryModel.LAZER;
        break;
      default:
        System.out.println("Categoria inválida");
        break;
    }

    System.out.println("Digite o status da tarefa. Os status são: TODO, DOING, DONE");
    String status = input.nextLine();
    StatusModel statusModelOption = null;
    switch (status.toUpperCase()) {
      case "TODO":
        statusModelOption = StatusModel.TODO;
        break;
      case "DOING":
        statusModelOption = StatusModel.DOING;
        break;
      case "DONE":
        statusModelOption = StatusModel.DONE;
        break;
      default:
        System.out.println("Status inválido");
        break;
    }

//    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//    String dataFormatada = dateFormat.format(data);

//    String novaTask = nome + " | " + dataFormatada + " | " + prioridade + " | " + categoria + " | " + status;

    Task novaTask = new Task(nome, descricao, parseDate(dataStr), prioridade, categoryModelOption, statusModelOption);


    try (FileWriter writer = new FileWriter(file, true)) {
      writer.write("\n" + novaTask.toString() );
    }
    System.out.println("Tarefa adicionada com sucesso!");
  }





    public static Date parseDate(String dateStr) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      try {
        return dateFormat.parse(dateStr);
      } catch (ParseException e) {
        e.printStackTrace();
        return null;
      }
    }





}