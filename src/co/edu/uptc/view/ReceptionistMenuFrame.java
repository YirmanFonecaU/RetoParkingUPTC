package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ReceptionistMenuFrame extends JFrame {

    public ReceptionistMenuFrame() {
        super("Receptionist Menu");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblLogOut = new JLabel("<HTML><U>Cerrar sesion</U></HTML>");
        lblLogOut.setForeground(Color.blue);
        lblLogOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblLogOut.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new LogIngPane();
                dispose();
            }
        });

        topPanel.add(lblLogOut);
        getContentPane().add(topPanel, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        JPanel ingressPanel= createOptionPanel("Ingreso de vehiculo", "vehicleIngress.png", IngressVehicleFrame.class);
        JPanel exitVehicle= createOptionPanel("Salida de vehiculo", "vehicleExit.png", ExitVehicleFrame.class);
        JPanel availableSpaces= createOptionPanel("Espacios Disponibles", "vehicleSpaces.png", AvailableSpacesFrame.class);
        centerPanel.add(ingressPanel);
        centerPanel.add(exitVehicle);
        centerPanel.add(availableSpaces);
        add(centerPanel,BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel createOptionPanel(String text, String imagePath, Class<?> destinationClass) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setOpaque(false);

        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/assets/"+imagePath));
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                openClass(destinationClass);
            }
        });
        JButton button = new JButton(text);
        button.addActionListener(e -> openClass(destinationClass));
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        return panel;
    }
    private void openClass(Class<?> clase) {
        try {
            JFrame nuevaVentana = (JFrame) clase.getDeclaredConstructor().newInstance();
            nuevaVentana.setVisible(true);
            dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al abrir " + clase.getSimpleName());
        }
    }
    
}
