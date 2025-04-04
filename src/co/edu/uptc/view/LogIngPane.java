package co.edu.uptc.view;

import co.edu.uptc.presenter.Presenter;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LogIngPane extends JFrame implements ActionListener {

    Presenter presenter;
    private JButton button;
    private JTextField txtUser;
    private JPasswordField txtPassword;

    public LogIngPane() {
        super("LOG IN");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createTitledBorder("LOG IN"));
        GridBagConstraints innergbc = new GridBagConstraints();
        innergbc.insets = new Insets(15, 15, 15, 15);
        innergbc.fill = GridBagConstraints.HORIZONTAL;
        innergbc.gridx = 0;
        innergbc.gridy = 0;

        mainPanel.add(new JLabel("Usuario :"));
        txtUser = new JTextField();
        txtUser.setToolTipText("Ingrese su usuario");
        innergbc.gridx = 1;
        mainPanel.add(txtUser, innergbc);
        innergbc.gridx = 0;
        innergbc.gridy = 1;
        mainPanel.add(new JLabel("Contraseña:"), innergbc);
        txtPassword = new JPasswordField(15);
        innergbc.gridx = 1;
        mainPanel.add(txtPassword, innergbc);
        gbc.gridy = 1;
        add(mainPanel, gbc);
        add(new JSeparator(), gbc);
        JPanel buttoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        button = new JButton("Enviar");
        buttoPanel.add(button);
        gbc.gridy = 3;
        button.addActionListener(this);
        getContentPane().add(buttoPanel, gbc);
        presenter = Presenter.getInstance();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            
                boolean isAdmin = presenter.verifyRol(txtUser.getText());
                boolean isValidLogin = presenter.logIn(txtUser.getText(), new String(txtPassword.getPassword()));
        
                if (isValidLogin) {
                    // Abrir el menú correspondiente
                    if (isAdmin) {
                        new AdministrationMenuFrame(); // Asegúrate que sea visible dentro del constructor
                    } else {
                        new ReceptionistMenuFrame();
                    }
                    // Cerrar ventana de login
                    dispose(); // Cierra la ventana actual
                } else {
                    JOptionPane.showMessageDialog(button, "Usuario o contraseña incorrectos");
                }
            }
    }

}
