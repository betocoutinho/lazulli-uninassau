package br.com.uninassau.lazulli.entidades;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class Contrato {
    private int codigoDoContrato;
    private String numeroDoContrato;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private double precoDoContrato;
    private List<ItemContrato> itemList;

    public Contrato(int codigoDoContrato, String numeroDoContrato, LocalDate dataInicial, LocalDate dataFinal, double precoDoContrato, List<ItemContrato> itemList) {
        this.codigoDoContrato = codigoDoContrato;
        this.numeroDoContrato = numeroDoContrato;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.precoDoContrato = precoDoContrato;
        this.itemList = itemList;
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

    public List<ItemContrato> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemContrato> itemList) {
        this.itemList = itemList;
    }
}
