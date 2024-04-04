import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.event.*;
import javax.swing.*;


public class login implements ActionListener{
    Cinema cinema ;
    int ln;
    File f= new File("C:\\USERDIRHERE\\Desktop\\PROGETTO\\dati");
    File c = new File("C:\\USERDIRHERE\\Desktop\\PROGETTO\\dati\\cinema");

    //Gui elementss
    JFrame frame = new JFrame();
    JButton adminlog = new JButton("admin login");
    JButton loginbtn = new JButton("login");
    JButton resetbtn = new JButton("reset");
    JButton register = new JButton("register");
    JTextField useridfField = new JTextField();
    JPasswordField uPasswordField = new JPasswordField();
    JLabel useridLab = new JLabel("userID :");
    JLabel userPasslab = new JLabel("password : ");
    Image icona = Toolkit.getDefaultToolkit().getImage("C:\\USERDIRHERE\\PROGETTO\\dati\\cin_logo.jpg");

   
    public login(){
        creaFolder();
        readcinemafile();
        cinemainit();
        readfile();

        useridLab.setBounds(50,100,75,25);
        userPasslab.setBounds(50,150,75,25);
        useridfField.setBounds(125,100,200,25);
        uPasswordField.setBounds(125,150,200,25);
        adminlog.setBounds(225,250,100,25);
        adminlog.addActionListener(this);
        adminlog.setFocusable(false);
        loginbtn.setBounds(125,200,100,25);
        loginbtn.addActionListener(this);
        loginbtn.setFocusable(false);
        register.setBounds(125,250,100,25);
        register.addActionListener(this);
        register.setFocusable(false);
        resetbtn.setBounds(225,200,100,25);
        resetbtn.addActionListener(this);
        resetbtn.setFocusable(false);

        frame.add(adminlog);
        frame.add(register);
        frame.add(loginbtn);
        frame.add(resetbtn);
        frame.add(useridfField);
        frame.add(uPasswordField);
        frame.add(useridLab);
        frame.add(userPasslab);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setIconImage(icona);
        frame.setTitle("LOGIN PAGE");
     }



    @Override
    //Reset dei campi di inserimento 
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==resetbtn){
            useridfField.setText("");
            uPasswordField.setText("");
       }
       //Registrazione utente mediante la scrittura nel file "login"
       if(e.getSource()==register){
            try{
                RandomAccessFile rf = new RandomAccessFile(f+"/login.txt", "rw");
                rf.seek(rf.length());
                rf.writeBytes("Username:"+ useridfField.getText() + "\r\n");
                rf.writeBytes("Password:" + String.valueOf(uPasswordField.getPassword()) + "\r\n");
                rf.writeBytes("\n");
                
            }catch(FileNotFoundException ex){
                JOptionPane.showMessageDialog(null,"an error occurred while writing on the file!");
            }catch(IOException ioe){
                JOptionPane.showMessageDialog(null,"I/O op wrongfully interrupted!");
            }
       }
       //Ricerca dei dati inseriti nel file "login" per effettuare l'accesso al sistema
        if(e.getSource()==loginbtn){
            int c = Linecounter();
            try{
                RandomAccessFile raf = new RandomAccessFile(f+"/login.txt", "rw");      //raf per accedere al file
                for(int i=0;i<Linecounter();i+=3){      //ciclo for per scorrere i vari blocchi (NB : i dati sono salvati in blocchi di 2 righe divisi da uno spazio)
                String uname = raf.readLine().substring(9);
                String pwd = raf.readLine().substring(9);
                if(useridfField.getText().equalsIgnoreCase("admin")){
                    JOptionPane.showMessageDialog(null,"Permission denied, use the admin login to do this action");
                }else if(uname.equals(useridfField.getText()) & pwd.equals(String.valueOf(uPasswordField.getPassword()))){
                    JOptionPane.showMessageDialog(null,"Login succesfull");
                    user_log usr = new user_log(cinema);
                    frame.dispose();
                    break;
                }else if(i==(Linecounter()-3)){
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                    break;
                    }
                raf.readLine(); //readline necessario per leggere l'ultima riga e non skipparla
                }
            }catch(FileNotFoundException es){
                System.out.println("Errore nell'apertura del file");
            }catch (IOException ex){
                System.out.println("IOEXE");
            }
        }

        //Login lato admin
        if(e.getSource()==adminlog){
            int c = Linecounter();
            try{
                RandomAccessFile raf = new RandomAccessFile(f+"/login.txt", "rw");
                for(int i=0;i<Linecounter();i+=3){
                String uname = raf.readLine().substring(9);
                String pwd = raf.readLine().substring(9);
                if(uname.equals(useridfField.getText()) & uname.equals("admin") & pwd.equals(String.valueOf(uPasswordField.getPassword()))){
                    JOptionPane.showMessageDialog(null,"Login succesfull welcome back admin!");
                    admin_page ad = new admin_page(cinema);
                    frame.dispose();
                    break;
                }else if(i==(Linecounter()-3)){
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                    break;
                    }
                raf.readLine();
                }
            }catch(FileNotFoundException es){

            }catch (IOException ex){

            } 
        }
    }

    //Conta le linee presenti nel file di login
    private int Linecounter(){
        try{
        ln=0;
        RandomAccessFile raf = new RandomAccessFile(f+"/login.txt","rw");
        for(int i=0;raf.readLine()!=null;i++){
            ln++;
            }
        }catch(FileNotFoundException ex){

        }catch(IOException ex){

        }
        return ln;
    }

    //Funzione per creare le cartella in caso non dovessero esserci già
    private void creaFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
        if(!c.exists()){
            c.mkdirs();
        }
    }

    //Funzione Utilizzata per Leggere il file di login in caso ci fosse già o crearlo se serve
    private void readfile(){
        try{
        FileReader fr = new FileReader(f+"/login.txt");
        System.out.println("il file esiste gia!");
        }catch(FileNotFoundException e){
            try{
                FileWriter fw = new FileWriter(f+"/login.txt");
                System.out.println("file creato");
            }catch(IOException ex){
                System.out.println("errore nella creazione");
            }
        }
    }

    //Funzione usata per leggere i vari file delle sale o crearli all'evenienza
    private void readcinemafile(){
        try{
        FileReader fr = new FileReader(c+"/sala_1.txt");
        FileReader fr2 = new FileReader(c+"/sala_2.txt");
        FileReader fr3 = new FileReader(c+"/sala_3.txt");
        }catch(FileNotFoundException e){
            try{
                FileWriter fw = new FileWriter(c+"/sala_1.txt");
                FileWriter fw2 = new FileWriter(c+"/sala_2.txt");
                FileWriter fw3 = new FileWriter(c+"/sala_3.txt");
            }catch(IOException ioe){
                System.out.println("errore nella creazione ");
            }
        }
    }

    //inizializzazione dei campi del cinema leggendoli dai file
    public void cinemainit(){
        cinema = new Cinema(new sala(0));
        cinema.addsala(new sala(1));
        cinema.addsala(new sala(2));
        cinema.loadfilms();
    }
}