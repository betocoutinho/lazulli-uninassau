package br.com.uninassau.lazulli.capturaDados;

import br.com.uninassau.lazulli.entidades.Fiscal;
import br.com.uninassau.lazulli.printDados.PrintFiscal;
import br.com.uninassau.lazulli.repositorios.FiscalRepositorio;

import java.util.List;
import java.util.Scanner;

public class ObraCaptura {

    public static String capturaNome(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o nome da Obra: ");

        String nome = leitor.nextLine();

        return nome;
    }

    public static String capturaEndereco(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o endereço da Obra: ");

        String endereco = leitor.nextLine();



        return endereco;
    }

    public static Fiscal capturaFiscal(){
        List<Fiscal> itemList = new FiscalRepositorio().readList();
        Scanner leitor = new Scanner(System.in);

        PrintFiscal.print(itemList);
        System.out.println("Digite o codigo do fiscal: ");
        boolean teste = true;
        int codigo = 0;
        do {
             codigo = leitor.nextInt();

            int finalCodigo = codigo;
            teste = itemList.stream().anyMatch(v -> v.getCodigoDoFiscal() == finalCodigo);

            if(!teste){
                System.out.println("Este numero não existe");
            }
        }while (!teste);


        int finalCodigo1 = codigo;
        Fiscal novoItem = itemList.stream().filter(v -> v.getCodigoDoFiscal() == finalCodigo1).findFirst().get();

        return novoItem;
    }
}
