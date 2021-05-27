package br.com.uninassau.lazulli.capturaDados;

import java.util.Scanner;

public class FiscalCaptura {

    public static String capturaNome(){
        Scanner leitor = new Scanner(System.in);

        System.out.println("Informe o nome do Fiscal: ");
        String nome = leitor.nextLine();
        leitor.close();

        return nome;
    }

    public static String capturaTelefone(){
        Scanner leitor = new Scanner(System.in);

        System.out.println("Informe o telefone do Fiscal: ");
        String telefone = leitor.nextLine();
        leitor.close();

        return telefone;
    }
}
