package VendasAttributes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import VendasInterface.Vendas;

/**
 * GenericAttributes
 */
public class GenericAttributes {

    private String name;
    private String login;
    private String senha;
    private String TipoFuncionario;

    public String getName() {
        return name;
    }

    public boolean setName(String nome) {
        if (nome.length() > 3) {
            this.name = nome;
            return true;
        } else {
            Vendas.Clear();
            System.out.println("Digite um nome com pelo menos 3 caracteres.");
            return false;
        }
    }

    public String getLogin() {
        return login;
    }

    public boolean setLogin(String login) {
        if (login.length() > 3) {
            this.login = login;
            return true;
        } else {
            Vendas.Clear();
            System.out.println("Digite pelo menos 4 caracteres.");
            return false;
        }
    }

    public String getSenha() {
        return senha;
    }

    public Boolean setSenha(String senha) {

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(senha);

        if (matcher.find()) {
            this.senha = senha;
            return true;
        } else {
            Vendas.Clear();
            System.out.println("Digite um número pelo menos na senha");
            return false;
        }
    }

    public String getTipoFuncionario() {
        return TipoFuncionario;
    }

    public Boolean setTipoFuncionario(String TipoFunc) {
        if (TipoFunc.compareTo("1") == 0 || TipoFunc.compareTo("2") == 0) {
            this.TipoFuncionario = TipoFunc;
            return true;

        } else
        {
            System.out.println("Digite apenas 1 ou 2 !");
            return false;
        }
    }

}