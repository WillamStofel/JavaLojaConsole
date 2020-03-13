package VendasDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VendasAttributes.PedidoAttributes;

/**
 * PedidosDAO
 */
public class PedidosDAO {

    public void TablePedidos(PedidoAttributes PA,ArrayList<String> Credenciais, ArrayList<String> Cliente,ArrayList<String> Produto) {
        try {
            FileWriter fw = new FileWriter("..\\VendasDAO\\Clientes.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(PA.getIdPedido() + "|" + PA.getQuantidade());
           
            fw.flush();
            pw.close();
            fw.close();
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }


    public Boolean ReadClientes(String name) {
        try {
            String path = "..\\VendasDAO\\Clientes.txt";
            Scanner scan = new Scanner(new File(path));
            List<String> Clientes = new ArrayList<String>();
            while (scan.hasNextLine()) {
                Clientes.add(scan.nextLine());
            }
            if (Clientes.contains(name)) {
                System.out.println("Nome já existe no nosso banco de dados, digite novamente. ");
                return false;
            } else
                return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}