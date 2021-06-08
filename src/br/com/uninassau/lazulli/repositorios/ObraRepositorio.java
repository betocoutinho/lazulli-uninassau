package br.com.uninassau.lazulli.repositorios;

import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;
import br.com.uninassau.lazulli.entidades.Fiscal;
import br.com.uninassau.lazulli.entidades.Obra;
import br.com.uninassau.lazulli.repositorios.interfaces.Irepositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ObraRepositorio implements Irepositorio<Obra> {

    @Override
    public void create(Obra object) {
        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO OBRA(NOME_OBRA, ENDERECO, FK_FISCAL_COD_FISCAL) values (?,?,?)");

            ps.setString(1, object.getNomedaObra());
            ps.setString(2, object.getEndereco());
            ps.setInt(3, object.getFiscal().getCodigoDoFiscal());

            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Obra read(int x) {
        Obra obra = null;

        try {
            String sql = "SELECT * FROM OBRA WHERE COD_OBRA = " + x;
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            resultado.next();

            int codigo = resultado.getInt(1);
            String nome = resultado.getString(2);
            String endereco = resultado.getString(3);
            Fiscal fiscal = new FiscalRepositorio().read(resultado.getInt(4));

            obra = new Obra(codigo, nome, endereco, fiscal);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obra;
    }

    @Override
    public List<Obra> readList() {
        List<Obra> obraList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM OBRA";
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            while (resultado.next()){
                int codigo = resultado.getInt(1);
                String nome = resultado.getString(2);
                String endereco = resultado.getString(3);
                Fiscal fiscal = new FiscalRepositorio().read(resultado.getInt(4));

                obraList.add(new Obra(codigo, nome, endereco, fiscal));
            }
            resultado.close();
            smt.close();
            ConexaoMySQL.FecharConexao();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obraList;
    }

    @Override
    public void update(int x, Obra object) {
        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            String sql = "UPDATE OBRA SET NOME_OBRA = ?, ENDERECO = ?, FK_FISCAL_COD_FISCAL = ? WHERE COD_OBRA = " + x;
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, object.getNomedaObra());
            ps.setString(2, object.getEndereco());
            ps.setInt(3, object.getFiscal().getCodigoDoFiscal());

            ps.executeUpdate();

            ps.close();
            conexao.close();

        }catch (SQLException e){
            e.printStackTrace();
        }



    }

    @Override
    public void delete(int x) {
        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            String sql = "DELETE FROM OBRA WHERE COD_OBRA = " + x;
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.executeUpdate();

            ps.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
