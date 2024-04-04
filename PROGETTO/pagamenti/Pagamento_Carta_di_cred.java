package pagamenti;

import javax.swing.*;

public class Pagamento_Carta_di_cred extends Paga{
    @Override
    public void handlepagamento(Richiesta rich) {
        if(rich.gettp()==2){
            JOptionPane.showMessageDialog(null,"pagamento effettuato con carta di credito");
        }else{
            successore.handlepagamento(new Richiesta(rich.getimpt(), rich.gettp()));
        }
    }
}
