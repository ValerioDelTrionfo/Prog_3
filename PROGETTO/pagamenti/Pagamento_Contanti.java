package pagamenti;

import javax.swing.*;

public class Pagamento_Contanti extends Paga{
    @Override
    public void handlepagamento(Richiesta rich) {
        if(rich.gettp()==0) {
            JOptionPane.showMessageDialog(null, "Pagamento effettuato in contanti");
            }else{
                successore.handlepagamento(new Richiesta(rich.getimpt(),rich.gettp()));
            }
        }
    }