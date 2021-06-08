package br.com.uninassau.lazulli.relatorio;

import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RelatorioDeValorASerPago extends Relatorio{

    @Override
    public void print() {
        try {
            String sql = "select NOME_EMPRESA, sum(VALOR_DO_CONTRATO) from EMPRESA_LOCADORA as el " +
                    "inner join CONTRATO C " +
                    "on el.COD_EMPRESA = C.FK_EMPRESA_LOCADORA_COD_EMPRESA " +
                    "group by NOME_EMPRESA;";

            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            while (resultado.next()){

                System.out.println(
                        "Nome da Empresa: " + resultado.getString(1)
                        + " ::: " + "Valor a pagar: R$ "
                        + resultado.getDouble(2)
                );
            }

            resultado.close();
            smt.close();
            ConexaoMySQL.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
