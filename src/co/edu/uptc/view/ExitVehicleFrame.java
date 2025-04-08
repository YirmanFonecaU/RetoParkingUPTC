package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExitVehicleFrame extends JFrame{
    private JTextField txtPlaca;
    private JButton btnConfirmar;

    public ExitVehicleFrame() {
        super("Salida de Vehículo");

        setSize(350, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel principal
        JPanel mainPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Campo para ingresar la placa
        txtPlaca = new JTextField();
        txtPlaca.setToolTipText("Ingrese la placa del vehículo");
        mainPanel.add(new JLabel("Placa del vehículo:"));
        mainPanel.add(txtPlaca);

        // Botón para confirmar salida
        btnConfirmar = new JButton("Confirmar salida");
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText();

                if (placa.isEmpty()) {
                    JOptionPane.showMessageDialog(ExitVehicleFrame.this, "Por favor ingrese la placa.");
                } else {
                    JOptionPane.showMessageDialog(ExitVehicleFrame.this, "Salida registrada para placa: " + placa);
                    dispose(); // cerrar ventana luego de confirmar
                }
            }
        });

        add(mainPanel, BorderLayout.CENTER);
        add(btnConfirmar, BorderLayout.SOUTH);

        setVisible(true);
    }

}
