package br.com.uninassau.lazulli.entidades;

public class Fiscal {
    private int codigoDoFiscal;
    private String nomeDoFiscal;
    private String telefone;

    public Fiscal(int codigoDoFiscal, String nomeDoFiscal, String telefone) {
        this.codigoDoFiscal = codigoDoFiscal;
        this.nomeDoFiscal = nomeDoFiscal;
        this.telefone = telefone;
    }

    public int getCodigoDoFiscal() {
        return codigoDoFiscal;
    }

    public void setCodigoDoFiscal(int codigoDoFiscal) {
        this.codigoDoFiscal = codigoDoFiscal;
    }

    public String getNomeDoFiscal() {
        return nomeDoFiscal;
    }

    public void setNomeDoFiscal(String nomeDoFiscal) {
        this.nomeDoFiscal = nomeDoFiscal;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
