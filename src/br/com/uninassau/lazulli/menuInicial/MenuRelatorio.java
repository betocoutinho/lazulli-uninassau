package br.com.uninassau.lazulli.menuInicial;

import br.com.uninassau.lazulli.contexto.ContratoContexto;
import br.com.uninassau.lazulli.contexto.ElementosDeContexto;
import br.com.uninassau.lazulli.contexto.RelatorioContexto;

import java.util.Scanner;

public class MenuRelatorio {

    public static void menu(){
        Scanner leitor= new Scanner(System.in);
        RelatorioContexto contexto = new RelatorioContexto();

        boolean status = true;
        do {
            ElementosDeContexto.pulaLinha();
            System.out.println("Relatórios");

            System.out.println("Selecione uma opção: ");
            System.out.println("[1] - Relatório de Fiscais em Obras");
            System.out.println("[2] - Relação de Equipamentos por Empresa");
            System.out.println("[3] - Relatório de valor a ser pago para as empresa de locação ");
            System.out.println("[4] - Relação do total de equipamentos alugados");
            System.out.println("[0] - Sair");

            int entrada = leitor.nextInt();

            switch (entrada){
                case 0:
                    return;
                case 1:
                    ElementosDeContexto.pulaLinha();
                    contexto.relatorioDeFiscaisEmObras();

                    break;
                case 2:
                    ElementosDeContexto.pulaLinha();
                    contexto.relatorioDeRelacaoDeEquipamentos();
                    break;
                case 3:
                    ElementosDeContexto.pulaLinha();
                    contexto.relatorioDevalorASerPago();
                    break;
                case 4:
                    ElementosDeContexto.pulaLinha();
                    contexto.relatoriosDoTotalDeItens();

                    break;
                default:
                    status = false;
            }
        }while (status);
    }
}
