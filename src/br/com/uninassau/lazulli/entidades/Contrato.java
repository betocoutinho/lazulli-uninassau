package br.com.uninassau.lazulli.entidades;



import java.time.LocalDate;
import java.util.List;

public class Contrato {
    private int codigoDoContrato;
    private String numeroDoContrato;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private double precoDoContrato;
    private EmpresaLocadora empresaLocadora;
    private Obra obra;
    private List<ItemContrato> itemList;

    public Contrato(int codigoDoContrato, String numeroDoContrato, LocalDate dataInicial, LocalDate dataFinal,
                    double precoDoContrato, EmpresaLocadora empresaLocadora,
                    Obra obra) {
        this.codigoDoContrato = codigoDoContrato;
        this.numeroDoContrato = numeroDoContrato;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.precoDoContrato = precoDoContrato;
        this.empresaLocadora = empresaLocadora;
        this.obra = obra;

    }

    public int getCodigoDoContrato() {
        return codigoDoContrato;
    }

    public void setCodigoDoContrato(int codigoDoContrato) {
        this.codigoDoContrato = codigoDoContrato;
    }

    public String getNumeroDoContrato() {
        return numeroDoContrato;
    }

    public void setNumeroDoContrato(String numeroDoContrato) {
        this.numeroDoContrato = numeroDoContrato;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public double getPrecoDoContrato() {
        return precoDoContrato;
    }

    public void setPrecoDoContrato(double precoDoContrato) {
        this.precoDoContrato = precoDoContrato;
    }

    public EmpresaLocadora getEmpresaLocadora() {
        return empresaLocadora;
    }

    public void setEmpresaLocadora(EmpresaLocadora empresaLocadora) {
        this.empresaLocadora = empresaLocadora;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public List<ItemContrato> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemContrato> itemList) {
        this.itemList = itemList;
    }
}
