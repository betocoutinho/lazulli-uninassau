package br.com.uninassau.lazulli.relatorio;

import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RelatorioDeRelacaoDeEquipamentosPorEmpresa extends Relatorio{
    @Override
    public void print() {

    }

    public void print(int x){
        try {
            String sql = "select NOME_ITEM, SUM(QUANTIDADE) from ITEM as i " +
                    "inner join ITEM_CONTRATO IC on i.COD_ITEM = IC.FK_ITEM_COD_ITEM " +
                    "inner join CONTRATO C on IC.FK_CONTRATO_COD_CONTRATO = C.COD_CONTRATO " +
                    "where FK_EMPRESA_LOCADORA_COD_EMPRESA = " + x +  " group by NOME_ITEM;";

            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            while (resultado.next()){

                System.out.println(
                        "Item: " + resultado.getString(1)
                        + " ::: " + "Quantidade: " + resultado.getInt(2)
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
