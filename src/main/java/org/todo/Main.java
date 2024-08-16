package org.todo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.interfaces.CategoryModel;
import org.interfaces.StatusModel;
import org.interfaces.Task;
import java.util.Date;

//  TODO: criar um método abstrato que substitua todos os métodos em um só

public class Main {

  public static void main(String[] args) throws IOException {
// DONE: método que lê o arquivo txt file.txt
    String path = "/home/victor/Documentos/projetos/zg-projetos/k1-t3/to-do/src/main/java/org/todo/file.txt";
    File file = new File(path);
    Scanner input = new Scanner(System.in);

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
//        DONE: método que adiciona uma task no txt
        System.out.println("Adicionar task");
        AdicionarTask(file);
        break;
      case 5:
//        DONE: método que remove uma task no txt (pelo nome)
        System.out.println("Remover task");
        RemoverTaskMenu(file);
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
        System.out.println("Tarefa: " + data);
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




  public static void AdicionarTask(File file) throws IOException {
    Scanner input = new Scanner(System.in);

    System.out.println("Digite o nome da tarefa:");
    String nome = input.nextLine();

    System.out.println("Digite a descrição da tarefa:");
    String descricao = input.nextLine();

    System.out.println("Digite a data da tarefa (dd/MM/yyyy):");
    String dataStr = input.nextLine();
    Date data = null;
    try {
      data = parseDate(dataStr);
    } catch (Exception e) {
      System.out.println("A data foi informada em um formato não válido. Tente novamente com o formato dd/MM/yyyy");
      return;
    }

    System.out.println("Digite um número de 1 a 5 correspondente a prioridade da tarefa:");
    int prioridade = input.nextInt();
    if (prioridade < 1 || prioridade > 5) {
      System.out.println("A prioridade informada é inválida. Tente novamente com um número de 1 a 5");
      return;
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
        return;
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
        return;
    }

    Task novaTask = new Task(nome, descricao, data, prioridade, categoryModelOption, statusModelOption);

    List<Task> tasks = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] taskData = line.split("\\|");
        String taskName = taskData[0].trim();
        String taskDescription = taskData[1].trim();
        Date taskDate = parseDate(taskData[2].trim());
        int taskPriority = Integer.parseInt(taskData[3].trim());
        CategoryModel taskCategory = CategoryModel.valueOf(taskData[4].trim().toUpperCase());
        StatusModel taskStatus = StatusModel.valueOf(taskData[5].trim().toUpperCase());
        tasks.add(new Task(taskName, taskDescription, taskDate, taskPriority, taskCategory, taskStatus));
      }
    }

    tasks.add(novaTask);
    tasks.sort((t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority()));

    try (FileWriter writer = new FileWriter(file)) {
      for (Task task : tasks) {
        writer.write(task.toString() + System.lineSeparator());
      }
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


    public static void RemoverTaskMenu(File file) throws IOException {
      Scanner input = new Scanner(System.in);
      System.out.println("Digite o nome da tarefa que deseja remover:");
      String taskName = input.nextLine();
      RemoverTask(file, taskName);
    }


  public static void RemoverTask(File file, String taskName) throws IOException {
    List<String> lines = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
//      reading
      while ((line = reader.readLine()) != null) {
        // Se o nome da tarefa na linha não for igual ao nome da tarefa a ser removida, adiciona a linha à lista

        if (!line.split("\\|")[0].trim().equalsIgnoreCase(taskName)) {
          lines.add(line);
        }
      }
    }
// writing
    try (FileWriter writer = new FileWriter(file)) {
      for (String line : lines) {
        writer.write(line + System.lineSeparator());
      }
    }
    System.out.println("Tarefa removida com sucesso!");
  }




}