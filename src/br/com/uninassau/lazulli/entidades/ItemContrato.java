package br.com.uninassau.lazulli.entidades;

public class ItemContrato {
    private int codigoDoContrato;
    private Item item;
    private int quantidade;

    public ItemContrato(int codigoDoContrato, Item item, int quantidade) {
        this.codigoDoContrato = codigoDoContrato;
        this.item = item;
        this.quantidade = quantidade;
    }

    public int getCodigoDoContrato() {
        return codigoDoContrato;
    }

    public void setCodigoDoContrato(int codigoDoContrato) {
        this.codigoDoContrato = codigoDoContrato;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
