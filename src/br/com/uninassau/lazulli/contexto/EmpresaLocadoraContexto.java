package br.com.uninassau.lazulli.contexto;

import br.com.uninassau.lazulli.capturaDados.EmpresaLocadoraCaptura;
import br.com.uninassau.lazulli.capturaDados.FiscalCaptura;
import br.com.uninassau.lazulli.entidades.EmpresaLocadora;
import br.com.uninassau.lazulli.entidades.Fiscal;
import br.com.uninassau.lazulli.entidades.Item;
import br.com.uninassau.lazulli.printDados.PrintEmpresaLocadora;
import br.com.uninassau.lazulli.printDados.PrintFiscal;
import br.com.uninassau.lazulli.printDados.PrintItem;
import br.com.uninassau.lazulli.repositorios.EmpresaLocadoraRepositorio;

import java.util.List;
import java.util.Scanner;

public class EmpresaLocadoraContexto implements IContexto{

    EmpresaLocadoraRepositorio repositorio;
    Scanner leitor;

    public EmpresaLocadoraContexto() {
        this.repositorio = new EmpresaLocadoraRepositorio();
        this.leitor = new Scanner(System.in);
    }

    @Override
    public void consulta() {
        boolean indicador = true;

        do {
            System.out.println("------Empresas Cadastradas-------");
            System.out.println();

            List<EmpresaLocadora> itens = this.repositorio.readList();

            PrintEmpresaLocadora.print(itens);

            ElementosDeContexto.miniMenuDeContexto("Empresa Locadora");

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

        this.leitor.close();
    }

    @Override
    public void criar() {
        System.out.println("------Tela de Cadastro de Empresas------");

        String nome = EmpresaLocadoraCaptura.capturaNome();
        String endereco = EmpresaLocadoraCaptura.capturaEndereco();

        this.repositorio.create(new EmpresaLocadora(0, nome, endereco));

    }

    @Override
    public void atualizar() {
        List<EmpresaLocadora> itemList = this.repositorio.readList();

        System.out.println("------Tela de Atualização------");

        PrintEmpresaLocadora.print(itemList);

        System.out.println();

        System.out.println("Informe o codigo da empresa para atualização: ");
        int codigo = leitor.nextInt();

        boolean teste = itemList.stream().anyMatch(v -> v.getCodigoEmpresaLocadora() == codigo);

        if(!teste){
            System.out.println("Este numero não existe");
            return;
        }

        EmpresaLocadora novoItem = itemList.stream().filter(v -> v.getCodigoEmpresaLocadora() == codigo).findFirst().get();

        String nome = novoItem.getNome();
        String endereco = novoItem.getEndereco();
        boolean status = true;

        do{

            System.out.println("Escolha o item do fiscal para atualização: ");
            System.out.println("[1] para atualizar nome");
            System.out.println("[2] para atualizar endereco");

            int entrada = this.leitor.nextInt();

            switch (entrada){
                case 1:
                    nome = EmpresaLocadoraCaptura.capturaNome();
                    status = false;
                    break;
                case 2:
                    endereco = EmpresaLocadoraCaptura.capturaEndereco();
                    status = false;
                    break;
                default:
                    System.out.println("Seleção inválida!!!");
                    status = true;
            }

        }while (status);

        novoItem.setNome(nome);
        novoItem.setEndereco(endereco);

        this.repositorio.update(codigo, novoItem);

    }

    @Override
    public void deletar() {
        List<EmpresaLocadora> itemList = this.repositorio.readList();

        System.out.println("------Tela de Remoção------");

        PrintEmpresaLocadora.print(itemList);

        System.out.println();

        System.out.println("Informe o codigo da empresa para remoção: ");
        int codigo = this.leitor.nextInt();


        boolean teste = itemList.stream().anyMatch(v -> v.getCodigoEmpresaLocadora() == codigo);

        if(!teste){
            System.out.println("Este numero não existe");
            return;
        }

        this.repositorio.delete(codigo);
    }
}
