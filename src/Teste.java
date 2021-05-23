import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;

public class Teste {
    public static void main(String[] args) {
        ConexaoMySQL.getConexaoMySQL();
        System.out.println(ConexaoMySQL.statusConection());
    }
}

