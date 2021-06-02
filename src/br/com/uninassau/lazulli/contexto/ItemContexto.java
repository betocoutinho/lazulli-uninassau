package br.com.uninassau.lazulli.contexto;

import br.com.uninassau.lazulli.capturaDados.ItemCaptura;
import br.com.uninassau.lazulli.entidades.Item;
import br.com.uninassau.lazulli.printDados.PrintItem;
import br.com.uninassau.lazulli.repositorios.ItemRepositorio;

import java.util.List;
import java.util.Scanner;

public class ItemContexto implements IContexto {

    ItemRepositorio repositorio;
    Scanner leitor;

    public ItemContexto() {
        this.repositorio = new ItemRepositorio();
        this.leitor = new Scanner(System.in);
    }

    @Override
    public void consulta() {
        boolean indicador = true;

        do {
            System.out.println("------Itens Cadastrados-------");
            System.out.println();

            List<Item> itens = this.repositorio.readList();

            PrintItem.print(itens);

            ElementosDeContexto.miniMenuDeContexto("Item");

            String entradaText = this.leitor.next();

            String resposta = entradaText;


            switch (resposta){
                case "0":
                    return;
                case "1":
                    this.criar();
                    break;
                case "2":
                    this.atualizar();
                    break;
                case "3":
                    this.deletar();
                    break;
                default:
                    indicador = true;
            }

        }while (indicador);





    }

    @Override
    public void criar() {
        System.out.println("------Tela de Cadastro de Item------");

        String nome = ItemCaptura.capturaNome();

        this.repositorio.create(new Item(0, nome));

    }

    @Override
    public void atualizar() {
        List<Item> itemList = this.repositorio.readList();

        System.out.println("------Tela de Atualização------");

        PrintItem.print(itemList);

        System.out.println();

        System.out.println("Informe o codigo do item para atualização: ");
        int codigo = leitor.nextInt();


        boolean teste = itemList.stream().anyMatch(v -> v.getCodigoDoItem() == codigo);

        if(!teste){
            System.out.println("Este numero não existe");
            return;
        }

        Item novoItem = itemList.stream().filter(v -> v.getCodigoDoItem() == codigo).findFirst().get();

        novoItem.setNomeDoItem(ItemCaptura.capturaNome());
        this.repositorio.update(codigo, novoItem);


    }

    @Override
    public void deletar() {
        List<Item> itemList = repositorio.readList();

        System.out.println("------Tela de Remoção------");

        PrintItem.print(itemList);

        System.out.println();

        System.out.println("Informe o codigo do item para remoção: ");
        int codigo = leitor.nextInt();


        boolean teste = itemList.stream().anyMatch(v -> v.getCodigoDoItem() == codigo);

        if(!teste){
            System.out.println("Este numero não existe");
            return;
        }

        repositorio.delete(codigo);

    }
}
