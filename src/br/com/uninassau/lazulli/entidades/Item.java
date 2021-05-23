package br.com.uninassau.lazulli.entidades;

public class Item {
    private int codigoDoItem;
    private String nomeDoItem;
    private int quantidade;

    public Item(int codigoDoItem, String nomeDoItem) {
        this.codigoDoItem = codigoDoItem;
        this.nomeDoItem = nomeDoItem;
    }

    public Item(int codigoDoItem, String nomeDoItem, int quantidade) {
        this.codigoDoItem = codigoDoItem;
        this.nomeDoItem = nomeDoItem;
        this.quantidade = quantidade;
    }

    public int getCodigoDoItem() {
        return codigoDoItem;
    }

    public void setCodigoDoItem(int codigoDoItem) {
        this.codigoDoItem = codigoDoItem;
    }

    public String getNomeDoItem() {
        return nomeDoItem;
    }

    public void setNomeDoItem(String nomeDoItem) {
        this.nomeDoItem = nomeDoItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


}
