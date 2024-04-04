import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class user_log implements ActionListener {
    Cinema cin;
    //Gui elements
    JFrame frame = new JFrame();
    JButton prenota = new JButton("Book Ticket");
    
    public user_log(Cinema ci){
        cin = ci;
        frame.add(prenota);

        prenota.addActionListener(this);
        prenota.setBounds(15,50,160,35);
        prenota.setFocusable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(200,200);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    @Override
    //Generazione schermata per la prenotazione
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==prenota){
            prenotazione pre = new prenotazione(cin);
            pre.genera_prenotazione();
            frame.dispose();
        }
    }    
}
