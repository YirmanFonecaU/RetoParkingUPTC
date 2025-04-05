package co.edu.uptc.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ExitVehicleFrame extends JFrame{
    public ExitVehicleFrame(){
        super(" exit vehicle");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
