import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.swing.*;

public class ticket extends user_payment{
    //Gui elements
    LocalDateTime inizio;
    LocalDateTime fine;
    JFrame frame = new JFrame();
    JLabel cinlogo = new JLabel();
    JLabel nomelab = new JLabel();
    JLabel cognlab = new JLabel();
    JLabel cost = new JLabel();
    JLabel film = new JLabel();
    JLabel orario = new JLabel();
    JLabel seat = new JLabel();
    JLabel sala = new JLabel();
    JButton undo = new JButton("Refound ticket");
    private double prezzo;
    Image icona = Toolkit.getDefaultToolkit().getImage("C:\\USERDIRHERE\\PROGETTO\\dati\\cin_logo.jpg");

    public ticket(int i, Cinema cin, int sala) {
        super(i, cin, sala);
    }

    //Costruzione grafica del biglietto
    public void generaticket(boolean rid,String nome,String cognome,double price){
        inizio=LocalDateTime.now();
        fine=LocalDateTime.now().plusMinutes(10);
        prezzo=price;
        if(rid==true){
            frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        }else if(rid==false){
            frame.getContentPane().setBackground(Color.RED);
            }
        cinlogo.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\giusi\\OneDrive\\Desktop\\PROGETTO\\dati\\cin_logo.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        undo.addActionListener(this);
        undo.setBounds(600,250,120,30);
        undo.setFocusable(false);
        nomelab.setText("Name : " + nome);
        nomelab.setBounds(200,50,130,30);
        nomelab.setFont(new Font("serif", Font.PLAIN, 20));
        cognlab.setText("Second name : " + cognome);
        cognlab.setBounds(200,100,250,30);
        cognlab.setFont(new Font("serif", Font.PLAIN, 20));
        cost.setText("Cost : " + prezzo + "€");
        cost.setBounds(200,150,100,50);
        cost.setFont(new Font("serif", Font.PLAIN, 20));
        film.setText("Film : " + ci.getsala(s).showFilmname());
        film.setBounds(200,200,200,30);
        film.setFont(new Font("serif", Font.PLAIN, 20));
        orario.setText("Starting at : " + String.valueOf(ci.getsala(s).showorario()));
        orario.setBounds(500,50,200,30);
        orario.setFont(new Font("serif", Font.PLAIN, 20));
        seat.setText("Seat No. : " + ci.getsala(s).getseats());
        seat.setBounds(500,100,200,30);
        seat.setFont(new Font("serif", Font.PLAIN, 20));
        int s_n = ci.getsala(s).getnumsala();
        s_n=s_n+1;
        sala.setText("Room : " + s_n);
        sala.setBounds(500,150,150,30);
        sala.setFont(new Font("serif", Font.PLAIN, 20));

        frame.add(sala);
        frame.add(seat);
        frame.add(orario);
        frame.add(film);
        frame.add(cost);
        frame.add(cognlab);
        frame.add(nomelab);
        frame.add(cinlogo);
        frame.pack();
        frame.add(undo);
        frame.setSize(800,400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(icona);
        frame.setTitle("TICKET");
    }

    @Override
    //Gestione del rimborso
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==undo){
            LocalDateTime ora = LocalDateTime.now();
            if(ora.isBefore(fine)){     //controllo se sono passati 10 minuti dal momento in cui il biglietto è stato erogato
                frame.dispose();
                try {
                    ci.undoearnings(s,prezzo);
                    pro.ripristina();
                    bought=false;
                    isridotto=false;
                } catch (IOException ex) {
                    System.out.println("IOEXE");
                }
                JOptionPane.showMessageDialog(null,"ticket refounded, new balance : " + banca.showbalance());
            }else JOptionPane.showMessageDialog(null,"too late to refound");
        }
    }
}