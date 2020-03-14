package VendasBusiness;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import VendasAttributes.ProdutosAttributes;
import VendasDAO.ProdutosDAO;
import VendasInterface.Vendas;

/**
 * CadastraProdutos
 */
public class CadastraProdutos {

    public void CriaArquivo() {
        Path path = Paths.get("..\\Vendas\\VendasDAO\\Produtos.txt");
        if (Files.notExists(path)) {
            File file = new File("..\\Vendas\\VendasDAO\\Produtos.txt");
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

    public ArrayList<String> CadastroProduto() {
        CriaArquivo();
        Vendas.Clear();
        Scanner scan = new Scanner(System.in);
        ProdutosAttributes products = new ProdutosAttributes();
        String Descricao, fornecedor, unidade, valor, categoria;
        ArrayList<String> p = new ArrayList<String>();

        do {
            System.out.println("Digite a descrição do produto: ");
            Descricao = scan.nextLine();
            Descricao = ValidaCampos(Descricao);
        } while (products.setDescricao(Descricao) == false);
        do {
            System.out.println("Digite qual o fornecedor: ");
            fornecedor = scan.nextLine();
        } while (products.setFornecedor(fornecedor) == false);
        do {
            System.out.println("Digite o número que corresponde a unidade do produto: "); 
            System.out.println("1 -) KG"); 
            System.out.println("2 -) UN");
            System.out.println("3 -) PCT"); 
            unidade = scan.nextLine();
        } while (products.setUnidade(unidade) == false);
        do {
            System.out.println("Digite o valor do produto: ");
            valor = scan.nextLine();
        } while (products.setValor(valor) == false);
        do {
            System.out.println("Digite a categoria do produto: ");
            categoria = scan.nextLine();
        } while (products.setCategoria(categoria) == false);
      
        try {
            ProdutosDAO DB = new ProdutosDAO();
            DB.TableProdutos(products);
            System.out.println("Produto cadastrado com sucesso !!!");
            Thread.sleep(3000);
            p.add(Descricao);
            p.add(fornecedor);
            p.add(unidade);
            p.add(valor);
            p.add(categoria);
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }

    public String ValidaCampos(String descricao) {
        ProdutosDAO ProdutosDB = new ProdutosDAO();
        Boolean resp = ProdutosDB.ReadProdutos(descricao);
        if (resp == true)
            return descricao;
        else
            return "";

    }
}