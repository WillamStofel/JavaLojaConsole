package VendasDAO;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


//import VendasDAO.Singleton;

public class ThreadMensagensAuditoria extends Thread {

    private boolean status;

    @Override
    public void run() {
        setStatus(true);
        while (status) {
            try {
                
                String msg = Singleton.getInstancia().RetiraMsgAuditoria();
                if (msg != null) {
                    enviaMensagemLog(msg);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadMensagensAuditoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setStatus(boolean value) {
        status = value;
    }

    private void enviaMensagemLog(String msg) throws InterruptedException
    {
        try {
            FileWriter fw = new FileWriter("..\\Vendas\\VendasDAO\\Logs.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(msg);
            fw.flush();
            pw.close();
            fw.close();
        } catch (Exception erro) {
            System.out.println(erro);
        }
        Thread.sleep(100);
    }
}