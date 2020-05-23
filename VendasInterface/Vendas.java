package VendasInterface;

import java.util.ArrayList;
import java.util.Scanner;

import VendasBusiness.CadastraCredenciais;
import VendasDAO.PedidosDAO;
import VendasDAO.Singleton;

/**
 * Vendas
 */
public class Vendas {

    public static void Clear() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) throws InterruptedException{

        Singleton.getInstancia().ativar();
        CadastraCredenciais Cadastrar = new CadastraCredenciais();
        Cadastrar.CriaArquivo();
        String answer;
        do {
            Clear();
            System.out.println("Seja bem vindo ao sistema de vendas !");
            System.out.println("Escolha uma das opções a seguir: \n\n");
            System.out.println("1-) Entrar como minhas credencias no sistema.");
            System.out.println("2-) fechar o sistema.");
            System.out.println("3-) Mostrar todos os pedidos do sistema.");
            Scanner sc = new Scanner(System.in);
            answer = sc.next();
        } while (answer.compareTo("1") != 0 && answer.compareTo("2") != 0 && answer.compareTo("3") != 0);

        switch (answer) {
            case "1":
                LoginVendas login = new LoginVendas();
                login.Login();
                break;
            case "2":
                Clear();
                System.exit(0);
                break;
            case "3":
                PedidosDAO pedidos = new PedidosDAO();
                ArrayList<String> ped = pedidos.ListPedidos();
                Listapedidos(ped);
                break;

        }
        Singleton.getInstancia().desativar();
    }

    private static void Listapedidos(ArrayList<String> ped) {
        if (ped != null && ped.size() > 0) {
            for (int i = 0; i < ped.size(); i += 16) {
                if (i + 15 < ped.size())
                    System.out.println("\n Número do pedido: " + ped.get(i) + "\n Quantidade: " + ped.get(i + 1)
                            + "\n Data: " + ped.get(i + 2) + "\n horário: " + ped.get(i + 3) + "\n Atendente: "
                            + ped.get(i + 4) + "\n Cargo do Atendente: " + ped.get(i + 5) + "\n Nome do cliente: "
                            + ped.get(i + 6) + "\n Bairro: " + ped.get(i + 7) + "\n Rua: " + ped.get(i + 8)
                            + "\n Cidade: " + ped.get(i + 9) + "\n Telefone: " + ped.get(i + 10)
                            + "\n Descrição Produto: " + ped.get(i + 11) + "\n Fornecedor: " + ped.get(i + 12)
                            + "\n Unidade: " + ped.get(i + 13) + "\n Valor do produto: " + ped.get(i + 14)
                            + "\n Categoria: " + ped.get(i + 15));
            }

        } else {
            try {
                System.out.println("Não existem pedidos realizados !");
                System.out.println("\n\n\n ");
                Thread.sleep(3000);
            } catch (Exception e) {

            }

        }
    }

}