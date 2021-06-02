package br.com.uninassau.lazulli.contexto;

import br.com.uninassau.lazulli.capturaDados.FiscalCaptura;
import br.com.uninassau.lazulli.contexto.interfaces.IContexto;
import br.com.uninassau.lazulli.entidades.Fiscal;
import br.com.uninassau.lazulli.printDados.PrintFiscal;
import br.com.uninassau.lazulli.repositorios.FiscalRepositorio;

import java.util.List;
import java.util.Scanner;

public class FiscalContexto implements IContexto {

    FiscalRepositorio repositorio;
    Scanner leitor;

    public FiscalContexto() {
        this.repositorio = new FiscalRepositorio();
        this.leitor = new Scanner(System.in);
    }

    @Override
    public void consulta() {

        boolean indicador = true;

        do {
            ElementosDeContexto.pulaLinha();
            System.out.println("------Fiscais Cadastrados-------");
            System.out.println();

            List<Fiscal> itens = this.repositorio.readList();

            PrintFiscal.print(itens);

            ElementosDeContexto.miniMenuDeContexto("Fiscal");
            String resposta = this.leitor.nextLine();

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
        System.out.println("------Tela de Cadastro de Fiscais------");
        String nome = FiscalCaptura.capturaNome();
        String telefone = FiscalCaptura.capturaTelefone();

        this.repositorio.create(new Fiscal(0, nome, telefone));


    }

    @Override
    public void atualizar() {
        List<Fiscal> itemList = this.repositorio.readList();

        System.out.println("------Tela de Atualização------");

        PrintFiscal.print(itemList);

        System.out.println();

        System.out.println("Informe o codigo do fiscal para atualização: ");
        int codigo = leitor.nextInt();

        boolean teste = itemList.stream().anyMatch(v -> v.getCodigoDoFiscal() == codigo);

        if(!teste){
            System.out.println("Este numero não existe");
            return;
        }

        Fiscal novoItem = itemList.stream().filter(v -> v.getCodigoDoFiscal() == codigo).findFirst().get();

        String nome = novoItem.getNomeDoFiscal();
        String numero = novoItem.getTelefone();
        boolean status = true;

        do{

            System.out.println("Escolha o item do fiscal para atualização: ");
            System.out.println("[1] para atualizar nome");
            System.out.println("[2] para atualizar telefone");

            int entrada = this.leitor.nextInt();

            switch (entrada){
                case 1:
                    nome = FiscalCaptura.capturaNome();
                    status = false;
                break;
                case 2:
                    numero = FiscalCaptura.capturaTelefone();
                    status = false;
                break;
                default:
                    System.out.println("Seleção inválida!!!");
                    status = true;
            }

        }while (status);

        novoItem.setNomeDoFiscal(nome);
        novoItem.setTelefone(numero);

        this.repositorio.update(codigo, novoItem);



    }

    @Override
    public void deletar() {
        List<Fiscal> itemList = this.repositorio.readList();

        System.out.println("------Tela de Remoção------");

        PrintFiscal.print(itemList);

        System.out.println();

        System.out.println("Informe o codigo do item para remoção: ");
        int codigo = this.leitor.nextInt();


        boolean teste = itemList.stream().anyMatch(v -> v.getCodigoDoFiscal() == codigo);

        if(!teste){
            System.out.println("Este numero não existe");
            return;
        }

        this.repositorio.delete(codigo);
    }
}
