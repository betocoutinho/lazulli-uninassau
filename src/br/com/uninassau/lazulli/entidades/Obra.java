package br.com.uninassau.lazulli.entidades;

public class Obra {
    private int codigoDaObra;
    private String nomedaObra;
    private String endereco;
    private Fiscal fiscal;

    public Obra(int codigoDaObra, String nomedaObra, String endereco, Fiscal fiscal) {
        this.codigoDaObra = codigoDaObra;
        this.nomedaObra = nomedaObra;
        this.endereco = endereco;
        this.fiscal = fiscal;
    }

    public int getCodigoDaObra() {
        return codigoDaObra;
    }

    public void setCodigoDaObra(int codigoDaObra) {
        this.codigoDaObra = codigoDaObra;
    }

    public String getNomedaObra() {
        return nomedaObra;
    }

    public void setNomedaObra(String nomedaObra) {
        this.nomedaObra = nomedaObra;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Fiscal getFiscal() {
        return fiscal;
    }

    public void setFiscal(Fiscal fiscal) {
        this.fiscal = fiscal;
    }
}
