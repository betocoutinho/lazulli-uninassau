package br.com.uninassau.lazulli.printDados;

import br.com.uninassau.lazulli.entidades.EmpresaLocadora;

import java.util.List;

public class PrintEmpresaLocadora {

    public static void print(EmpresaLocadora empresaLocadora){
        System.out.println(
                "COD: " + empresaLocadora.getCodigoEmpresaLocadora() + " ::: "
                + "Nome: " + empresaLocadora.getNome()
                + " Endereço: " + empresaLocadora.getEndereco()
        );
    }

    public static void print(List<EmpresaLocadora> empresaLocadoras){
        for (EmpresaLocadora empresa:
             empresaLocadoras) {
            print(empresa);
        }
    }
}
