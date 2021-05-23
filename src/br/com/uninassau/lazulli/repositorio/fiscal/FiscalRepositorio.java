package br.com.uninassau.lazulli.repositorio.fiscal;

import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;
import br.com.uninassau.lazulli.entidades.Fiscal;
import br.com.uninassau.lazulli.repositorio.ICrud;

import java.sql.*;
import java.util.List;

public class FiscalRepositorio implements ICrud<Fiscal> {

    @Override
    public void create(Fiscal object) {
        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO FISCAL(NOME, TELEFONE) VALUES (?,?)");

            ps.setString(1, object.getNomeDoFiscal());
            ps.setString(2, object.getTelefone());

            ps.executeUpdate();

            ps.close();
            conexao.close();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Fiscal read(int x) {
        Fiscal fiscal = null;

        try {
            String sql = "SELECT * FROM FISCAL WHERE COD_FISCAL = " + x;
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            resultado.next();

            int codigo = resultado.getInt(1);
            String nome = resultado.getString(2);
            String telefone = resultado.getString(3);

            fiscal = new Fiscal(codigo, nome, telefone);

            resultado.close();
            smt.close();
            ConexaoMySQL.FecharConexao();
        }catch (SQLException e){
            e.printStackTrace();

        }

        return fiscal;
    }

    @Override
    public List<Fiscal> read() {
        return null;
    }

    @Override
    public void update(int x, Fiscal object) {

    }

    @Override
    public void delete(int x) {

    }
}
