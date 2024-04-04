import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class titlecg_page implements ActionListener {
    Cinema ci;
    int s_numb;
    //Gui elements
    JFrame frame = new JFrame();
    JLabel lab = new JLabel("title changing page",SwingConstants.CENTER);
    JLabel newp = new JLabel("new title :");
    JTextField title = new JTextField();
    JButton ok = new JButton("Ok");

    public titlecg_page(Cinema cin,int s_n){
        ci=cin;
        s_numb=s_n;
        frame.add(lab);
        frame.add(newp);
       
        frame.add(title);
     
        frame.add(ok);
        ok.addActionListener(this);
        ok.setBounds(100,125,75,20);
        ok.setFocusable(false);
        newp.setBounds(20,70,75,25);
        title.setBounds(100,70,60,25);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(200,200);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    //gestione del cambio prezzo
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ok){
                if(!title.getText().isEmpty()){
                    try {
                        String nome = title.getText();
                        ci.changename(s_numb, nome);
                        JOptionPane.showMessageDialog(null, "changes applied");
                    } catch (IOException ex) {
                        System.out.println("IOEXE");
                    }

                frame.dispose();
            }
        }
    }
}