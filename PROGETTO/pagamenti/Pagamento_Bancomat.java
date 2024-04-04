package pagamenti;

import javax.swing.*;

public class Pagamento_Bancomat extends Paga{
    
    @Override
    public void handlepagamento(Richiesta rich) {
        if(rich.gettp()==1){
            JOptionPane.showMessageDialog(null,"Pagamento effettuato con Bancomat");
        }else{
            successore.handlepagamento(new Richiesta(rich.getimpt(), rich.gettp()));
        }
    }
}
