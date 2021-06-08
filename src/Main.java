import br.com.uninassau.lazulli.bancodedados.ConexaoMySQL;
import br.com.uninassau.lazulli.contexto.ItemContexto;
import br.com.uninassau.lazulli.menuInicial.MenuInicial;
import br.com.uninassau.lazulli.relatorio.RelatorioDeFiscaisEmObras;
import br.com.uninassau.lazulli.relatorio.RelatorioDoTotalDeItens;

public class Main {
    public static void main(String[] args) {
        //MenuInicial.inicio();

        RelatorioDeFiscaisEmObras rf = new RelatorioDeFiscaisEmObras();

        rf.print();



    }
}

