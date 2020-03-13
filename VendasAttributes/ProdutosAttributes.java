package VendasAttributes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ProdutosAttributes
 */
public class ProdutosAttributes {

    private String Descricao;
    private String Fornecedor;
    private String Unidade;
    private String valor;
    private String Categoria;

    public String getDescricao() {
        return Descricao;
    }

    public boolean setDescricao(String descricao) {
        if (descricao.length() > 3) {
            this.Descricao = descricao;
            return true;
        } else {
            System.out.println("Digite pelo menos 4 caracteres para a descrição. ");
            return false;
        }
    }

    public String getFornecedor() {
        return Fornecedor;
    }

    public boolean setFornecedor(String fornecedor) {
        if (fornecedor.length() > 3) {
            this.Fornecedor = fornecedor;
            return true;
        } else {
            System.out.println("Digite pelo menos 4 caracteres para o fornecedor.");
            return false;
        }
    }

    public String getUnidade() {
        return Unidade;
    }

    public Boolean setUnidade(String unidade) {

        switch (unidade) {
            case "1":
                unidade = "KG";
                break;
            case "2":
                unidade = "UN";
                break;
            case "3":
                unidade = "PCT";
                break;
        }
        if (unidade == "KG" || unidade == "UN" || unidade == "PCT") {
            this.Unidade = unidade;
            return true;
        } else {
            return true;
        }

    }

    public String getValor() {
        return valor;
    }

    public Boolean setValor(String valor) {
        Pattern pattern = Pattern.compile("^[0-9]+,[0-9]{2}$");
        Matcher matcher = pattern.matcher(valor);
        if (matcher.find()) {
            this.valor = valor;
            return true;
        } else {
            return false;
        }
    }

    public String getCategoria() {
        return Categoria;
    }

    public Boolean setCategoria(String categoria) {
        if (categoria.length() > 3) {
            this.Categoria = categoria;
            return true;
        } else {
            System.out.println("Digite mais de 3 caracteres para categoria.");
            return false;
        }
    }

}