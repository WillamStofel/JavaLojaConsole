package VendasInterface;

import java.util.Scanner;

import VendasBusiness.CadastraCredenciais;

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

    public static void main(String[] args) {

        CadastraCredenciais Cadastrar = new CadastraCredenciais();
        Cadastrar.CriaArquivo();
        String answer;
        do {
            Clear();
            System.out.println("Seja bem vindo ao sistema de vendas !");
            System.out.println("Escolha uma das opções a seguir: \n\n");
            System.out.println("1-) Entrar como minhas credencias no sistema.");
            System.out.println("2-) fechar o sistema.");
            Scanner sc = new Scanner(System.in);
            answer = sc.next();
        } while (answer.compareTo("1") != 0 && answer.compareTo("2") != 0);

        if (answer.compareTo("1") == 0) {
            LoginVendas login = new LoginVendas();
            login.Login();
        } else {
            Clear();
            System.exit(0);
        }
    }

    
}