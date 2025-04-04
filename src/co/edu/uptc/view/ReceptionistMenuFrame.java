package co.edu.uptc.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ReceptionistMenuFrame extends JFrame{
    public ReceptionistMenuFrame(){
        super("Receptionist Menu");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel maiPanel= new JPanel();
        maiPanel.add(new JLabel("Menu Receptionist"));
        setVisible(true);
    }

}
