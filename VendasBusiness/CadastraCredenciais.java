package VendasBusiness;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VendasAttributes.GenericAttributes;
import VendasDAO.CredentialsDAO;

/**
 * CadastraCredenciais
 */
public class CadastraCredenciais {

    public void CriaArquivo() {
        Path path = Paths.get("C:\\Users\\willi\\git\\Vendas\\VendasDAO\\Credencias.txt");
        if (Files.notExists(path)) {
            File file = new File("C:\\Users\\willi\\git\\Vendas\\VendasDAO\\Credencias.txt");
            try {
                FileWriter fw = new FileWriter(file);
                PrintWriter pw = new PrintWriter(fw);
                pw.println("Administrador");
                pw.println("1");
                pw.println("admin");
                pw.println("admin");
                fw.flush();
                pw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
     // Método add todo a tabela de credencias em uma lista e compara se o login existe
    // caso já exista retorna para digitar novamente um novo login.
    private String ValidaLogin(String name) {
        int UsuarioExiste = 0;
        String path = "C:\\Users\\willi\\git\\Vendas\\VendasDAO\\Credencias.txt";
        try {
            Scanner scan = new Scanner(new File(path));
            List<String> lista = new ArrayList<String>();
            while (scan.hasNextLine()) {
                lista.add(scan.nextLine());
            }
            for (int i = 2; i < lista.size(); i += 4) {
                if (lista.get(i).contains(name))
                    UsuarioExiste++;
            }
            if (UsuarioExiste > 0) {
                System.out.println("Já existe este Usuário ! Escolha um diferente. ");
                return name = "";
            } else {
                System.out.println("Usuário Válido !");
                return name;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return name;
    }

    public void EscreveArquivo() {
        Scanner sc = new Scanner(System.in);
        String login = "", senha = "", nome = "", TipoFunc = "";

        GenericAttributes vend = new GenericAttributes();
        do {

            try {
                System.out.println("\n Digite um usuário: ");
                login = sc.nextLine();
                login = ValidaLogin(login);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (vend.setLogin(login) == false);

        do {
            sc = new Scanner(System.in);
            System.out.println("\n Digite uma senha: ");
            senha = sc.nextLine();

        } while (vend.setSenha(senha) == false);
        do {
            sc = new Scanner(System.in);
            System.out.println("\n Digite um nome: ");
            nome = sc.nextLine();

        } while (vend.setName(nome) == false);
        do {
            sc = new Scanner(System.in);
            System.out.println("\n Digite apenas 1 ou 2: \n\n");
            System.out.println("1-) Gerente");
            System.out.println("2-) Vendedor");
            TipoFunc = sc.nextLine();

        } while (vend.setTipoFuncionario(TipoFunc) == false);
        sc.close();
        CredentialsDAO dBCredentialsDAO = new CredentialsDAO();
        dBCredentialsDAO.TableCredentials(vend);

    }
}