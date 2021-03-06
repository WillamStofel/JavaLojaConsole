package VendasDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VendasAttributes.ClienteAttributes;

/**
 * ClienteDAO
 */
public class ClienteDAO {

    public void TableClientes(ClienteAttributes CA) {
        try {
            FileWriter fw = new FileWriter("..\\Vendas\\VendasDAO\\Clientes.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(CA.getNome());
            pw.println(CA.getBairro());
            pw.println(CA.getRua());
            pw.println(CA.getCidade());
            pw.println(CA.getTelefone());
            fw.flush();
            pw.close();
            fw.close();
            Singleton.getInstancia().AdicionaMsgAuditoria("Cadastro de Cliente" + " | " + Instant.now().toString() + " | "
                    + CA.getNome().toString() + " | " + CA.getBairro().toString() + " | " + CA.getRua().toString()
                    + " | " + CA.getCidade().toString() + " | " + CA.getTelefone().toString());
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }

    public Boolean ReadClientes(String name) {
        try {
            String path = "..\\Vendas\\VendasDAO\\Clientes.txt";
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
            String path = "..\\Vendas\\VendasDAO\\Clientes.txt";
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

    public ArrayList<String> ReadClientes() {
        try {
            String path = "..\\Vendas\\VendasDAO\\Clientes.txt";
            Scanner scan = new Scanner(new File(path));
            ArrayList<String> Clientes = new ArrayList<String>();
            while (scan.hasNextLine()) {
                Clientes.add(scan.nextLine());
            }
            return Clientes;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}