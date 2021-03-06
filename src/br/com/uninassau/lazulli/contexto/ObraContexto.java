package br.com.uninassau.lazulli.contexto;

import br.com.uninassau.lazulli.capturaDados.ObraCaptura;
import br.com.uninassau.lazulli.contexto.interfaces.Icontexto;
import br.com.uninassau.lazulli.entidades.Fiscal;
import br.com.uninassau.lazulli.entidades.Obra;
import br.com.uninassau.lazulli.printDados.PrintObra;
import br.com.uninassau.lazulli.repositorios.FiscalRepositorio;
import br.com.uninassau.lazulli.repositorios.ObraRepositorio;

import java.util.List;
import java.util.Scanner;

public class ObraContexto implements Icontexto {
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
            ElementosDeContexto.pulaLinha();
            System.out.println("------Obras Cadastradas-------");
            System.out.println();

            List<Obra> itens = this.obraRepositorio.readList();

            PrintObra.print(itens);

            ElementosDeContexto.miniMenuDeContexto("Obra");

            String resposta = this.leitor.next();

            switch (resposta){
                case "0":
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
        Fiscal fiscalSelecionado = ObraCaptura.capturaFiscal();

        novaObra.setFiscal(fiscalSelecionado);

        this.obraRepositorio.create(novaObra);



    }

    @Override
    public void atualizar() {
        List<Obra> obraList = this.obraRepositorio.readList();

        System.out.println("------Tela de Atualiza????o------");

        PrintObra.print(obraList);

        System.out.println();

        System.out.println("Informe o codigo da obra para atualiza????o: ");
        int codigo = leitor.nextInt();

        boolean teste = obraList.stream().anyMatch(v -> v.getCodigoDaObra() == codigo);

        if(!teste){
            System.out.println("----Este numero n??o existe!!!!----");
            return;
        }

        Obra obraSelecionada = obraList.stream().filter(v -> v.getCodigoDaObra() == codigo).findFirst().get();

        String nome = obraSelecionada.getNomedaObra();
        String endereco = obraSelecionada.getEndereco();
        Fiscal fiscal = obraSelecionada.getFiscal();
        boolean status = true;

        do{

            System.out.println("Escolha o item da obra para atualiza????o: ");
            System.out.println("[1] para atualizar nome");
            System.out.println("[2] para atualizar endere??o");
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
                    System.out.println("Sele????o inv??lida!!!");
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

        System.out.println("------Tela de Remo????o------");

        PrintObra.print(itemList);

        System.out.println();

        System.out.println("Informe o codigo da obra para remo????o: ");
        int codigo = this.leitor.nextInt();


        boolean teste = itemList.stream().anyMatch(v -> v.getCodigoDaObra() == codigo);

        if(!teste){
            System.out.println("----Este codigo n??o existe!!!----");
            return;
        }

        this.obraRepositorio.delete(codigo);
    }
}
