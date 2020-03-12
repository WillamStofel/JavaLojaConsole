package VendasDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VendasAttributes.ClienteAttributes;
import VendasAttributes.GenericAttributes;

/**
 * ClienteDAO
 */
public class ClienteDAO {

    public void TableClientes(ClienteAttributes CA) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\willi\\git\\Vendas\\VendasDAO\\Clientes.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(CA.getNome());
            pw.println(CA.getBairro());
            pw.println(CA.getRua());
            pw.println(CA.getCidade());
            pw.println(CA.getTelefone());
            fw.flush();
            pw.close();
            fw.close();
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }


    public Boolean ReadClientes(String name) {
        try {
            String path = "C:\\Users\\willi\\git\\Vendas\\VendasDAO\\Clientes.txt";
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

    public Boolean ReadClientes(Integer telefone) {
        try {
            String path = "C:\\Users\\willi\\git\\Vendas\\VendasDAO\\Clientes.txt";
            Scanner scan = new Scanner(new File(path));
            List<String> Clientes = new ArrayList<String>();
            while (scan.hasNextLine()) {
                Clientes.add(scan.nextLine());
            }
            if (Clientes.contains(Integer.toString(telefone))) {
                System.out.println("telefone já existe no nosso banco de dados, digite novamente. ");
                return false;
            } else
                return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}