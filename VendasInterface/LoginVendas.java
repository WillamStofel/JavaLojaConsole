package VendasInterface;

import java.util.Scanner;

import VendasDAO.CredentialsDAO;

/**
 * LoginVendas
 */
public class LoginVendas {

    public void Login() {
        Scanner sc = new Scanner(System.in);
        Vendas.Clear();
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        CredentialsDAO dao = new CredentialsDAO();
        dao.ReadCredentials(login, senha);
        sc.close();
    }
}