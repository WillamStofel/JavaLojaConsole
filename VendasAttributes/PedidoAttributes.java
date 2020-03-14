package VendasAttributes;


/**
 * PedidoAttributes
 */
public class PedidoAttributes {

    private Integer IdPedido;
    private Integer Quantidade;
    private String Horario;
    private String Date;

    public Integer getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(Integer idPedido) {
        IdPedido = idPedido;
    }

    public Integer getQuantidade() {
        return Quantidade;
    }

    public Boolean setQuantidade(Integer quantidade) {
       if(quantidade > 0)
        {
            Quantidade = quantidade;
            return true;
        }
        else
        {
            System.out.println("quantidade deve ser maior que zero !");
            return false;
        }
    }

   

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        
        Horario = horario;
        
    }

}