package br.com.uninassau.lazulli.capturaDados;

import java.util.Scanner;

public class EmpresaLocadoraCaptura {

    public static String capturaNome(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o nome da Empresa de Locação: ");

        String nome = leitor.nextLine();


        return nome;
    }

    public static String capturaEndereco(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o endereço da Empresa de Locação: ");

        String endereco = leitor.nextLine();


        return endereco;
    }
}
