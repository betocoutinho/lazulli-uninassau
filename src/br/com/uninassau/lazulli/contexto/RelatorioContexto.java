package br.com.uninassau.lazulli.contexto;

import br.com.uninassau.lazulli.entidades.EmpresaLocadora;
import br.com.uninassau.lazulli.printDados.PrintEmpresaLocadora;
import br.com.uninassau.lazulli.relatorio.RelatorioDeFiscaisEmObras;
import br.com.uninassau.lazulli.relatorio.RelatorioDeRelacaoDeEquipamentosPorEmpresa;
import br.com.uninassau.lazulli.relatorio.RelatorioDeValorASerPago;
import br.com.uninassau.lazulli.relatorio.RelatorioDoTotalDeItens;
import br.com.uninassau.lazulli.repositorios.EmpresaLocadoraRepositorio;

import java.util.List;
import java.util.Scanner;

public class RelatorioContexto {

    private RelatorioDeFiscaisEmObras fiscaisEmObras;
    private RelatorioDeRelacaoDeEquipamentosPorEmpresa equipamentosPorEmpresa;
    private RelatorioDeValorASerPago valorASerPago;
    private RelatorioDoTotalDeItens totalDeItens;
    private Scanner leitor;


    public RelatorioContexto() {
        this.fiscaisEmObras = new RelatorioDeFiscaisEmObras();
        this.equipamentosPorEmpresa = new RelatorioDeRelacaoDeEquipamentosPorEmpresa();
        this.valorASerPago = new RelatorioDeValorASerPago();
        this.totalDeItens = new RelatorioDoTotalDeItens();
        this.leitor = new Scanner(System.in);
    }

    public void relatorioDeFiscaisEmObras(){

        boolean status = true;

        do {
            System.out.println("***Relatório de Fiscais em Obra***");
            this.fiscaisEmObras.print();

            System.out.println();
            System.out.println("Informe [0] para Sair");

            int saida = this.leitor.nextInt();

            if ((saida == 0)) {
                status = false;
            } else {
                System.out.println("Valor Incorreto");
            }
        }while (status);

    }

    public void relatorioDeRelacaoDeEquipamentos(){
        boolean status = true;

        do {
            System.out.println("***Relação de Equipamentos por Empresa***");

            List<EmpresaLocadora> empresaLocadoraList = new EmpresaLocadoraRepositorio().readList();
            PrintEmpresaLocadora.print(empresaLocadoraList);

            System.out.println();
            System.out.println("Digite o Codigo da Empresa de Locação");

            int codigo = this.leitor.nextInt();

            boolean verificaCodigo = empresaLocadoraList.stream().anyMatch(v -> codigo == v.getCodigoEmpresaLocadora());

            if (!verificaCodigo){
                System.out.println("Codigo invalido!!!");
                return;
            }

            empresaLocadoraList.stream().filter(v -> v.getCodigoEmpresaLocadora() == codigo)
                    .forEach(v -> {
                        System.out.println("Empresa selecionada: " + v.getNome());
                    });

            this.equipamentosPorEmpresa.print(codigo);

            System.out.println();
            System.out.println("Informe [0] para Sair");

            int saida = this.leitor.nextInt();

            if ((saida == 0)) {
                status = false;
            } else {
                System.out.println("Valor Incorreto");
            }
        }while (status);
    }

    public void relatorioDevalorASerPago(){
        boolean status = true;

        do {
            System.out.println("***Relatório de valor a ser pago para as empresa de locação***");
            this.valorASerPago.print();

            System.out.println();
            System.out.println("Informe [0] para Sair");

            int saida = this.leitor.nextInt();

            if ((saida == 0)) {
                status = false;
            } else {
                System.out.println("Valor Incorreto");
            }
        }while (status);
    }

    public void relatoriosDoTotalDeItens(){
        boolean status = true;

        do {
            System.out.println("***Relação do total de equipamentos alugados***");
            this.totalDeItens.print();

            System.out.println();
            System.out.println("Informe [0] para Sair");

            int saida = this.leitor.nextInt();

            if ((saida == 0)) {
                status = false;
            } else {
                System.out.println("Valor Incorreto");
            }
        }while (status);
    }

}
