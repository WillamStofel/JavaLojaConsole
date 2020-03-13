package VendasBusiness;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import VendasAttributes.PedidoAttributes;
import VendasDAO.ClienteDAO;
import VendasDAO.PedidosDAO;
import VendasInterface.PedidoVendas;
import VendasInterface.Vendas;

/**
 * CadastraPedido
 */
public class CadastraPedido {
    public void CriaArquivo() {
        Path path = Paths.get("..\\VendasDAO\\Pedidos.txt");
        if (Files.notExists(path)) {
            File file = new File("..\\VendasDAO\\Pedidos.txt");
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
        Calendar horario;
        DateFormat data;
        Integer IdPedido = 0, Quantidade = 0;
        PedidoVendas Ivendas = new PedidoVendas();
        Ivendas.Cliente();

        do {
            try {
                System.out.println("Digite a Quantidade do pedido: ");
                Quantidade = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Digite apenas números !");
            }
        } while (pedidos.setQuantidade(Quantidade) == false);
        try {
            horario.getTime();
            data = DateFormat.getDateInstance(DateFormat.SHORT);
            pedidos.setHorario(horario);
            pedidos.setDate(data);

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            PedidosDAO DB = new PedidosDAO();
            DB.TablePedidos(pedidos, credencias);
            System.out.println("Pedido cadastrado com sucesso !!!");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void BuscaInformacoes() {
        ClienteDAO Clientes = new ClienteDAO();
        ArrayList<String> C = Clientes.ReadClientes();
    }

}