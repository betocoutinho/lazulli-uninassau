package br.com.uninassau.lazulli.repositorio.itemcontrato;

import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;
import br.com.uninassau.lazulli.entidades.Item;
import br.com.uninassau.lazulli.entidades.ItemContrato;
import br.com.uninassau.lazulli.entidades.interfaces.ICrud;
import br.com.uninassau.lazulli.repositorio.item.ItemRepositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemContratoRepositorio implements ICrud<ItemContrato> {

    @Override
    public void create(ItemContrato object) {
        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO item_contrato" +
                    "(FK_ITEM_COD_ITEM, FK_CONTRATO_COD_CONTRATO, QUANTIDADE) VALUES (?,?,?)");

            ps.setInt(1, object.getItem().getCodigoDoItem());
            ps.setInt(2, object.getCodigoDoContrato());
            ps.setInt(3, object.getQuantidade());
            ps.executeUpdate();

            ps.close();
            conexao.close();


        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    @Deprecated //Metodo Problematico
    public ItemContrato read(int x) {
        return null;
    }



    @Override
    public List<ItemContrato> readList() {
        List<ItemContrato> itemContratoList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM item_contrato";
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            while (resultado.next()){
                int codigoItem = resultado.getInt(1);
                int codigoContrato = resultado.getInt(2);
                int quantidade = resultado.getInt(3);

                itemContratoList.add(new ItemContrato(codigoContrato, new ItemRepositorio().read(codigoItem), quantidade)) ;
            }

            resultado.next();

            resultado.close();
            smt.close();
            ConexaoMySQL.FecharConexao();



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemContratoList;
    }

    public List<ItemContrato> readList(int x){
        List<ItemContrato> itemContratoList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM item_contrato WHERE FK_CONTRATO_COD_CONTRATO = " + x;
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            while(resultado.next()){
                int codigoItem = resultado.getInt(1);
                int codigoContrato = resultado.getInt(2);
                int quantidade = resultado.getInt(3);

                itemContratoList.add(new ItemContrato(codigoContrato, new ItemRepositorio().read(codigoItem), quantidade));
            }


            resultado.close();
            smt.close();
            ConexaoMySQL.FecharConexao();



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemContratoList;
    }

    @Override
    public void update(int x, ItemContrato object) {
        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            String sql = "UPDATE item_contrato SET QUANTIDADE = ? WHERE FK_CONTRATO_COD_CONTRATO = " + x
                    + " AND FK_ITEM_COD_ITEM = " + object.getItem().getCodigoDoItem();
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(3, object.getQuantidade());

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
            String sql = "DELETE FROM item_contrato WHERE FK_ITEM_COD_ITEM = " + x;
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.executeUpdate();

            ps.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
