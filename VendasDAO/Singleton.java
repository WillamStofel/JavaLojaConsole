package VendasDAO;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedList;

public class Singleton {

    private Singleton() {
        ListaMensagens = new LinkedList<>();
    }

    private static Singleton instancia;
    LinkedList<String> ListaMensagens;

    public static Singleton getInstancia() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;

    }

    ThreadMensagensAuditoria thread;

    public void AdicionaMsgAuditoria(String Msg) {
        ListaMensagens.add(Msg);
    }

    String RetiraMsgAuditoria() {
        String msg = ListaMensagens.poll();
        return msg;
    }

    public void ativar() {
        if (thread == null) {
            thread = new ThreadMensagensAuditoria();
            thread.start();
        }
    }

    public void desativar() {
        if (thread != null) {
            thread.setStatus(false);
            try {
                thread.join(2000);

            } catch (InterruptedException ex) {
                Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (thread.isAlive())
                thread.interrupt();

        }
    }
}