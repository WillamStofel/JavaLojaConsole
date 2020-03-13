package VendasBusiness;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import VendasAttributes.ClienteAttributes;
import VendasDAO.ClienteDAO;

/**
 * CadastraCliente
 */
public class CadastraCliente {

    public void CriaArquivo() {
        Path path = Paths.get("..\\VendasDAO\\Clientes.txt");
        if (Files.notExists(path)) {
            File file = new File("..\\VendasDAO\\Clientes.txt");
            try {
                FileWriter fw = new FileWriter(file);
                PrintWriter pw = new PrintWriter(fw);
                fw.flush();
                pw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void CadastroCliente() {
        CriaArquivo();
        Scanner scan = new Scanner(System.in);
        ClienteAttributes cliente = new ClienteAttributes();
        String nome, bairro, rua, cidade;
        Integer telefone = 0;
        do {
            System.out.println("Digite o nome do Cliente: ");
            nome = scan.nextLine();
            nome = ValidaCampos(nome);
        } while (cliente.setNome(nome) == false);
        do {
            System.out.println("Digite o bairro do Cliente: ");
            bairro = scan.nextLine();
        } while (cliente.setBairro(bairro) == false);
        do {
            System.out.println("Digite a rua do Cliente: ");
            rua = scan.nextLine();
        } while (cliente.setRua(rua) == false);
        do {
            System.out.println("Digite a cidade do Cliente: ");
            cidade = scan.nextLine();
        } while (cliente.setCidade(cidade) == false);
        do {
            try {
                System.out.println("Digite o número de telefone celular/residencial do Cliente: ");
                telefone = scan.nextInt();
                telefone = ValidaCampos(telefone);
            } catch (Exception e) {
                System.out.println("Digite apenas números sem '-', '/' ou qualquer outro caracter que não seja número."
                        + "Exception: " + e);
            }
        } while (cliente.setTelefone(telefone) == false);
        try {
            ClienteDAO DB = new ClienteDAO();
            DB.TableClientes(cliente);
            System.out.println("Cliente cadastrado com sucesso !!!");            
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Esse método é para buscar se no banco existe o mesmo nome.
    public String ValidaCampos(String nome) {
        ClienteDAO ClientesDB = new ClienteDAO();
        Boolean resp = ClientesDB.ReadClientes(nome);
        if (resp == true)
            return nome;
        else
            return "";

    }

    public Integer ValidaCampos(Integer telefone) {
        ClienteDAO ClientesDB = new ClienteDAO();
        Boolean resp = ClientesDB.ReadClientes(telefone);
        if (resp == true)
            return telefone;
        else {
            return telefone = 0;
        }

    }
}