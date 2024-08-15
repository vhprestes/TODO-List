package org.todo;

import java.io.File;
import java.io.FileNotFoundException;
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
public class Main {

  public static void main(String[] args) throws FileNotFoundException {
// DONE: método que lê o arquivo txt file.txt
    String path = "/home/victor/Documentos/projetos/zg-projetos/k1-t3/to-do/src/main/java/org/todo/file.txt";
    File file = new File(path);
    Scanner input = new Scanner(System.in);
    ConsultarTasksPorStatus(file, "DOING");


//    TESTE DE CRIAÇÃO DE TASK - AS TASKS DEVEM SER CRIADAS NESSE FORMATO, UTILIZANDO PARSEDATE PARA A DATA
//    Task task = new Task("Estudar", "Estudar Java", parseDate("10/10/2024"), 1, CategoryModel.ESTUDOS, StatusModel.TODO);
//  //escreve task no arquivo txt, com cada item separado por |
//    System.out.println("A TASK VEIO ASSIM:" + task.toString());



    Menu();
    int option = input.nextInt();

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


  public static void ConsultarTasksPorStatus (File file, String status) throws FileNotFoundException {
//    os status são: TODO, DOING, DONE. O método deve retornar todas as tasks com o status informado
    Scanner input = new Scanner(file);
    while (input.hasNextLine()) {
      String data = input.nextLine();
      if (data.toUpperCase().contains(status)) {
        System.out.println("Aqui é: ConsultarTaskPorStatus: " + data);
      }
    }
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