package co.edu.uptc.view;
import co.edu.uptc.presenter.Presenter;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class IngressVehicleFrame extends JFrame implements ActionListener {

    private JTextField txtPlate;
    private JRadioButton rbtnAuto;
    private JRadioButton rbtnMoto;
    private JButton confirmBtn, backBtn;
    private Presenter presenter;

    public IngressVehicleFrame() {
        super("Ingreso de Vehículo");
        presenter = Presenter.getInstance();

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel superior con botón de volver
        JPanel topPanel = new JPanel(new BorderLayout());
        backBtn = new JButton("◄");
        backBtn.setFocusable(false);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backBtn.addActionListener(this);
        topPanel.add(backBtn, BorderLayout.WEST);
        getContentPane().add(topPanel, BorderLayout.NORTH);

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Campo para la placa
        txtPlate = new JTextField();
        txtPlate.setToolTipText("Ingrese la placa del vehículo");
        mainPanel.add(new JLabel("Placa del vehículo:"));
        mainPanel.add(txtPlate);

        // Radio buttons para tipo de vehículo
        JPanel radioPanel = new JPanel(new FlowLayout());
        rbtnAuto = new JRadioButton("carro");
        rbtnMoto = new JRadioButton("Moto");
        ButtonGroup grupoVehiculo = new ButtonGroup();
        grupoVehiculo.add(rbtnAuto);
        grupoVehiculo.add(rbtnMoto);
        radioPanel.add(rbtnAuto);
        radioPanel.add(rbtnMoto);
        mainPanel.add(new JLabel("Tipo de vehículo:"));
        mainPanel.add(radioPanel);

        // Botón de confirmar
        confirmBtn = new JButton("Confirmar");
        confirmBtn.setFocusable(false);
        confirmBtn.addActionListener(this);

        // Agregamos los paneles
        add(mainPanel, BorderLayout.CENTER);
        add(confirmBtn, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == backBtn) {
            new ReceptionistMenuFrame(presenter.getReceptionistTurn());
            dispose();
        } else if (source == confirmBtn) {
            String plate = txtPlate.getText().trim();
            String vehicleTipe = rbtnAuto.isSelected() ? "Carro"
                    : rbtnMoto.isSelected() ? "Moto" : "";
                    if(plate.isEmpty() || vehicleTipe.isEmpty()){
                        JOptionPane.showMessageDialog(this, "Por favor igrese todos los datos");
                    }else{
                        JOptionPane.showMessageDialog(this, "Vehículo registrado:\nPlaca: " + plate + "\nTipo: " + vehicleTipe);

                        new ReceptionistMenuFrame(presenter.getReceptionistTurn());
                        dispose();
                    }
        }
    }

    

}
