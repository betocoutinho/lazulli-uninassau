package br.com.uninassau.lazulli.capturaDados;

import java.util.Scanner;

public class ItemContratoCaptura {

    public static int capturaQuantidade(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe a quantidade do item: ");

        int quantidade = leitor.nextInt();



        return quantidade;
    }
}
