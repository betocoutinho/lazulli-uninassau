package br.com.uninassau.lazulli.printDados;

import br.com.uninassau.lazulli.entidades.Contrato;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class PrintContrato {
    public static void print(Contrato contrato){
        System.out.println(
                "COD: " + contrato.getCodigoDoContrato() + " ::: "
                + "Empresa de Locação: " + contrato.getEmpresaLocadora().getNome()
                + " Data Inicio: " + contrato.getDataInicial().format(DateTimeFormatter.ofPattern("dd MM uuuu"))
                + " Data Final: " + contrato.getDataFinal().format(DateTimeFormatter.ofPattern("dd MM uuuu"))
                + " Valor: R$ " +  String.format("%.2f", contrato.getPrecoDoContrato())

        );
    }

    public static void print(List<Contrato> contratos){
        for (Contrato contrato :
                contratos) {
            print(contrato);
        }
    }

    public static void printFull(List<Contrato> contratos){

        contratos.stream().forEach(v -> {
            PrintContrato.print(v);
            v.getItemList().stream().forEach(t -> PrintItemContrato.infoItemContrato(t));
            System.out.println("--------------------------------------------------------------");
        });
    }
}
