package VendasInterface;

import java.util.List;
import java.util.Scanner;

import VendasBusiness.CadastraCliente;
import VendasBusiness.CadastraCredenciais;

/**
 * HomeVendas
 */
public class HomeVendas {

    public void home(List<String> data) {
        Vendas.Clear();
        Scanner scan = new Scanner(System.in);
        String resp = "";
        if (data.get(1).contains("1")) {
            do {
                Vendas.Clear();
                System.out.println("Seja bem-vindo Sr(a). " + data.get(0));
                System.out.println("Função: Gerente. \n\n");
                System.out.println("Escolha a opção que deseja: \n\n");
                System.out.println("0-) Sair do Sistema.");
                System.out.println("1-) Cadastrar Produtos.");
                System.out.println("2-) Cadastrar Pedidos.");
                System.out.println("3-) Cadastrar Cliente.");
                System.out.println("4-) Cadastrar funcionário(a).");
                resp = scan.nextLine();
            } while (resp.compareTo("1") != 0 && resp.compareTo("2") != 0 && resp.compareTo("3") != 0
                    && resp.compareTo("4") != 0);
        } else {
            do {
                Vendas.Clear();
                System.out.println("Seja bem-vindo Sr(a). " + data.get(0));
                System.out.println("Função: Vendedor(a). \n\n");
                System.out.println("Escolha a opção que deseja: \n\n");
                System.out.println("0-) Sair do Sistema.");
                System.out.println("1-) Cadastrar Produtos.");
                System.out.println("2-) Cadastrar Pedidos.");
                System.out.println("3-) Cadastrar Cliente.");
                resp = scan.nextLine();
            } while (resp.compareTo("1") == 0 && resp.compareTo("2") == 0 && resp.compareTo("3") != 0);
        }
        Menu(resp);
        home(data);

    }

    public void Menu(String resp) {
        switch (resp) {
            case "0":
                System.exit(0);
            case "1":
                Vendas.Clear();
                System.out.println("Construção");
                break;
            case "2":
                Vendas.Clear();
                System.out.println("Construção");
                break;
            case "3":
                Vendas.Clear();
                CadastraCliente cliente = new CadastraCliente();
                cliente.CadastroCliente();
                break;
            case "4":
                Vendas.Clear();
                CadastraCredenciais cadastro = new CadastraCredenciais();
                cadastro.EscreveArquivo();
                break;
        }
    }

}