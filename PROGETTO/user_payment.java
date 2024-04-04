import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pagamenti.bankaccount;
import pagamenti.memento;

public class user_payment implements ActionListener {
    protected String nome;
    protected String cognome;
    protected int eta;
    protected int id;
    protected int s;
    protected boolean isridotto=false;
    boolean bought=false;
    Cinema ci;
    //Gui elements
    bankaccount banca = new bankaccount();
    memento pro = banca.update();
    JFrame frame = new JFrame();
    JLabel name = new JLabel("Name : ");
    JLabel secname = new JLabel("Second Name : ");
    JLabel et = new JLabel("Age : ");
    JTextField n = new JTextField();
    JTextField sn = new JTextField();
    JTextField age = new JTextField();
    JButton conferma = new JButton("Confirm");
    Image icona = Toolkit.getDefaultToolkit().getImage("C:\\USERDIRHERE\\PROGETTO\\dati\\cin_logo.jpg");


    public user_payment(int i,Cinema cin,int sala){
        ci=cin;
        s=sala;
        id=i;
        frame.add(name);
        frame.add(secname);
        frame.add(n);
        frame.add(sn);
        frame.add(conferma);
        frame.add(age);
        frame.add(et);

        age.setBounds(180,200,50,25);
        et.setBounds(90,200,100,25);
        conferma.setBounds(150,280,100,20);
        conferma.addActionListener(this);
        conferma.setFocusable(false);
        sn.setBounds(180,150,100,25);
        n.setBounds(180,100,100,25);
        name.setBounds(125,100,150,25);
        secname.setBounds(90,150,200,25);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setIconImage(icona);
        frame.setTitle("PAYMENT CONFIRM");
    }


    @Override
    public void actionPerformed(ActionEvent e){
        //erogazione del ticket
        if(e.getSource()==conferma){
            if(!n.getText().isEmpty() & !sn.getText().isEmpty() & !age.getText().isEmpty() & Integer.parseInt(age.getText())>=0 & Integer.parseInt(age.getText())<=99){     //controllo che il campo età non sia vuoto e che rientri nell'intervallo [0,99]
                setnome(n.getText());
                setcognome(sn.getText());
                int age2=Integer.parseInt(age.getText());
                seteta(age2);
                sala sal = ci.getsala(s);
                if(Integer.parseInt(age.getText())<18 & Integer.parseInt(age.getText())>=0 ){   //controllo per il ridotto
                    double prezzo=sal.prezzo;   
                    isridotto=true;
                    prezzo=prezzo-(prezzo/10);
                    banca.paga(prezzo,id);
                    try {
                        ci.upearnings(s, prezzo);
                    }catch (IOException e1) {
                    }
                    bought=true;
                    ci.sale.set(s, sal);
                    ticket tick = new ticket(id, ci, s);
                    tick.generaticket(isridotto,n.getText(),sn.getText(),prezzo);
                    frame.dispose();
                }else {
                    banca.paga(sal.prezzo,id);
                    try {
                        ci.upearnings(s, sal.prezzo);
                    } catch (IOException e1) {

                    } 
                    isridotto=false;
                    bought=true;
                    ci.sale.set(s, sal);
                    ticket tick = new ticket(id, ci, s);
                    tick.generaticket(isridotto,n.getText(),sn.getText(),sal.prezzo);
                    
                }
            }else JOptionPane.showMessageDialog(null, "please insert a valid age");
        }
    }

    //setters and getters
    public void seteta(int n){
        eta=n;
    }
    public void setnome(String n){
        nome=n;
    }
    public void setcognome(String c){
        cognome=c;
    }
    public String getnome(){
        return nome;
    }
    public String getCogn(){
        return cognome;
    }
    public int getage(){
        return eta;
    }
}