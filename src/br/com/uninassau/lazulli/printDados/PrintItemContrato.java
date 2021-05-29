package br.com.uninassau.lazulli.printDados;

import br.com.uninassau.lazulli.entidades.ItemContrato;

import java.util.List;

public class PrintItemContrato {
    public static void print(List<ItemContrato> itemContratos){
        for (ItemContrato item :
                itemContratos) {
            System.out.println(infoItemContrato(item));
        }

    }

    private static String infoItemContrato(ItemContrato itemContrato){
        String item = "Item: " + itemContrato.getItem().getNomeDoItem() + " ::: "
                + "Qtd: " + itemContrato.getQuantidade();
        
        return item;
    }
}
