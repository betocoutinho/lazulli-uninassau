package br.com.uninassau.lazulli.bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    public static String status = "Não conectou...";

    public ConexaoMySQL() {

    }

    // Método de Conexão//

    public static Connection getConexaoMySQL() {

        Connection connection = null; // atributo do tipo Connection

        try {
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            // Configurando a nossa conexão com um banco de dados/

            String url = "jdbc:mysql://localhost:3306/lazullidb";

            String username = "root"; // nome de um usuário de seu BD

            String password = "7175"; // sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);

            // Testa sua conexão//

            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }

            return connection;

        } catch (ClassNotFoundException e) { // Driver não encontrado

            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

            // Não conseguindo se conectar ao banco

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }

    }

    // Método que retorna o status da sua conexão//

    public static String statusConection() {

        return status;

    }

    // Método que fecha sua conexão//

    public static boolean FecharConexao() {

        try {

            ConexaoMySQL.getConexaoMySQL().close();

            System.out.println("Fechando a conexão com o Banco de Dados.");

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

    // Método que reinicia sua conexão//

    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();
        return ConexaoMySQL.getConexaoMySQL();

    }
}
