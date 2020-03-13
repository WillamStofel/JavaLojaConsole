package VendasInterface;

import java.util.ArrayList;
import java.util.Scanner;

import VendasDAO.ClienteDAO;

/**
 * PedidoVendas
 */
public class PedidoVendas {

    public void Cliente() {
        String resp;
        do {
            System.out.print("Escolha uma opção: ");
            System.out.print("1-) Escolher um cliente já cadastrado. ");
            System.out.print("2-) Cadastrar um cliente. ");
            Scanner scan = new Scanner(System.in);
            resp = scan.nextLine();
        } while (resp != "1" || resp != "2");

        switch (resp) {
            case "1":
                ClienteDAO Cliente = new ClienteDAO();
                ArrayList<String> cli = Cliente.ReadClientes();
                MenuCliente(cli);
                break;
            case "2":

                break;

        }
    }

    public void MenuCliente(ArrayList<String> Clientes) {
        Integer posicao = 0;
        String Nome;
        try {
            System.out.println("Digite o nome da mesma forma que segue listado abaixo para escolher um cliente !!!");
            Thread.sleep(2000);
            for (int i = 0; i < Clientes.size(); i += 5) {
                System.out.println(Clientes.get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        do {
            Scanner scan = new Scanner(System.in);
            Nome = scan.nextLine();
            if (Clientes.contains(Nome)) {
                
            } else
                Nome = "";
        } while (Nome != "");

    }
}