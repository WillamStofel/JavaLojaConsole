package VendasInterface;

import java.util.ArrayList;
import java.util.Scanner;


import VendasBusiness.CadastraCliente;
import VendasBusiness.CadastraProdutos;
import VendasDAO.ClienteDAO;
import VendasDAO.ProdutosDAO;

/**
 * PedidoVendas
 */
public class PedidoVendas {

    public ArrayList<String> Cliente() {
        String resp;
        ArrayList<String> cli = new ArrayList<>();
        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("1-) Escolher um cliente já cadastrado. ");
            System.out.println("2-) Cadastrar um cliente. ");
            Scanner scan = new Scanner(System.in);
            resp = scan.nextLine();
        } while (resp.compareTo("1") == 0 && resp.compareTo("2") == 0);

        switch (resp) {
            case "1":
                ClienteDAO Cliente = new ClienteDAO();
                cli = Cliente.ReadClientes();
                cli = MenuCliente(cli);
                break;
            case "2":
                CadastraCliente cliente = new CadastraCliente();
                cli = cliente.CadastroCliente();
                break;
        }
        return cli;
    }

    public ArrayList<String> MenuCliente(ArrayList<String> Clientes) {
        String Nome;
        ArrayList<String> c = new ArrayList<String>();
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
            System.out.println("Digite o nome do cliente: ");
            Scanner scan = new Scanner(System.in);
            Nome = scan.nextLine();
            for (int i = 0; i < Clientes.size(); i++) {
                if (Clientes.get(i).contains(Nome)) {
                    c.add(Clientes.get(i));
                    c.add(Clientes.get(i+1));
                    c.add(Clientes.get(i+2));
                    c.add(Clientes.get(i+3));
                    c.add(Clientes.get(i+4));
                }
            }
            if (c.size() == 0) {
                System.out.println("Nome não encontrado, digite novamente! ");
            }
        } while (c.size() == 0);
        return c;

    }

    public ArrayList<String> Produto() {
        String resp;
        ArrayList<String> produto = new ArrayList<String>();
        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("1-) Escolher um produto já cadastrado. ");
            System.out.println("2-) Cadastrar um produto. ");
            Scanner scan = new Scanner(System.in);
            resp = scan.nextLine();
        } while (resp.compareTo("1") == 0 && resp.compareTo("2") == 0);

        switch (resp) {
            case "1":
                ProdutosDAO p = new ProdutosDAO();
                produto = p.ReadProdutos();
                produto = MenuProduto(produto);
                break;
            case "2":
                CadastraProdutos product = new CadastraProdutos();
                produto = product.CadastroProduto();
                break;
        }
        return produto;
    }

    public ArrayList<String> MenuProduto(ArrayList<String> produto) {
        String Nome;
        ArrayList<String> p = new ArrayList<String>();
        try {
            System.out.println("Digite o nome da mesma forma que segue listado abaixo para escolher um cliente !!!");
            Thread.sleep(2000);
            for (int i = 0; i < produto.size(); i += 5) {
                System.out.println(produto.get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        do {
            System.out.println("Digite o nome do produto: ");
            Scanner scan = new Scanner(System.in);
            Nome = scan.nextLine();
            for (int i = 0; i < produto.size(); i++) {
                if (produto.get(i).contains(Nome)) {
                    p.add(produto.get(i));
                    p.add(produto.get(i+1));
                    p.add(produto.get(i+2));
                    p.add(produto.get(i+3));
                    p.add(produto.get(i+4));

                }
            }
            if (p.size() == 0) {
                System.out.println("produto não encontrado, digite novamente! ");
            }
        } while (p.size() == 0);
        return p;

    }
}