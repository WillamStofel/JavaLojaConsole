package VendasDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import VendasAttributes.PedidoAttributes;
import VendasBusiness.CadastraPedido;

/**
 * PedidosDAO
 */
public class PedidosDAO {

    public void TablePedidos(PedidoAttributes PA, ArrayList<String> Credenciais, ArrayList<String> Cliente,
            ArrayList<String> Produto) {
        String cargo = "";
        if (Credenciais.get(1) == "1")
            cargo = "Gerente";
        else
            cargo = "Vendedor";
        try {
            FileWriter fw = new FileWriter("..\\Vendas\\VendasDAO\\Pedidos.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(PA.getIdPedido() + "|" + PA.getQuantidade() + "|" + PA.getDate() + "|" + PA.getHorario() + "|"
                    + Credenciais.get(0) + "|" + cargo + "|" + Cliente.get(0) + "|" + Cliente.get(1) + "|"
                    + Cliente.get(2) + "|" + Cliente.get(3) + "|" + Cliente.get(4) + "|" + Produto.get(0) + "|"
                    + Produto.get(1) + "|" + Produto.get(2) + "|" + Produto.get(3) + "|" + Produto.get(4));
            fw.flush();
            pw.close();
            fw.close();
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }

    public Integer ReadPedidos() {
        Integer idpedido = 1;
        try {
            CadastraPedido cad = new CadastraPedido();
            cad.CriaArquivo();
            String path = "..\\Vendas\\VendasDAO\\Pedidos.txt";
            Scanner scan = new Scanner(new File(path));
            ArrayList<String> Pedidos = new ArrayList<String>();
            while (scan.hasNextLine()) {
                String palavra = scan.nextLine();
                String[] quebralinha = palavra.split("[|]");
                for (int i = 0; i < quebralinha.length; i += 16) {
                    Pedidos.add(quebralinha[i]);
                }
            }
            if (Pedidos.size() > 0)
                idpedido = Integer.parseInt(Pedidos.get(Pedidos.size() - 1)) + 1;

        } catch (Exception e) {
            System.out.println(e);
        }
        return idpedido;
    }

    public ArrayList<String> ListPedidos() {
        try {
            CadastraPedido cad = new CadastraPedido();
            cad.CriaArquivo();
            String path = "..\\Vendas\\VendasDAO\\Pedidos.txt";
            Scanner scan = new Scanner(new File(path));
            ArrayList<String> Pedidos = new ArrayList<String>();
            while (scan.hasNextLine()) {
                String palavra = scan.nextLine();
                String[] quebralinha = palavra.split("[|]");
                for (int i = 0; i < quebralinha.length; i++) {
                    Pedidos.add(quebralinha[i]);
                }
            }
            return Pedidos;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}