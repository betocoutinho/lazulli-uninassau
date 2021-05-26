import br.com.uninassau.lazulli.repositorios.ContratoRepositorio;

public class Teste {
    public static void main(String[] args) {
//        Obra obra = new Obra(1, null, null, null);
//        EmpresaLocadora empresaLocadora = new EmpresaLocadora(2, null, null);
//
//        ItemRepositorio itemRepositorio = new ItemRepositorio();
//
//        ItemContrato item1 = new ItemContrato(0, itemRepositorio.read(1), 20);
//        ItemContrato item2 = new ItemContrato(0, itemRepositorio.read(3), 15);
//        List<ItemContrato> itemContratoList = new ArrayList<>();
//
//        itemContratoList.add(item1);
//        itemContratoList.add(item2);
//
//        LocalDate data = LocalDate.now();
//
//        Contrato contrato = new Contrato(0, "jsaçsa",
//                data, data, 256.4, empresaLocadora, obra);
//
//        contrato.setItemList(itemContratoList);

        ContratoRepositorio cont = new ContratoRepositorio();
        cont.delete(8);



//        ItemContratoRepositorio teste1 = new ItemContratoRepositorio();
//        List<ItemContrato> as3 = teste1.readList(8);

//        ItemRepositorio teste = new ItemRepositorio();
//        Item item = teste.read(1);



    }
}

