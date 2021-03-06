package VendasDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VendasAttributes.GenericAttributes;
import VendasInterface.HomeVendas;
import VendasInterface.LoginVendas;

/**
 * CredentialsDAO
 */
public class CredentialsDAO {

    public void TableCredentials(GenericAttributes GA) {
        try {
            FileWriter fw = new FileWriter("..\\Vendas\\VendasDAO\\Credencias.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(GA.getName());
            pw.println(GA.getTipoFuncionario());
            pw.println(GA.getLogin());
            pw.println(GA.getSenha());
            fw.flush();
            pw.close();
            fw.close();
            Singleton.getInstancia().AdicionaMsgAuditoria("Cadastro de Credenciais" + " | " + Instant.now().toString() + " | "
                    + GA.getName().toString() + " | " + GA.getTipoFuncionario().toString() + " | " + GA.getLogin().toString()
                    + " | " + GA.getSenha().toString());
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }

    public void ReadCredentials(String name, String password) {
        try {
            String path = "..\\Vendas\\VendasDAO\\Credencias.txt";
            Scanner scan = new Scanner(new File(path));
            List<String> Credentials = new ArrayList<String>();
            ArrayList<String> dados = new ArrayList<String>();

            while (scan.hasNextLine()) {
                Credentials.add(scan.nextLine());
            }

            int position = 0;
            
            if (name.compareTo("admin")  == 0 && password.compareTo("admin") == 0)
                position = 2;
            else {
                for (int i = 0; i < Credentials.size(); i++) {
                    if (Credentials.get(i).compareTo(name) == 0) {
                        position = i;
                        break;
                    }
                }
            }

            if (position > 1) {
                for (int x = position - 2; x < position + 2; x++) {
                    String value = Credentials.get(x);
                    dados.add(value);
                }
                if (dados.get(3).compareTo(password) == 0) {
                    System.out.println("Usuário e senha corretos ! ");
                    Thread.sleep(3000);
                    HomeVendas homeVendas = new HomeVendas();
                    homeVendas.home(dados);
                    
                } else {
                    System.out.println("Usuário ou senha incorretos. ");
                    Thread.sleep(3000);
                    LoginVendas loginVendas = new LoginVendas();
                    loginVendas.Login();
                }
            } else {
                System.out.println("Usuário ou senha incorretos. ");
                Thread.sleep(3000);
                LoginVendas loginVendas = new LoginVendas();
                loginVendas.Login();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}