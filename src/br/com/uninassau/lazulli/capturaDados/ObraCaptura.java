package br.com.uninassau.lazulli.capturaDados;

import java.util.Scanner;

public class ObraCaptura {

    public static String capturaNome(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o nome da Obra: ");

        String nome = leitor.nextLine();

        leitor.close();

        return nome;
    }

    public static String capturaEndereco(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o endereço da Obra: ");

        String endereco = leitor.nextLine();

        leitor.close();

        return endereco;
    }
}
