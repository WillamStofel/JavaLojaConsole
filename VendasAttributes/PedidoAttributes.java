package VendasAttributes;
import java.text.DateFormat;
import java.util.Calendar;

/**
 * PedidoAttributes
 */
public class PedidoAttributes {

    private Integer IdPedido;
    private Integer Quantidade;
    private Calendar Horario;
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

    public Calendar getHorario() {
        return Horario;
    }

    public void setHorario(Calendar horario) {
        Horario = horario;
    }

    public DateFormat getDate() {
        return Date;
    }

    public void setDate(DateFormat date) {
        Date = date;
    }

}