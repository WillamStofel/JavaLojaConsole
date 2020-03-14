package VendasBusiness;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import VendasAttributes.PedidoAttributes;
import VendasDAO.PedidosDAO;
import VendasInterface.PedidoVendas;
import VendasInterface.Vendas;

/**
 * CadastraPedido
 */
public class CadastraPedido {
    public void CriaArquivo() {
        Path path = Paths.get("..\\Vendas\\VendasDAO\\Pedidos.txt");
        if (Files.notExists(path)) {
            File file = new File("..\\Vendas\\VendasDAO\\Pedidos.txt");
            try {
                FileWriter fw = new FileWriter(file);
                PrintWriter pw = new PrintWriter(fw);
                fw.flush();
                pw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void CadastroPedido(ArrayList<String> credencias) {
        CriaArquivo();
        Vendas.Clear();
        Scanner scan = new Scanner(System.in);
        PedidoAttributes pedidos = new PedidoAttributes();
        String h;
        Integer IdPedido = 0, Quantidade = 0;
        PedidoVendas Ivendas = new PedidoVendas();
        ArrayList<String> cliente = Ivendas.Cliente();
        ArrayList<String> produto = Ivendas.Produto();

        try {
            PedidosDAO p = new PedidosDAO();
            IdPedido = p.ReadPedidos();
            pedidos.setIdPedido(IdPedido);
        } catch (Exception e) {
            System.out.println(e);
        }
        do {
            try {
                System.out.println("Digite a Quantidade do pedido: ");
                Quantidade = scan.nextInt();
                pedidos.setQuantidade(Quantidade);
            } catch (Exception e) {
                System.out.println("Digite apenas números !");
            }
        } while (pedidos.setQuantidade(Quantidade) == false);
        try {

            Calendar c1 = Calendar.getInstance();
            int year = c1.get(Calendar.YEAR);
            int month = c1.get(Calendar.MONTH)+1;
            int day = c1.get(Calendar.DAY_OF_MONTH);
            String date = Integer.toString(day) + "/" +Integer.toString(month) +"/" + Integer.toString(year);
            int hour = c1.get(Calendar.HOUR_OF_DAY);
            int minutes = c1.get(Calendar.MINUTE);
            if(minutes < 10)
             h = Integer.toString(hour) + ":" + "0" +Integer.toString(minutes);
            else
             h = Integer.toString(hour) + ":" +Integer.toString(minutes);
            pedidos.setHorario(h);
            pedidos.setDate(date);

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            PedidosDAO DB = new PedidosDAO();
            DB.TablePedidos(pedidos, credencias, cliente, produto);
            System.out.println("Pedido cadastrado com sucesso !!!");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}