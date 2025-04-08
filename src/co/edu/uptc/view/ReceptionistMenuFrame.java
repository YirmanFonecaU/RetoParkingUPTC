package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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
import javax.swing.event.MouseInputListener;

public class ReceptionistMenuFrame extends JFrame implements MouseInputListener {
    private JLabel lblLogOut;

    public ReceptionistMenuFrame(String user) {
        super("Receptionist Menu");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        
        JLabel lblName = new JLabel(user);
        lblName.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.add(lblName, BorderLayout.EAST);

        JLabel lblTitle = new JLabel("MENU RECEPCIONISTA", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(lblTitle, BorderLayout.CENTER);

        lblLogOut = new JLabel("<HTML><U>Cerrar sesión</U></HTML>");
        lblLogOut.setForeground(Color.BLUE);
        lblLogOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblLogOut.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        lblLogOut.addMouseListener(this);
        topPanel.add(lblLogOut, BorderLayout.WEST);

        getContentPane().add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        centerPanel.add(createOptionPanel("Ingreso de vehículo", "vehicleIngress.png", IngressVehicleFrame.class));
        centerPanel.add(createOptionPanel("Salida de vehículo", "vehicleExit.png", ExitVehicleFrame.class));
        centerPanel.add(createOptionPanel("Espacios Disponibles", "vehicleSpaces.png", AvailableSpacesFrame.class));
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createOptionPanel(String text, String imagePath, Class<?> destinationClass) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setOpaque(false);

        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/assets/" + imagePath));
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
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lblLogOut){
            new LogIngPane();
            dispose();
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}

    
    
}

