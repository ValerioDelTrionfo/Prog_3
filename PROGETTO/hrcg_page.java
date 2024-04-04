import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class hrcg_page implements ActionListener {
    Cinema ci;
    int s_numb;

    //Gui elements
    JFrame frame = new JFrame();
    JLabel lab = new JLabel("hour changing page",SwingConstants.CENTER);
    JLabel newp = new JLabel("new hour :");
    JTextField hrs = new JTextField();
    JButton ok = new JButton("Ok");

    public hrcg_page(Cinema cin,int s_n){
        ci=cin;
        s_numb=s_n;
        frame.add(lab);
        frame.add(newp);
       
        frame.add(hrs);
     
        frame.add(ok);
        ok.addActionListener(this);
        ok.setBounds(100,125,75,20);
        ok.setFocusable(false);
        newp.setBounds(20,70,75,25);
        hrs.setBounds(100,70,60,25);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(200,200);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("HOUR PAGE");
    }

    @Override
    //Gestione del cambio orario
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ok){
                if(!hrs.getText().isEmpty() & Double.parseDouble(hrs.getText())>=0 & Double.parseDouble(hrs.getText())<=24){
                    try {
                        String ora = hrs.getText();
                        double orario = Double.parseDouble(ora);
                        ci.changehr(s_numb, orario);
                        JOptionPane.showMessageDialog(null, "changes applied");
                    } catch (IOException ex) {
                        System.out.println("IOEXE");
                    }

                frame.dispose();
            }else JOptionPane.showMessageDialog(null,"insert a valid time");
        }
    }
}