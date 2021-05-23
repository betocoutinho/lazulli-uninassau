import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;
import br.com.uninassau.lazulli.entidades.Item;
import br.com.uninassau.lazulli.repositorio.item.ItemRepositorio;

public class Teste {
    public static void main(String[] args) {
        ItemRepositorio teste = new ItemRepositorio();

        teste.delete(4);
    }
}

