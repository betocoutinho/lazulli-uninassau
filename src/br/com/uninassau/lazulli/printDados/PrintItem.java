package br.com.uninassau.lazulli.printDados;

import br.com.uninassau.lazulli.entidades.Item;

import java.util.List;

public class PrintItem {

    public static void print(Item item){
        System.out.println(
                "COD: " + item.getCodigoDoItem() + " ::: Item: " + item.getNomeDoItem()
        );
    }

    public static void print(List<Item> itens){
        for (Item item : itens) {
            print(item);
        }
    }
}
