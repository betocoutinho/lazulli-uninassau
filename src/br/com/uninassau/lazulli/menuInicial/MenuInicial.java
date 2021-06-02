package br.com.uninassau.lazulli.menuInicial;

import br.com.uninassau.lazulli.contexto.EmpresaLocadoraContexto;
import br.com.uninassau.lazulli.contexto.FiscalContexto;
import br.com.uninassau.lazulli.contexto.ItemContexto;
import br.com.uninassau.lazulli.contexto.ObraContexto;
import br.com.uninassau.lazulli.entidades.Contrato;
import br.com.uninassau.lazulli.entidades.EmpresaLocadora;
import br.com.uninassau.lazulli.entidades.Fiscal;
import br.com.uninassau.lazulli.entidades.ItemContrato;

import java.util.Scanner;

public class MenuInicial {



    public static void inicio(){
        FiscalContexto fisca = new FiscalContexto();
        ObraContexto obraContexto = new ObraContexto();
        ItemContexto itemContexto = new ItemContexto();
        EmpresaLocadoraContexto empresaLocadoraContexto = new EmpresaLocadoraContexto();

        Scanner leitor  = new Scanner(System.in);

        boolean status = true;

        do {
            System.out.println("Menu Inicial");
            System.out.println();

            System.out.println("Escolha Selecione o item desejado");
            System.out.println("[1] - Contratos");
            System.out.println("[2] - Empresas de Locação");
            System.out.println("[3] - Obras");
            System.out.println("[4] - Fiscais");
            System.out.println("[5] - Itens");

            int element = leitor.nextInt();
            int entrada = element;

            switch (entrada){
                case 1:
                    MenuContrato.menu();
                    break;
                case 2:
                    empresaLocadoraContexto.consulta();
                    break;
                case 3:
                    obraContexto.consulta();
                    break;
                case 4:
                    fisca.consulta();
                    break;
                case 5:
                    itemContexto.consulta();
                    break;
                default:
                    status = false;
            }
        }while (status);



    }

}
