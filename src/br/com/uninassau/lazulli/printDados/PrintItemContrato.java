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

    public static String infoItemContrato(ItemContrato itemContrato){
        String item = "---->>COD: " + itemContrato.getItem().getCodigoDoItem() + " ::: "
                + "Nome: " + itemContrato.getItem().getNomeDoItem()
                + " Quantidade: " + itemContrato.getQuantidade();
        
        return item;
    }
}
