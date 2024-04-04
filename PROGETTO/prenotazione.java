import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class prenotazione extends user_log implements ActionListener{
    int id= Integer.MIN_VALUE;
    public prenotazione(Cinema ci) {
        super(ci);
    }
    sala s = cin.getsala(0);
    sala s2 = cin.getsala(1);
    sala s3 = cin.getsala(2);

    //Gui elements
    JFrame frame = new JFrame();
    JLabel select = new JLabel("SELECT THE FILM");
    JLabel f1 = new JLabel(s.showFilmname());
    JLabel f2 = new JLabel(s2.showFilmname());
    JLabel f3 = new JLabel(s3.showFilmname());
    JLabel f4 = new JLabel("Payment methods : ");

    JButton b1 = new JButton(String.valueOf(s.showfilmprices())+" €");
    JButton b2 = new JButton(String.valueOf(s2.showfilmprices())+" €");
    JButton b3 = new JButton(String.valueOf(s3.showfilmprices())+" €");
    JButton b4 = new JButton("Contanti");
    JButton b5 = new JButton("Bancomat");
    JButton b6 = new JButton("Credit Card");
    Image icona = Toolkit.getDefaultToolkit().getImage("C:\\USERDIRHERE\\PROGETTO\\dati\\cin_logo.jpg");
    
    public void genera_prenotazione(){
        frame.add(select);
        frame.add(f1);
        frame.add(f2);
        frame.add(f3);
        frame.add(f4);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);


        b1.setBounds(270,80,90,25);
        b2.setBounds(270,130,90,25);
        b3.setBounds(270,180,90,25);
        b4.setBounds(30,290,100,25);
        b5.setBounds(155,290,100,25);
        b6.setBounds(270,290,100,25);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);
        b4.setFocusable(false);
        b5.setFocusable(false);
        b6.setFocusable(false);

        f1.setBounds(130,80,140,25);
        f2.setBounds(130,130,140,25);
        f3.setBounds(130,180,140,25);
        f4.setBounds(50,260,130,25);
        select.setBounds(130,20,200,35);
        select.setFont(new Font("Serif",Font.ROMAN_BASELINE,12));
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setIconImage(icona);
        frame.setTitle("BOOKING PAGE");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b4){
            id=0;
        }
        if(e.getSource()==b5){
            id=1;
        }
        if(e.getSource()==b6){
            id=2;
        }

        //Generazione schermata pagamenti in base al film scelto
        if(id!=Integer.MIN_VALUE){
            if(e.getSource()==b1){
            user_payment upay = new user_payment(id,cin,0);
            id=Integer.MIN_VALUE;
            frame.dispose();
            }else  if(e.getSource()==b2){
                user_payment upay = new user_payment(id,cin,1);
                id=Integer.MIN_VALUE;
                frame.dispose();
                }else  if(e.getSource()==b3){
                    user_payment upay = new user_payment(id,cin,2);
                    id=Integer.MIN_VALUE;
                    frame.dispose();
                    }
        }else JOptionPane.showInternalMessageDialog(null, "Select a payment method ");

        }
    }