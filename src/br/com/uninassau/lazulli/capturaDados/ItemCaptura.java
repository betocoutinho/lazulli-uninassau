package br.com.uninassau.lazulli.capturaDados;

import java.util.Scanner;

public class ItemCaptura {

   public static String capturaNome(){
       Scanner leitor = new Scanner(System.in);

       System.out.print("Informe o nome do Item: ");

       String nome = leitor.nextLine();



       return nome;
   }

}
