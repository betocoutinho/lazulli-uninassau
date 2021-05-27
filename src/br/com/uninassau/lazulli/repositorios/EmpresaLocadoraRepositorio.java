package br.com.uninassau.lazulli.repositorios;

import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;
import br.com.uninassau.lazulli.entidades.EmpresaLocadora;
import br.com.uninassau.lazulli.entidades.interfaces.IRepositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaLocadoraRepositorio implements IRepositorio<EmpresaLocadora> {
    @Override
    public void create(EmpresaLocadora object) {
        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO empresa_locadora(nome_empresa, endereco) VALUES (?,?)");


            ps.setString(1, object.getNome());
            ps.setString(2, object.getEndereco());
            ps.executeUpdate();

            ps.close();
            conexao.close();


        }catch (Exception e){
            e.printStackTrace();

        }

    }

    @Override
    public EmpresaLocadora read(int x) {
        EmpresaLocadora empresaLocadora = null;

        try {
            String sql = "SELECT * FROM empresa_locadora WHERE COD_EMPRESA = " + x;
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            resultado.next();



            int codigo = resultado.getInt(1);
            String nome = resultado.getString(2);
            String endereco = resultado.getString(3);

            empresaLocadora = new EmpresaLocadora(codigo, nome, endereco);

            resultado.close();
            smt.close();
            ConexaoMySQL.FecharConexao();



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empresaLocadora;
    }

    @Override
    public List<EmpresaLocadora> readList() {
        List<EmpresaLocadora> empresaLocadoras = new ArrayList<>();
        try {
            String sql = "SELECT * FROM empresa_locadora";
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);



            while (resultado.next()){
                int codigo = resultado.getInt(1);
                String nome = resultado.getString(2);
                String endereco = resultado.getString(3);

                empresaLocadoras.add(new EmpresaLocadora(codigo, nome, endereco));

            }

            resultado.close();
            smt.close();
            ConexaoMySQL.FecharConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return empresaLocadoras;
    }

    @Override
    public void update(int x, EmpresaLocadora object) {
        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            String sql = "UPDATE empresa_locadora SET NOME_EMPRESA = ?, ENDERECO = ? WHERE COD_EMPRESA = " + x;
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, object.getNome());
            ps.setString(2, object.getEndereco());
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
            String sql = "DELETE FROM empresa_locadora WHERE COD_EMPRESA = " + x;
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.executeUpdate();

            ps.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
