package br.com.uninassau.lazulli.entidades;

public class EmpresaLocadora {
    private int codigoEmpresaLocadora;
    private String nome;
    private String endereco;

    public EmpresaLocadora(int codigoEmpresaLocadora, String nome, String endereco) {
        this.codigoEmpresaLocadora = codigoEmpresaLocadora;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getCodigoEmpresaLocadora() {
        return codigoEmpresaLocadora;
    }

    public void setCodigoEmpresaLocadora(int codigoEmpresaLocadora) {
        this.codigoEmpresaLocadora = codigoEmpresaLocadora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
