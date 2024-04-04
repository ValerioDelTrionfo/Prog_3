package pagamenti;

import javax.swing.*;

public class bankaccount{
    private double saldo=1000;
    //dichiaro i miei handler
    Paga p1;
    Paga p2;
    Paga p3;
    public bankaccount(){
        //setto i vari concrete handler e i vari successori
        p1 = new Pagamento_Contanti();
        p2 = new Pagamento_Bancomat();
        p3 = new Pagamento_Carta_di_cred();
        p1.setsuccessore(p2);
        p2.setsuccessore(p3);
    }

    //getter per il saldo
    public double showbalance(){
        return saldo;
    }

    //gestione della richiesta
    public void paga(double amout,int t){
        if(saldo>= amout) {
            p1.handlepagamento(new Richiesta(amout, t));
            saldo = saldo - amout;
            JOptionPane.showMessageDialog(null," ha un saldo di : "+ saldo);
        }else {
            JOptionPane.showMessageDialog(null, "Insufficent founds");
        }
    }

    //metodo per salvare lo stato attuale dell'istanza bankaccount
    public memento update(){
        return new restore();
    }


    //classe annidata per l'implementazione del reset
    class restore implements memento{
        private double saldo_att;
        public restore(){
            saldo_att=saldo;
        }
        @Override
        public void ripristina() {
            saldo=saldo_att;
        }
    }
}
