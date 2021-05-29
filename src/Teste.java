import br.com.uninassau.lazulli.capturaDados.ContratoCaptura;
import br.com.uninassau.lazulli.capturaDados.ItemCaptura;
import br.com.uninassau.lazulli.entidades.Item;
import br.com.uninassau.lazulli.repositorios.ContratoRepositorio;
import br.com.uninassau.lazulli.repositorios.ItemRepositorio;

import java.time.LocalDate;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
       Item item = new Item("Plataforma");

        ItemRepositorio repo = new ItemRepositorio();


//



//        repo.delete(2);
//        List<Item> listaitem = repo.readList();
//        listaitem.stream().forEach(v -> System.out.println("Codigo: " + v.getCodigoDoItem() + " Item: " + v.getNomeDoItem()));

        Item atualização = new Item("Plataforma");

        repo.update(1, atualização);





    }
}

