package br.com.uninassau.lazulli.contexto;

public class ElementosDeContexto {
    public static void miniMenuDeContexto(String elemento){
        System.out.println();
        System.out.println("Informe um dos codigos: ");
        System.out.println("[1] para adicionar " + elemento);
        System.out.println("[2] para atualizar " + elemento);
        System.out.println("[3] para deletar " + elemento);
        System.out.println("[0] Sair");
        System.out.println();
    }
}
