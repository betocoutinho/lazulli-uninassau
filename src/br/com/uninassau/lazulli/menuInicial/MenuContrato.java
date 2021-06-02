package br.com.uninassau.lazulli.menuInicial;

import br.com.uninassau.lazulli.contexto.ContratoContexto;

import java.util.Scanner;

public class MenuContrato {
    
    public static void menu(){
        Scanner leitor= new Scanner(System.in);
        ContratoContexto contratoContexto = new ContratoContexto();

        boolean status = true;
        do {
            System.out.println("Contratos");

            System.out.println("Selecione um numero: ");
            System.out.println("[1] - Consulta");
            System.out.println("[2] - Criação");
            System.out.println("[3] - Edição");
            System.out.println("[4] - Remoção");

            int entrada = leitor.nextInt();

            switch (entrada){
                case 1:
                    contratoContexto.consulta();
                    break;
                case 2:
                    contratoContexto.criar();
                    break;
                case 3:
                    contratoContexto.atualizar();
                    break;
                case 4:
                    contratoContexto.deletar();
                    break;
                default:
                    status = false;
            }
        }while (status);



    }
}
