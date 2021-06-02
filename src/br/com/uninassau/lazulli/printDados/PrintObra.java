package br.com.uninassau.lazulli.printDados;

import br.com.uninassau.lazulli.entidades.Obra;

import java.util.List;

public class PrintObra {

    public static void print(Obra obra){
        System.out.println(
                "COD: " + obra.getCodigoDaObra() + " ::: "
                + "Empreendimento: " + obra.getNomedaObra()
                + " | End: " + obra.getEndereco()
                + " | Fiscal Responsavel: " + obra.getFiscal().getNomeDoFiscal()
        );
    }
    
    public static void print(List<Obra> obras){
        for (Obra obra :
                obras) {
            print(obra);
        }
    }
}
