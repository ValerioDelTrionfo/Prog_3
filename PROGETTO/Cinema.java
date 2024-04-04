import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Cinema{
    File f= new File("C:USERDIRHERE\\Desktop\\PROGETTO\\dati\\cinema");
    private static final int n_sale=3;
    protected ArrayList<sala> sale = new ArrayList<sala>(n_sale);
   
    public Cinema(sala sala) {
        sale.add(sala);  
    }
    public void addsala(sala sala){
        sale.add(sala);
    }

    //Cambia i prezzi e aggiorna i valori nei file
    public void changePrice(int n,double pr) throws IOException{
        switch(n){
            case 0 :
                    File fi = new File(f+"/sala_1.txt");
                    List<String> filecont = new ArrayList<>(Files.readAllLines(fi.toPath(),StandardCharsets.UTF_8));
                    String prezzo = Double.toString(pr);
                    filecont.set(1, prezzo);
                    Files.write(fi.toPath(), filecont, StandardCharsets.UTF_8);
                break;
            case 1 : 
                    File fi2 = new File(f+"/sala_2.txt");
                    List<String> filecont2 = new ArrayList<>(Files.readAllLines(fi2.toPath(),StandardCharsets.UTF_8));
                    String prezzo2 = Double.toString(pr);
                    filecont2.set(1, prezzo2);
                    Files.write(fi2.toPath(), filecont2, StandardCharsets.UTF_8);
                break;
            case 2 : 
                    
                    File fi3 = new File(f+"/sala_3.txt");
                    List<String> filecont3 = new ArrayList<>(Files.readAllLines(fi3.toPath(),StandardCharsets.UTF_8));
                    String prezzo3 = Double.toString(pr);
                    filecont3.set(1, prezzo3);
                    Files.write(fi3.toPath(), filecont3, StandardCharsets.UTF_8);
                break;
        }
        sala s = sale.get(n);
        s.changeprice(pr);
        sale.set(n, s);
    }

    //mostra le informazioni riguardanti le varie sale 
    public void showfilms(int n){
        switch(n){
            case 0 : 
                try {
                    RandomAccessFile raf = new RandomAccessFile(f+"/sala_1.txt", "rw");
                    String nome = raf.readLine();
                    String prezzo = raf.readLine();
                    String or = raf.readLine();
                    JOptionPane.showMessageDialog(null,"displaying : " + nome + " for " + prezzo + "€" + " in room 1 , starting at : " + or );
                } catch (FileNotFoundException e) {
                    System.out.println("file not found exe");
                }catch (IOException ioe){
                    System.out.println("i/o error");
                }
                break;
            case 1 :
                try {
                    RandomAccessFile raf = new RandomAccessFile(f+"/sala_2.txt", "rw");
                    String nome = raf.readLine();
                    String prezzo = raf.readLine();
                    String or = raf.readLine();
                    JOptionPane.showMessageDialog(null,"displaying : " + nome + " for " + prezzo + "€" + " in room 2 , starting at : " + or );
                } catch (FileNotFoundException e) {
                    System.out.println("file not found exe");
                }catch (IOException ioe){
                    System.out.println("i/o error");
                }
                break;
            case 2 : 
                try {
                    RandomAccessFile raf = new RandomAccessFile(f+"/sala_3.txt", "rw");
                    String nome = raf.readLine();
                    String prezzo = raf.readLine();
                    String or = raf.readLine();
                    JOptionPane.showMessageDialog(null,"displaying : " + nome + " for " + prezzo + "€" + " in room 3 , starting at : " + or );
                } catch (FileNotFoundException e) {
                    System.out.println("file not found exe");
                }catch (IOException ioe){
                    System.out.println("i/o error");
                }
                break;
        }      
    }

    //ottiene l'indice che la sala ha nella lista
    public sala getsala(int n){
        sala s = sale.get(n);
        return s;
    }

    //inizializza i vari valori delle sale
    public void loadfilms(){
        try {
            RandomAccessFile rf = new RandomAccessFile(f+"/sala_1.txt", "rw");
            String nome = rf.readLine();
            String prezzo_file = rf.readLine();
            String orario_file = rf.readLine();
            String guadagni = rf.readLine();
            Double prezzo = Double.parseDouble(prezzo_file);
            double orario = Double.parseDouble(orario_file);
            double guad = Double.parseDouble(guadagni);
            sala s1 = sale.get(0);
            s1.changename(nome);
            s1.changeprice(prezzo);
            s1.changeora(orario);
            s1.addincassi(guad);
            sale.set(0, s1);
            RandomAccessFile rf2 = new RandomAccessFile(f+"/sala_2.txt", "rw");
            String nome2 = rf2.readLine();
            String prezzo_file2 = rf2.readLine();
            String orario_file2= rf2.readLine();
            String guadagni2 = rf2.readLine();
            Double prezzo2 = Double.parseDouble(prezzo_file2);
            double orario2 = Double.parseDouble(orario_file2);
            double guad2 = Double.parseDouble(guadagni2);
            sala s2 = sale.get(1);
            sale.set(1, s2);
            s2.changename(nome2);
            s2.changeprice(prezzo2);
            s2.changeora(orario2);
            s2.addincassi(guad2);
            RandomAccessFile rf3 = new RandomAccessFile(f+"/sala_3.txt", "rw");
            String nom3 = rf3.readLine();
            String prezzo_file3 = rf3.readLine();
            String orario_file3 = rf3.readLine();
            String guadagni3 = rf3.readLine();
            Double prezzo3 = Double.parseDouble(prezzo_file3);
            double orario3 = Double.parseDouble(orario_file3);
            double guad3 = Double.parseDouble(guadagni3);
            sala s3 = sale.get(2);
            s3.changename(nom3);
            s3.changeprice(prezzo3);
            s3.changeora(orario3);
            s3.addincassi(guad3);
            sale.set(2, s3);
        } catch (FileNotFoundException e) {
           
        }catch (IOException ioe){

        }
    }

    //Cambia l'orario di proiezione dei film nei vari file
    public void changehr(int n, double hr) throws IOException{
        switch(n){
            case 0 :
                    File fi = new File(f+"/sala_1.txt");
                    List<String> filecont = new ArrayList<>(Files.readAllLines(fi.toPath(),StandardCharsets.UTF_8));
                    String ora = String.valueOf(hr);
                    filecont.set(2, ora);
                    Files.write(fi.toPath(), filecont, StandardCharsets.UTF_8);
                    break;
        
            case 1 :
                    File fi2 = new File(f+"/sala_2.txt");
                    List<String> filecont2 = new ArrayList<>(Files.readAllLines(fi2.toPath(),StandardCharsets.UTF_8));
                    String ora2 = String.valueOf(hr);
                    filecont2.set(2, ora2);
                    Files.write(fi2.toPath(), filecont2, StandardCharsets.UTF_8);
                    break;    
            
            case 2 :
                    File fi3 = new File(f+"/sala_3.txt");
                    List<String> filecont3 = new ArrayList<>(Files.readAllLines(fi3.toPath(),StandardCharsets.UTF_8));
                    String ora3 = String.valueOf(hr);
                    filecont3.set(2, ora3);
                    Files.write(fi3.toPath(), filecont3, StandardCharsets.UTF_8);
                    break;
        }
    }

    //Aggiorna i dati riguardanti incassi e affluenza nei vari file
    public void upearnings(int n, double amount) throws IOException{
        switch(n){
            case 0 : 
                File fi = new File(f+"/sala_1.txt");
                List<String> filecont = new ArrayList<>(Files.readAllLines(fi.toPath(),StandardCharsets.UTF_8));
                String ear = filecont.get(3);
                String aff = filecont.get(4);
                int aff1 = Integer.parseInt(aff);
                Double guad = Double.parseDouble(ear);
                guad+=amount;
                aff1++;
                String newear = String.valueOf(guad);
                filecont.set(3, newear);
                filecont.set(4,String.valueOf(aff1));
                Files.write(fi.toPath(), filecont, StandardCharsets.UTF_8);
                break;
            
            case 1 : 
                File fi2 = new File(f+"/sala_2.txt");
                List<String> filecont2 = new ArrayList<>(Files.readAllLines(fi2.toPath(),StandardCharsets.UTF_8));
                String ear2 = filecont2.get(3);
                String aff2 = filecont2.get(4);
                Double guad2 = Double.parseDouble(ear2);
                int aff_2 = Integer.parseInt(aff2);
                aff_2++;
                guad2+=amount;
                String newear2 = String.valueOf(guad2);
                filecont2.set(3, newear2);
                filecont2.set(4,String.valueOf(aff_2));
                Files.write(fi2.toPath(), filecont2, StandardCharsets.UTF_8);
                break;

            
            case 2 : 
                File fi3 = new File(f+"/sala_3.txt");
                List<String> filecont3 = new ArrayList<>(Files.readAllLines(fi3.toPath(),StandardCharsets.UTF_8));
                String ear3 = filecont3.get(3);
                String aff3 = filecont3.get(4);
                Double guad3 = Double.parseDouble(ear3);
                int aff_3 = Integer.parseInt(aff3);
                guad3+=amount;
                aff_3++;
                String newear3 = String.valueOf(guad3);
                filecont3.set(3, newear3);
                filecont3.set(4,String.valueOf(aff_3));
                Files.write(fi3.toPath(), filecont3, StandardCharsets.UTF_8);
                break;
        }
    }

    //Annulla acquisto biglietto e aggiorna i dati sui vari file
    public void undoearnings(int n, double amount) throws IOException{
        switch(n){
            case 0 : 
                File fi = new File(f+"/sala_1.txt");
                List<String> filecont = new ArrayList<>(Files.readAllLines(fi.toPath(),StandardCharsets.UTF_8));
                String ear = filecont.get(3);
                String freq = filecont.get(4);
                Double guad = Double.parseDouble(ear);
                int aff = Integer.parseInt(freq);
                if(guad>=amount){
                guad-=amount;
                String newear = String.valueOf(guad);
                filecont.set(3, newear);
                aff--;
                filecont.set(4,String.valueOf(aff));
                Files.write(fi.toPath(), filecont, StandardCharsets.UTF_8);
            }else System.out.println("impossibile aggiornare il bilancio");
                break;
            
            case 1 : 
                File fi2 = new File(f+"/sala_2.txt");
                List<String> filecont2 = new ArrayList<>(Files.readAllLines(fi2.toPath(),StandardCharsets.UTF_8));
                String ear2 = filecont2.get(3);
                String freq2 = filecont2.get(4);
                int aff2 = Integer.parseInt(freq2);
                Double guad2 = Double.parseDouble(ear2);
                if(guad2>=amount){
                guad2-=amount;
                aff2--;
                String newear2 = String.valueOf(guad2);
                filecont2.set(3, newear2);
                filecont2.set(4,String.valueOf(aff2));
                Files.write(fi2.toPath(), filecont2, StandardCharsets.UTF_8);
            }else   System.out.println("impossibile aggiornare il bilancio");
                break;

            
            case 2 : 
                File fi3 = new File(f+"/sala_3.txt");
                List<String> filecont3 = new ArrayList<>(Files.readAllLines(fi3.toPath(),StandardCharsets.UTF_8));
                String ear3 = filecont3.get(3);
                String freq3 = filecont3.get(4);
                int aff3 = Integer.parseInt(freq3);
                Double guad3 = Double.parseDouble(ear3);
                if(guad3>=amount){
                guad3-=amount;
                aff3--;
                String newear3 = String.valueOf(guad3);
                filecont3.set(3, newear3);
                filecont3.set(4,String.valueOf(aff3));
                Files.write(fi3.toPath(), filecont3, StandardCharsets.UTF_8);
            }else System.out.println("impossibile aggiornare il bilancio");
                break;
        }
    }


    //Genera il report sugli incassi e affluenze in sala
    public void showoearnings(int n) throws IOException {
        switch (n){
            case 0 :
                    File f1 = new File(f+"/sala_1.txt");
                    List <String> file1 = new ArrayList<>(Files.readAllLines(f1.toPath(),StandardCharsets.UTF_8));
                    String earnings = file1.get(3);
                    String affl = file1.get(4);
                    JOptionPane.showMessageDialog(null, "Earnings " + earnings + "€" + " Customers : " + affl );
                    break;

            case 1 :
                    File f2 = new File(f+"/sala_2.txt");
                    List <String> file2 = new ArrayList<>(Files.readAllLines(f2.toPath(),StandardCharsets.UTF_8));
                    String earnings2 = file2.get(3);
                    String aff2 = file2.get(4);
                    JOptionPane.showMessageDialog(null, "Earnings " + earnings2 + "€" + " Customers : " + aff2 );
                    break;

            case 2 :
                    File f3 = new File(f+"/sala_3.txt");
                    List <String> file3 = new ArrayList<>(Files.readAllLines(f3.toPath(),StandardCharsets.UTF_8));
                    String earnings3 = file3.get(3);
                    String aff3 = file3.get(4);
                    JOptionPane.showMessageDialog(null, "Earnings " + earnings3 + "€" + " Customers : " + aff3 );
                    break;
        }
    }
    public void changename(int n,String nom) throws IOException{
        switch (n) {
            case 0 :
                    File faf = new File(f+"/sala_1.txt");
                    List<String> filecontent = new ArrayList<>(Files.readAllLines(faf.toPath(),StandardCharsets.UTF_8));
                    filecontent.set(0, nom);
                    sale.get(0).changename(nom);
                    Files.write(faf.toPath(),filecontent,StandardCharsets.UTF_8);
                    break;
            case 1 :
                    File faf2 = new File(f+"/sala_2.txt");
                    List<String> filecontent2 = new ArrayList<>(Files.readAllLines(faf2.toPath(),StandardCharsets.UTF_8));
                    filecontent2.set(0, nom);
                    sale.get(1).changename(nom);
                    Files.write(faf2.toPath(),filecontent2,StandardCharsets.UTF_8);
                    break;
            case 2 :
                    File faf3 = new File(f+"/sala_3.txt");
                    List<String> filecontent3 = new ArrayList<>(Files.readAllLines(faf3.toPath(),StandardCharsets.UTF_8));
                    filecontent3.set(0, nom);
                    sale.get(2).changename(nom);
                    Files.write(faf3.toPath(),filecontent3,StandardCharsets.UTF_8);
                    break;
            default:
                break;
        }
    }
}