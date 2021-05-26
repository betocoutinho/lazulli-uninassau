package br.com.uninassau.lazulli.repositorio.contrato;

import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;
import br.com.uninassau.lazulli.entidades.*;
import br.com.uninassau.lazulli.entidades.interfaces.ICrud;
import br.com.uninassau.lazulli.repositorio.empresalocadora.EmpresaLocadoraRepositorio;
import br.com.uninassau.lazulli.repositorio.itemcontrato.ItemContratoRepositorio;
import br.com.uninassau.lazulli.repositorio.obra.ObraRepositorio;

import java.time.LocalDate;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContratoRepositorio implements ICrud<Contrato> {
    @Override
    public void create(Contrato object) {
        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO contrato(num_contrato, data_inicial, data_final, " +
                    "valor_do_contrato, fk_empresa_locadora_cod_empresa, fk_obra_cod_obra) VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, object.getNumeroDoContrato());
            ps.setDate(2, Date.valueOf(object.getDataInicial()));
            ps.setDate(3, Date.valueOf(object.getDataFinal()));
            ps.setDouble(4, object.getPrecoDoContrato());
            ps.setInt(5, object.getEmpresaLocadora().getCodigoEmpresaLocadora());
            ps.setInt(6, object.getObra().getCodigoDaObra());


            ps.executeUpdate();

            ResultSet chavegerada = ps.getGeneratedKeys();
            chavegerada.first();
            object.getItemList().stream().forEach(v -> {
                try {
                    v.setCodigoDoContrato(chavegerada.getInt(1));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ItemContratoRepositorio repositorio = new ItemContratoRepositorio();
                repositorio.create(v);
            });

            chavegerada.close();

            ps.close();
            conexao.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public Contrato read(int x) {

        Contrato contrato = null;

        try {
            String sql = "SELECT * FROM contrato WHERE COD_CONTRATO = " + x;
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            resultado.next();

            int codigo = resultado.getInt(1);
            String numeroContrato = resultado.getString(2);
            LocalDate dataInicial = resultado.getDate(3).toLocalDate();
            LocalDate dataFinal = resultado.getDate(4).toLocalDate();
            double valor = resultado.getDouble(5);
            EmpresaLocadora empresaLocadora = new EmpresaLocadoraRepositorio().read(resultado.getInt(6));
            Obra obra = new ObraRepositorio().read(resultado.getInt(7));


            contrato = new Contrato(codigo, numeroContrato, dataInicial, dataFinal, valor, empresaLocadora, obra);
            contrato.setItemList(new ItemContratoRepositorio().readList(contrato.getCodigoDoContrato()));


            resultado.close();
            smt.close();
            ConexaoMySQL.FecharConexao();



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contrato;
    }

    @Override
    public List<Contrato> readList() {

        List<Contrato> contratos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM contrato";
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            while (resultado.next()){
                int codigo = resultado.getInt(1);
                String numeroContrato = resultado.getString(2);
                LocalDate dataInicial = resultado.getDate(3).toLocalDate();
                LocalDate dataFinal = resultado.getDate(4).toLocalDate();
                double valor = resultado.getDouble(5);
                EmpresaLocadora empresaLocadora = new EmpresaLocadoraRepositorio().read(resultado.getInt(6));
                Obra obra = new ObraRepositorio().read(resultado.getInt(7));


                Contrato contrato = new Contrato(codigo, numeroContrato, dataInicial, dataFinal, valor, empresaLocadora, obra);
                contrato.setItemList(new ItemContratoRepositorio().readList(contrato.getCodigoDoContrato()));

                contratos.add(contrato);
            }

            resultado.close();
            smt.close();
            ConexaoMySQL.FecharConexao();



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contratos;
    }

    @Override
    public void update(int x, Contrato object) {
        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            String sql = "UPDATE contrato SET NUM_CONTRATO = ?, DATA_INICIAL = ?, " +
                    "DATA_FINAL = ?, VALOR_DO_CONTRATO = ? " + "WHERE COD_CONTRATO = " + x;
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, object.getNumeroDoContrato());
            ps.setDate(2, Date.valueOf(object.getDataInicial()));
            ps.setDate(3, Date.valueOf(object.getDataFinal()));
            ps.setDouble(4, object.getPrecoDoContrato());


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
            String sql = "DELETE FROM contrato WHERE COD_CONTRATO = " + x;
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.executeUpdate();

            ps.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
