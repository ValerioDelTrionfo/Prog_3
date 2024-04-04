package pagamenti;

public abstract class Paga {
    //Classe astratta per il mio handler
    protected Paga successore;
    public void setsuccessore(Paga succ){
        successore=succ;
    }
    public abstract  void handlepagamento(Richiesta rich);
}
