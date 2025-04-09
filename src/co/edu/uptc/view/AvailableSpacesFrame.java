package co.edu.uptc.view;

import co.edu.uptc.presenter.Presenter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class AvailableSpacesFrame extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JTable spacesTable;
    private JButton backButton;
    private Presenter presenter;

    public AvailableSpacesFrame() {
        super("Espacios Disponibles");
        setSize(480, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        presenter = Presenter.getInstance();

        titleLabel = new JLabel("ESPACIOS DISPONIBLES", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        String[] columnNames = {"TIPO", "DISPONIBLES"};
        Object[][] data = {
                {"CARRO", presenter.minorSpaces("carro")},
                {"MOTO", presenter.minorSpaces("moto")},
        };
        spacesTable = new JTable(data, columnNames);
        spacesTable.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(spacesTable);

        backButton = new JButton("Volver al menú");
        backButton.addActionListener(this);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            // presenter.volverMenu();
        }
    }
}


    


