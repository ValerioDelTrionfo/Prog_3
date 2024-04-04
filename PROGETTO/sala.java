import java.util.Random;

public class sala{
    private Double incassi=0.0;
    public int seats=100;
    public String nomefilm;
    public Double orario;
    public double prezzo;
    protected int num;

    public sala(int nm) {
         num=nm;
    }
    
    //vari metodi getter e setter

    public int getnumsala(){
        return num;
    }
    public void changeprice(double price){
        prezzo=price;
    }
    public double showear(){
        return incassi;
    }
    public void changename(String n){
        nomefilm=n;
    }
    public String showFilmname(){
        return nomefilm;
    }
    public double showfilmprices(){
       return prezzo;
    }
    public double showorario(){
        return orario;
    }
    public void changeora(double or){
        orario=or;
    }
    public int getremaningseats(){
        return seats;
    }
    public int getseats(){
        Random rand = new Random();
        int s = rand.nextInt(seats-1)+1;
        return s;
    }
    public void addincassi(double amount){
        incassi+=amount;
    }
}