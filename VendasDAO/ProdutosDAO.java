package VendasDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VendasAttributes.ProdutosAttributes;

/**
 * ProdutosDAO
 */
public class ProdutosDAO {

    public void TableProdutos(ProdutosAttributes PA) {
        try {
            FileWriter fw = new FileWriter("..\\Vendas\\VendasDAO\\Produtos.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(PA.getDescricao());
            pw.println(PA.getFornecedor());
            pw.println(PA.getUnidade());
            pw.println(PA.getValor());
            pw.println(PA.getCategoria());
            fw.flush();
            pw.close();
            fw.close();
            Singleton.getInstancia().AdicionaMsgAuditoria("Cadastro de Produtos" + " | " + Instant.now().toString() + " | "
                    + PA.getDescricao().toString() + " | " + PA.getFornecedor().toString() + " | " + PA.getUnidade().toString()
                    + " | " + PA.getValor().toString() + " | " + PA.getCategoria().toString());
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }


    public Boolean ReadProdutos(String name) {
        try {
            String path = "..\\Vendas\\VendasDAO\\Produtos.txt";
            Scanner scan = new Scanner(new File(path));
            List<String> Produtos = new ArrayList<String>();
            while (scan.hasNextLine()) {
                Produtos.add(scan.nextLine());
            }
            if (Produtos.contains(name)) {
                System.out.println("Produto já existe no nosso banco de dados, digite novamente. ");
                return false;
            } else
                return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<String> ReadProdutos() {
        try {
            String path = "..\\Vendas\\VendasDAO\\Produtos.txt";
            Scanner scan = new Scanner(new File(path));
            ArrayList<String> Produtos = new ArrayList<String>();
            while (scan.hasNextLine()) {
                Produtos.add(scan.nextLine());
            }
           return Produtos;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

   
}