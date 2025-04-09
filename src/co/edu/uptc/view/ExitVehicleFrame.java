package co.edu.uptc.view;

import co.edu.uptc.model.Ticket;
import co.edu.uptc.presenter.Presenter;
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
    private Presenter presenter;

    public ExitVehicleFrame() {
        super("Salida de Vehículo");
        presenter= Presenter.getInstance();
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
                String placa = txtPlaca.getText().trim().toUpperCase();
        
                if (placa.isEmpty()) {
                    JOptionPane.showMessageDialog(ExitVehicleFrame.this, "Por favor ingrese la placa.");
                    return;
                }
        
                if (!presenter.vehicleParked(placa)) {
                    JOptionPane.showMessageDialog(ExitVehicleFrame.this, "Placa no encontrada", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
        
                Ticket ticket = presenter.exitVehicleTicket(placa);
                String input = JOptionPane.showInputDialog(
                    ExitVehicleFrame.this,
                    "Su valor a pagar es: $" + ticket.getTotalPay() + "\nIngrese el monto recibido",
                    "Pago",
                    JOptionPane.QUESTION_MESSAGE
                );
        
                if (input == null) {
                    // El usuario canceló el diálogo
                    return;
                }
        
                try {
                    double pago = Double.parseDouble(input);
        
                    if (pago < ticket.getTotalPay()) {
                        JOptionPane.showMessageDialog(
                            ExitVehicleFrame.this,
                            "Monto inferior al solicitado",
                            "Advertencia",
                            JOptionPane.WARNING_MESSAGE
                        );
                        return;
                    }
        
                    double cambio = presenter.change(pago, ticket.getTotalPay());
                    new ExitTicketFromFrame(ticket, ticket.getTotalPay(), pago, cambio);
                    dispose(); // Cierra la ventana actual
        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        ExitVehicleFrame.this,
                        "Ingrese un valor numérico válido",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        

        add(mainPanel, BorderLayout.CENTER);
        add(btnConfirmar, BorderLayout.SOUTH);

        setVisible(true);
    }

}
