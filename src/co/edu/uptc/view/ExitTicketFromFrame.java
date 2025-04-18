package co.edu.uptc.view;

import co.edu.uptc.model.Ticket;
import co.edu.uptc.presenter.Presenter;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ExitTicketFromFrame extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel plateLabel;
    private JLabel amountLabel;
    private JLabel amountGivenLabel;
    private JLabel changeLabel;
    private JLabel paymentMethodLabel;
    private JLabel stateLabel;
    private JLabel referenceLabel;
    private JLabel dateLabel;
    private JButton printBotton;
    private JButton finishButton;
    private Presenter presenter;
    private Ticket ticket;
    private String paymentMethod;
    private double amountPaid;
    private double amountGiven;
    private double change;

    public ExitTicketFromFrame(Ticket ticket, double amountPaid,  double amountGiven, double change) {
        super("ParkingUPTC - Recibo Generado");
        this.ticket = ticket;
        this.amountPaid = amountPaid;
        this.paymentMethod = paymentMethod;
        this.amountGiven = amountGiven;
        this.change = change;
        
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants
        .EXIT_ON_CLOSE);
        presenter = Presenter.getInstance();
        
        initComponents();
        setupLayout();
        setVisible(true);
    }

    private void initComponents(){
        titleLabel =new JLabel("¡Proseso de pago finalizado! ", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial",Font.BOLD,18));

        plateLabel = new JLabel("placa: " + ticket.getVehicle().getPlate());
        amountLabel = new JLabel("Valor a pagar: "+ String.format("%.0f", amountPaid));
        amountGivenLabel = new JLabel("Valor pagado: "+ String.format("%.0f", amountGiven));
        changeLabel = new JLabel("Valor devuelto: "+ String.format("%.0f", change));

        stateLabel = new JLabel("Estado: Aprobado");
        referenceLabel = new JLabel("Referencia: " + ticket.getTicketID());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatedDate = ticket.getExitDateTime().format(formatter);
        dateLabel= new JLabel("Fecha de pago: " + formatedDate);

        printBotton = new JButton("Imprimir");
        printBotton.addActionListener(this);

        finishButton = new JButton("Finalizar");
        finishButton.addActionListener(this);

    }

    private void setupLayout(){
        setLayout(new BorderLayout(10,10));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(6,1,5,15));
        detailsPanel.setBorder(BorderFactory.createTitledBorder("Detalles de pago"));

        detailsPanel.add(plateLabel);
        detailsPanel.add(amountLabel);
        detailsPanel.add(amountGivenLabel);
        detailsPanel.add(changeLabel);
        detailsPanel.add(stateLabel);
        detailsPanel.add(referenceLabel);
        detailsPanel.add(dateLabel);

        contentPanel.add(detailsPanel);
        contentPanel.add(Box.createVerticalStrut(20));

        JPanel buttoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
        buttoPanel.add(printBotton);
        buttoPanel.add(finishButton);

        contentPanel.add(buttoPanel);
        add(contentPanel, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()== printBotton) {
       String recibo= presenter.exitVehicleAndPrintTicket(ticket.getVehicle().getPlate());
       JOptionPane.showMessageDialog(this, recibo,"Recibo Generado",JOptionPane.INFORMATION_MESSAGE);
       dispose();
       }
       else if (e.getSource()== finishButton) {
           goToReceptionist();
       }
    }
    private void goToReceptionist(){
        dispose();
        new ReceptionistMenuFrame(presenter.getReceptionistTurn());
    }
     
}