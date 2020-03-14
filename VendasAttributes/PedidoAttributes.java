package VendasAttributes;

import java.text.DateFormat;
import java.util.Calendar;


/**
 * PedidoAttributes
 */
public class PedidoAttributes {

    private Integer IdPedido;
    private Integer Quantidade;
    private DateFormat Horario;
    private DateFormat Date;

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

   

    public DateFormat getDate() {
        return Date;
    }

    public void setDate(DateFormat date) {
        Date = date;
    }

    public DateFormat getHorario() {
        return Horario;
    }

    public void setHorario(DateFormat horario) {
        
        Horario = horario;
        
    }

}