package br.com.uninassau.lazulli.relatorio;

import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RelatorioDoTotalDeItens extends Relatorio {

    @Override
    public void print() {
        try {
            String sql = "select NOME_ITEM as Item, SUM(QUANTIDADE) as Quantidade " +
                    "from ITEM_CONTRATO as it inner join ITEM as i" +
                    " on it.FK_ITEM_COD_ITEM = i.COD_ITEM group by i.NOME_ITEM;";

            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            while (resultado.next()){
                System.out.println("Item: " + resultado.getString(1) + " ::: "
                + "Quantidade: " + resultado.getInt(2));
            }
            resultado.close();
            smt.close();
            ConexaoMySQL.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
