package br.com.uninassau.lazulli.capturaDados;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;


public class ContratoCaptura {

    public static String capturaNumeroDoContrato(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o numero do Contrato: ");

        String nome = leitor.nextLine();

        leitor.close();

        return nome;
    }

    public static LocalDate capturaData(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe a data neste formato dd/MM/aaaa: ");

        String data = leitor.nextLine();

       String[] splitData = data.split("/");

       int[] dataInt = Arrays.stream(splitData).mapToInt(v -> Integer.parseInt(v)).toArray();

       LocalDate novaData = LocalDate.of(dataInt[2], dataInt[1], dataInt[0]);

        leitor.close();

       return novaData;




    }

    public static double capturaPreco(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o preço  do contrato: ");

        double preco = leitor.nextDouble();

        leitor.close();

        return preco;
    }
}
