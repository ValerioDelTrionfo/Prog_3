import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


import javax.swing.*;


public class admin_page implements ActionListener{
    File f= new File("C:\\USERDIRHERE\\Desktop\\PROGETTO\\dati\\cinema");
    int id=Integer.MIN_VALUE;
    Cinema cin;
    //GUi elements
    JFrame frame = new JFrame();
    JLabel AdminP = new JLabel("Welcome to the admin page",SwingConstants.CENTER);
    JLabel op = new JLabel("Select the op :");
    JLabel room = new JLabel("select a room : ");
    JButton changetitle = new JButton("Change the Film ");
    JButton changeprice = new JButton("Change the price ");
    JButton getreport = new JButton("Get reports ");
    JButton changehr = new JButton("Change the hour");
    JButton showfilms = new JButton("Show films");
    JButton uno = new JButton("1");
    JButton due = new JButton("2");
    JButton tre = new JButton("3");
    Image icona = Toolkit.getDefaultToolkit().getImage("C:\\USERDIRHERE\\PROGETTO\\dati\\cin_logo.jpg");
    
    public admin_page(Cinema c){
        cin=c;
        frame.add(changehr);
        frame.add(AdminP);
        frame.add(uno);
        frame.add(due);
        frame.add(tre);
        frame.add(op);
        frame.add(changetitle);
        frame.add(changeprice);
        frame.add(getreport);
        frame.add(room);
        frame.add(showfilms);
      
        uno.addActionListener(this);
        uno.setFocusable(false);
        uno.setBounds(150,300,50,25);
        due.addActionListener(this);
        due.setFocusable(false);
        due.setBounds(200,300,50,25);
        tre.addActionListener(this);
        tre.setFocusable(false);
        tre.setBounds(250,300,50,25);
        
        changehr.addActionListener(this);
        changehr.setBounds(130,150,140,25);
        changehr.setFocusable(false);
        changeprice.addActionListener(this);
        changeprice.setFocusable(false);
        changeprice.setBounds(130,50,140,25);
        changetitle.addActionListener(this);
        changetitle.setBounds(130,100,140,25);
        changetitle.setFocusable(false);
        getreport.addActionListener(this);
        getreport.setBounds(130,250,140,25);
        getreport.setFocusable(false);
        showfilms.addActionListener(this);
        showfilms.setBounds(130,200,140,25);
        showfilms.setFocusable(false);
        op.setBounds(30,100,140,35);
        room.setBounds(30,290,140,45);
        AdminP.setBounds(100,10,200,35);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setIconImage(icona);
        frame.setTitle("ADMIN PAGE");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Gestione della sala scelta
        if(e.getSource()==uno){
           id=0;
         }
        if(e.getSource()==due){
            id=1;
         }
        if(e.getSource()==tre){
            id=2;
         }


        if(id!=Integer.MIN_VALUE){
            if(e.getSource()==changeprice){                     //gestione evento cambio prezzo
                pricecg_page pag = new pricecg_page(cin,id,f);
                id=Integer.MIN_VALUE;
                }else if(e.getSource()==changetitle){           //gestione evento cambio film
                    titlecg_page tit = new titlecg_page(cin, id);
                    id=Integer.MIN_VALUE;
                    
                }else if(e.getSource()==showfilms){             //gestione evento mostra film in sala
                    cin.showfilms(id);
                    id=Integer.MIN_VALUE;
                }else if(e.getSource()==changehr){              
                    hrcg_page hrs = new hrcg_page(cin, id);     //gestione evento cambio orario di proiezione
                    id=Integer.MIN_VALUE;
                }else if(e.getSource()==getreport){             //gestione evento genera report
                try {
                    cin.showoearnings(id);
                } catch (IOException ex) {
                    System.out.println("IOexe");
                }
                id=Integer.MIN_VALUE;
                }
            }else JOptionPane.showMessageDialog(null, "select the room before ");
        }
    }