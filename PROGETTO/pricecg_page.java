import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class pricecg_page implements ActionListener {
    File f;
    Cinema ci;
    int s_numb;

    //Gui elements
    JFrame frame = new JFrame();
    JLabel lab = new JLabel("price changing page",SwingConstants.CENTER);
    JLabel newp = new JLabel("new price :");
    JTextField price = new JTextField();
    JButton ok = new JButton("Ok");
    Calendar cal = Calendar.getInstance();
    int day = cal.get(Calendar.DAY_OF_WEEK);

    public pricecg_page(Cinema cin,int s_n, File c){
        f=c;
        ci=cin;
        s_numb=s_n;
        frame.add(lab);
        frame.add(newp);
       
        frame.add(price);
     
        frame.add(ok);
        ok.addActionListener(this);
        ok.setBounds(100,125,75,20);
        ok.setFocusable(false);
        newp.setBounds(20,70,75,25);
        price.setBounds(100,70,40,25);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(200,200);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Gestione del cambio prezzo
        if(e.getSource()==ok){
                if(!price.getText().isEmpty() && Double.parseDouble(price.getText())>0){
                    Double pr = Double.parseDouble(price.getText());
                    if(day>5){
                        pr=pr+3;
                        try {
                            ci.changePrice(s_numb, pr);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "changes applied");
                        frame.dispose();
                    }else {
                        try {
                            ci.changePrice(s_numb, pr);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "changes applied");
                        frame.dispose();    
                    }
                }else JOptionPane.showMessageDialog(null,"insert correct price");
        }
    }
}