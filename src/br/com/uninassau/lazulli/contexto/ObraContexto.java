package br.com.uninassau.lazulli.contexto;

import br.com.uninassau.lazulli.capturaDados.FiscalCaptura;
import br.com.uninassau.lazulli.capturaDados.ObraCaptura;
import br.com.uninassau.lazulli.entidades.Fiscal;
import br.com.uninassau.lazulli.entidades.Obra;
import br.com.uninassau.lazulli.printDados.PrintFiscal;
import br.com.uninassau.lazulli.printDados.PrintObra;
import br.com.uninassau.lazulli.repositorios.FiscalRepositorio;
import br.com.uninassau.lazulli.repositorios.ObraRepositorio;

import java.util.List;
import java.util.Scanner;

public class ObraContexto implements IContexto{
    ObraRepositorio obraRepositorio;
    Scanner leitor;

    public  ObraContexto(){
        this.obraRepositorio = new ObraRepositorio();
        this.leitor = new Scanner(System.in);
    }


    @Override
    public void consulta() {
        boolean indicador = true;

        do {
            System.out.println("------Obras Cadastradas-------");
            System.out.println();

            List<Obra> itens = this.obraRepositorio.readList();

            PrintObra.print(itens);

            ElementosDeContexto.miniMenuDeContexto("Obra");

            String resposta = this.leitor.next();

            switch (resposta){
                case "0":
                    leitor.close();
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

        Obra novaObra = null;
        System.out.println("------Tela de Cadastro de Obras------");

        String nome = ObraCaptura.capturaNome();
        String endereco = ObraCaptura.capturaEndereco();

        novaObra = new Obra(0, nome, endereco, null);

        FiscalRepositorio fiscalRepositorio = new FiscalRepositorio();

        List<Fiscal> fiscalList = fiscalRepositorio.readList();

        System.out.println("Digite o codigo de um Fiscal abaixo: ");
        PrintFiscal.print(fiscalList);

        int codigo = 0;
        boolean status = true;

        do{
            codigo = this.leitor.nextInt();
            int finalCodigo = codigo;
            status = fiscalList.stream().anyMatch(v -> v.getCodigoDoFiscal() == finalCodigo);
            if(!status){
                System.out.println("Codigo Invalido, digite Novamente!!!");
            }

        }while(!status);

        int finalCodigo1 = codigo;
        Fiscal fiscalSelecionado = fiscalList.stream().filter(v -> v.getCodigoDoFiscal() == finalCodigo1).findFirst().get();

        novaObra.setFiscal(fiscalSelecionado);

        this.obraRepositorio.create(novaObra);



    }

    @Override
    public void atualizar() {
        List<Obra> obraList = this.obraRepositorio.readList();
        List<Fiscal> fiscalList = new FiscalRepositorio().readList();

        System.out.println("------Tela de Atualização------");

        PrintObra.print(obraList);

        System.out.println();

        System.out.println("Informe o codigo da obra para atualização: ");
        int codigo = leitor.nextInt();

        boolean teste = obraList.stream().anyMatch(v -> v.getCodigoDaObra() == codigo);

        if(!teste){
            System.out.println("Este numero não existe");
            return;
        }

        Obra obraSelecionada = obraList.stream().filter(v -> v.getCodigoDaObra() == codigo).findFirst().get();

        String nome = obraSelecionada.getNomedaObra();
        String endereco = obraSelecionada.getEndereco();
        Fiscal fiscal = obraSelecionada.getFiscal();
        boolean status = true;

        do{

            System.out.println("Escolha o item da obra para atualização: ");
            System.out.println("[1] para atualizar nome");
            System.out.println("[2] para atualizar endereço");
            System.out.println("[3] para atualizar fiscal");

            int entrada = this.leitor.nextInt();



            switch (entrada){
                case 1:
                    nome = ObraCaptura.capturaNome();
                    status = false;
                    break;
                case 2:
                    endereco = ObraCaptura.capturaEndereco();
                    status = false;
                    break;
                case 3:
                    fiscal = ObraCaptura.capturaFiscal();
                    status = false;
                    break;
                default:
                    System.out.println("Seleção inválida!!!");
                    status = true;
            }

        }while (status);

        obraSelecionada.setNomedaObra(nome);
        obraSelecionada.setEndereco(endereco);
        obraSelecionada.setFiscal(fiscal);

        this.obraRepositorio.update(codigo, obraSelecionada);

    }

    @Override
    public void deletar() {
        List<Obra> itemList = this.obraRepositorio.readList();

        System.out.println("------Tela de Remoção------");

        PrintObra.print(itemList);

        System.out.println();

        System.out.println("Informe o codigo da obra para remoção: ");
        int codigo = this.leitor.nextInt();


        boolean teste = itemList.stream().anyMatch(v -> v.getCodigoDaObra() == codigo);

        if(!teste){
            System.out.println("Este codigo não existe");
            return;
        }

        this.obraRepositorio.delete(codigo);
    }
}
