package br.com.uninassau.lazulli.repositorio.item;

import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;
import br.com.uninassau.lazulli.entidades.Item;
import br.com.uninassau.lazulli.repositorio.ICrud;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemRepositorio implements ICrud<Item> {

    @Override
    public void create(Item object) {

        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO ITEM VALUES (?, ?)");

            ps.setInt(1, object.getCodigoDoItem());
            ps.setString(2, object.getNomeDoItem());
            ps.executeUpdate();

            ps.close();
            conexao.close();


        }catch (Exception e){
            e.printStackTrace();

        }



    }

    @Override
    public Item read(int x) {
        Item item = null;

        try {
            String sql = "SELECT * FROM ITEM WHERE COD_ITEM = " + x;
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);

            resultado.next();


            int codigoItem = resultado.getInt("COD_ITEM");
            String nome = resultado.getString("NOME_ITEM");

              item = new Item(codigoItem, nome);





            resultado.close();
            smt.close();
            ConexaoMySQL.FecharConexao();

            

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;

    }

    @Override
    public List<Item> read() {
        List<Item> itemList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ITEM";
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            Statement smt = conexao.createStatement();
            ResultSet resultado = smt.executeQuery(sql);



            while (resultado.next()){
                int codigo = resultado.getInt("COD_ITEM");
                String nome = resultado.getString("NOME_ITEM");

                Item item = new Item(codigo, nome);
                itemList.add(item);

            }

            resultado.close();
            smt.close();
            ConexaoMySQL.FecharConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public void update(int x, Item newObject) {
        try {
            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            String sql = "UPDATE ITEM SET NOME_ITEM = ? WHERE COD_ITEM = " + x;
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, newObject.getNomeDoItem());
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
            String sql = "DELETE FROM ITEM WHERE COD_ITEM = " + x;
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.executeUpdate();

            ps.close();
            conexao.close();
        }catch (SQLException e){

        }

    }
}
