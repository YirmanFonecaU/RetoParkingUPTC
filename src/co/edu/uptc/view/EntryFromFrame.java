package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import co.edu.uptc.presenter.Presenter;

public class EntryFromFrame extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JComboBox<String> vehicleTypeCombo;
    private JTextField plateField;
    private JButton registerButton, cancelButton;
    private Presenter presenter;


    public EntryFromFrame() {
        super("Registrar Entrada");
        setSize(480, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        presenter = Presenter.getInstance();

        titleLabel = new JLabel("INGRESO DE VEHÍCULO", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Tipo de Vehículo:"));
        vehicleTypeCombo = new JComboBox<>(new String[]{"CARRO", "MOTO"});
        formPanel.add(vehicleTypeCombo);

        formPanel.add(new JLabel("Placa del Vehículo:"));
        plateField = new JTextField();
        formPanel.add(plateField);

        registerButton = new JButton("REGISTRAR ENTRADA");
        cancelButton = new JButton("Cancelar");
        registerButton.addActionListener(this);
        cancelButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(registerButton);
        buttonPanel.add(cancelButton);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String tipo = (String) vehicleTypeCombo.getSelectedItem();
            String placa = plateField.getText();
            if (placa.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese la placa", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Vehículo registrado exitosamente");
                dispose();
                //agregar
                // presenter.mostrarTicketEntrada(placa, tipo);
            }
        } else if (e.getSource() == cancelButton) {
            dispose();
        }

    }
}