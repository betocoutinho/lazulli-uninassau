package br.com.uninassau.lazulli.contexto;

import br.com.uninassau.lazulli.capturaDados.ContratoCaptura;
import br.com.uninassau.lazulli.contexto.interfaces.Icontexto;
import br.com.uninassau.lazulli.entidades.Contrato;
import br.com.uninassau.lazulli.entidades.EmpresaLocadora;
import br.com.uninassau.lazulli.entidades.ItemContrato;
import br.com.uninassau.lazulli.entidades.Obra;
import br.com.uninassau.lazulli.printDados.PrintContrato;
import br.com.uninassau.lazulli.repositorios.ContratoRepositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContratoContexto implements Icontexto {
    ContratoRepositorio repositorio;
    Scanner leitor;

    public ContratoContexto() {
        this.repositorio = new ContratoRepositorio();
        this.leitor = new Scanner(System.in);
    }

    @Override
    public void consulta() {
        boolean teste = true;
        do {
            System.out.println("------Contratos Cadastrados-------");
            System.out.println();

            List<Contrato> contratoList = this.repositorio.readList();
            PrintContrato.print(contratoList);

            System.out.println("Digite [0] para sair");
            int entrada = this.leitor.nextInt();

            if (entrada == 0) teste = false;


        }while(teste);



    }

    @Override
    public void criar() {
        Contrato contrato = null;
        System.out.println("------Tela de Cadastro de Contratos------");

        String numero = ContratoCaptura.capturaNumeroDoContrato();

        System.out.println("Informe a data inicial:");
        LocalDate dataInicial = ContratoCaptura.capturaData();

        System.out.println("Informe a data Final:");
        LocalDate dataFinal = ContratoCaptura.capturaData();

        double valor = ContratoCaptura.capturaPreco();

        System.out.println("Escolha uma empresa Locadora");
        EmpresaLocadora empresaLocadora = ContratoCaptura.capturaEmpresaLocadora();

        System.out.println("Escolha uma Obra");
        Obra obra = ContratoCaptura.capturaObra();

        List<ItemContrato> listaItem = new ArrayList<>();

        System.out.println("Seleção de itens: ");
        boolean teste = true;

        do {
            listaItem.add(ContratoCaptura.capturaItemContrato());

            System.out.println("Você quer adicionar outro item: [0] Não e [1] Sim");
            int saida = this.leitor.nextInt();

            if (saida == 0) teste = false;
        }while (teste);

        contrato = new Contrato(0, numero, dataInicial, dataFinal, valor, empresaLocadora, obra);
        contrato.setItemList(listaItem);

        this.repositorio.create(contrato);

        System.out.println("--------------------------------------");
        System.out.println("Contrato Salvo com sucesso!!!");
        System.out.println("--------------------------------------");

    }

    @Override
    public void atualizar() {
        List<Contrato> contratoList = this.repositorio.readList();

        System.out.println("------Tela de Atualização------");

        PrintContrato.print(contratoList);

        System.out.println();

        System.out.println("Informe o codigo do contrato para atualização: ");
        int codigo = leitor.nextInt();

        boolean teste = contratoList.stream().anyMatch(v -> v.getCodigoDoContrato() == codigo);

        if(!teste){
            System.out.println("----Este numero não existe!!!!----");
            return;
        }

        Contrato contratoSelecionado = contratoList.stream().filter(v -> v.getCodigoDoContrato() == codigo).findFirst().get();

        boolean status = true;

        do{

            System.out.println("Escolha o item da obra para atualização: ");
            System.out.println("[1] para atualizar numero do contrato");
            System.out.println("[2] para atualizar Data Inicial");
            System.out.println("[3] para atualizar Data Final");
            System.out.println("[4] para atualizar valor do contrato");
            System.out.println("[5] para atualizar empresa locadora");
            System.out.println("[6] para atualizar obra");

            int entrada = this.leitor.nextInt();

            switch (entrada){
                case 1:
                    String numero = ContratoCaptura.capturaNumeroDoContrato();
                    contratoSelecionado.setNumeroDoContrato(numero);
                    status = false;
                    break;
                case 2:
                    LocalDate dataIni = ContratoCaptura.capturaData();
                    contratoSelecionado.setDataInicial(dataIni);
                    status = false;
                    break;
                case 3:
                    LocalDate dataFim = ContratoCaptura.capturaData();
                    contratoSelecionado.setDataFinal(dataFim);
                    status = false;
                    break;
                case 4:
                    double valorContrato = ContratoCaptura.capturaPreco();
                    contratoSelecionado.setPrecoDoContrato(valorContrato);
                    status = false;
                    break;
                case 5:
                    EmpresaLocadora empresaLocadora = ContratoCaptura.capturaEmpresaLocadora();
                    contratoSelecionado.setEmpresaLocadora(empresaLocadora);
                    status = false;
                    break;
                case 6:
                    Obra obra = ContratoCaptura.capturaObra();
                    contratoSelecionado.setObra(obra);
                    status = false;
                    break;
                default:
                    System.out.println("Seleção inválida!!!");
                    status = true;
            }

        }while (status);

        this.repositorio.update(codigo, contratoSelecionado);


    }

    @Override
    public void deletar() {
        List<Contrato> itemList = this.repositorio.readList();

        System.out.println("------Tela de Remoção------");

        PrintContrato.printFull(itemList);

        System.out.println();

        System.out.println("Informe o codigo do Contrato para remoção: ");
        int codigo = this.leitor.nextInt();


        boolean teste = itemList.stream().anyMatch(v -> v.getCodigoDoContrato() == codigo);

        if(!teste){
            System.out.println("----Este codigo não existe!!!----");
            return;
        }

        this.repositorio.delete(codigo);
    }

}
