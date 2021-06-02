package br.com.uninassau.lazulli.menuInicial;

import br.com.uninassau.lazulli.contexto.ContratoContexto;
import br.com.uninassau.lazulli.contexto.ElementosDeContexto;

import java.util.Scanner;

public class MenuContrato {
    
    public static void menu(){
        Scanner leitor= new Scanner(System.in);
        ContratoContexto contratoContexto = new ContratoContexto();

        boolean status = true;
        do {
            ElementosDeContexto.pulaLinha();
            System.out.println("Contratos");

            System.out.println("Selecione um numero: ");
            System.out.println("[1] - Consulta");
            System.out.println("[2] - Criação");
            System.out.println("[3] - Edição");
            System.out.println("[4] - Remoção");
            System.out.println("[0] - Sair");

            int entrada = leitor.nextInt();

            switch (entrada){
                case 0:
                    return;
                case 1:
                    ElementosDeContexto.pulaLinha();
                    contratoContexto.consulta();
                    break;
                case 2:
                    ElementosDeContexto.pulaLinha();
                    contratoContexto.criar();
                    break;
                case 3:
                    ElementosDeContexto.pulaLinha();
                    contratoContexto.atualizar();
                    break;
                case 4:
                    ElementosDeContexto.pulaLinha();
                    contratoContexto.deletar();
                    break;
                default:
                    status = false;
            }
        }while (status);



    }
}
