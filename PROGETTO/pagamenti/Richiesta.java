package pagamenti;

public class Richiesta {

    //classe che implementa la mia richiesta da passare ai miei concrete handler
    
    private double importo;
    private int type;

    public Richiesta(double somma,int tp){
        importo=somma;
        type=tp;
    }

    public double getimpt(){
        return importo;
    }
    public int gettp(){
        return type;
    }
}