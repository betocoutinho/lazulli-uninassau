package br.com.uninassau.lazulli.relatorio;

import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class RelatorioDeFiscaisEmObras extends Relatorio{

    @Override
    public void print() {
        try {
            String sql = "select NOME, NOME_OBRA from FISCAL as f " +
                    "left join OBRA O on f.COD_FISCAL = O.FK_FISCAL_COD_FISCAL;";

            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            while (resultado.next()){

                System.out.println(
                        "Nome: " + resultado.getString(1)
                        + " ::: " + "Obra: " + resultado.getString(2)
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
