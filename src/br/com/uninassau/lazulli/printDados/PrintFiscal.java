package br.com.uninassau.lazulli.printDados;

import br.com.uninassau.lazulli.entidades.Fiscal;

import java.util.List;

public class PrintFiscal {

    public static void print(Fiscal fiscal){
        System.out.println(
                "COD: " + fiscal.getCodigoDoFiscal() + " ::: "
                + "Nome: " + fiscal.getNomeDoFiscal()
                + " | Telefone: " + fiscal.getTelefone()
        );
    }

    public static void print(List<Fiscal> fiscais){
        for (Fiscal fiscal:
             fiscais) {
            print(fiscal);
        }
    }
}
