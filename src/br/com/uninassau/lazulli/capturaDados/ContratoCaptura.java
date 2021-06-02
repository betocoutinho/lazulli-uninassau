package br.com.uninassau.lazulli.capturaDados;

import br.com.uninassau.lazulli.entidades.*;
import br.com.uninassau.lazulli.printDados.PrintEmpresaLocadora;
import br.com.uninassau.lazulli.printDados.PrintFiscal;
import br.com.uninassau.lazulli.printDados.PrintItem;
import br.com.uninassau.lazulli.printDados.PrintObra;
import br.com.uninassau.lazulli.repositorios.EmpresaLocadoraRepositorio;
import br.com.uninassau.lazulli.repositorios.FiscalRepositorio;
import br.com.uninassau.lazulli.repositorios.ItemRepositorio;
import br.com.uninassau.lazulli.repositorios.ObraRepositorio;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ContratoCaptura {

    public static String capturaNumeroDoContrato(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o numero do Contrato: ");

        String nome = leitor.nextLine();



        return nome;
    }

    public static LocalDate capturaData(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe a data neste formato dd/MM/aaaa: ");

        String data = leitor.nextLine();

       String[] splitData = data.split("/");

       int[] dataInt = Arrays.stream(splitData).mapToInt(v -> Integer.parseInt(v)).toArray();

       LocalDate novaData = LocalDate.of(dataInt[2], dataInt[1], dataInt[0]);



       return novaData;




    }

    public static double capturaPreco(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o valor  do contrato: ");

        double preco = leitor.nextDouble();



        return preco;
    }

    public static EmpresaLocadora capturaEmpresaLocadora(){
        List<EmpresaLocadora> itemList = new EmpresaLocadoraRepositorio().readList();
        Scanner leitor = new Scanner(System.in);

        PrintEmpresaLocadora.print(itemList);
        System.out.println("Digite o codigo da Empresa: ");
        boolean teste = true;
        int codigo = 0;
        do {
            codigo = leitor.nextInt();

            int finalCodigo = codigo;
            teste = itemList.stream().anyMatch(v -> v.getCodigoEmpresaLocadora() == finalCodigo);

            if(!teste){
                System.out.println("Este numero não existe");
            }
        }while (!teste);


        int finalCodigo1 = codigo;
        EmpresaLocadora novoItem = itemList.stream().filter(v -> v.getCodigoEmpresaLocadora() == finalCodigo1).findFirst().get();

        return novoItem;
    }

    public static Obra capturaObra(){
        List<Obra> itemList = new ObraRepositorio().readList();
        Scanner leitor = new Scanner(System.in);

        PrintObra.print(itemList);
        System.out.println("Digite o codigo da Obra: ");
        boolean teste = true;
        int codigo = 0;
        do {
            codigo = leitor.nextInt();

            int finalCodigo = codigo;
            teste = itemList.stream().anyMatch(v -> v.getCodigoDaObra() == finalCodigo);

            if(!teste){
                System.out.println("Este numero não existe");
            }
        }while (!teste);


        int finalCodigo1 = codigo;
        Obra novoItem = itemList.stream().filter(v -> v.getCodigoDaObra() == finalCodigo1).findFirst().get();

        return novoItem;
    }

    public static ItemContrato capturaItemContrato(){
        List<Item> itemList = new ItemRepositorio().readList();
        Scanner leitor = new Scanner(System.in);

        PrintItem.print(itemList);
        System.out.println("Digite o codigo do item: ");
        boolean teste = true;
        int codigo = 0;
        do {
            codigo = leitor.nextInt();

            int finalCodigo = codigo;
            teste = itemList.stream().anyMatch(v -> v.getCodigoDoItem() == finalCodigo);

            if(!teste){
                System.out.println("Este numero não existe");
            }
        }while (!teste);


        int finalCodigo1 = codigo;
        Item novoItem = itemList.stream().filter(v -> v.getCodigoDoItem() == finalCodigo1).findFirst().get();

        int quantidade = ItemContratoCaptura.capturaQuantidade();


        return new ItemContrato(0, novoItem, quantidade);
    }
}
