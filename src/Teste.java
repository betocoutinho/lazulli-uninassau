import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;
import br.com.uninassau.lazulli.entidades.Fiscal;
import br.com.uninassau.lazulli.entidades.Item;
import br.com.uninassau.lazulli.repositorio.fiscal.FiscalRepositorio;
import br.com.uninassau.lazulli.repositorio.item.ItemRepositorio;

public class Teste {
    public static void main(String[] args) {
        FiscalRepositorio fp = new FiscalRepositorio();

        Fiscal fiscal = new Fiscal(0, "Severiono", "545434");

        Fiscal fiscal1 = fp.read(1);

        System.out.println(fiscal1.getNomeDoFiscal() + fiscal1.getCodigoDoFiscal());

    }
}
