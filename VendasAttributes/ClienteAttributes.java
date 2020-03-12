package VendasAttributes;

/**
 * ClienteAttributes
 */
public class ClienteAttributes {

    private String nome;
    private String bairro;
    private String rua;
    private String cidade;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        if (nome.length() > 2) {
            this.nome = nome;
            return true;
        } else {
            System.out.println("Digite mais de dois caracteres para o nome. ");
            return false;
        }

    }

    public String getBairro() {
        return bairro;
    }

    public boolean setBairro(String bairro) {
        if (bairro.length() > 3) {
            this.bairro = bairro;
            return true;
        } else {
            System.out.println("Digite pelo menos 4 caracteres. ");
            return false;
        }

    }

    public String getRua() {
        return rua;
    }

    public boolean setRua(String rua) {
        if (rua.length() > 3) {
            this.rua = rua;
            return true;
        } else {
            System.out.print("Digite pelo menos 4 caracteres. ");
            return false;
        }
    }

    public String getCidade() {
        return cidade;
    }

    public boolean setCidade(String cidade) {
        if (cidade.length() > 3) {
            this.cidade = cidade;
            return true;
        } else {
            System.out.println("Digite pelo menos 4 caracteres. ");
            return false;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean setTelefone(Integer telefone) {
        if(telefone >= 10000000)
        {
            this.telefone = Integer.toString(telefone);
            return true;
        }
        else
        {
            System.out.println("Digite pelo menos 8 digitos para o número de telefone.");
            return false;
        }
    }
}