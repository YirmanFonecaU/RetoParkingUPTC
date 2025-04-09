package co.edu.uptc.view;
import co.edu.uptc.model.ReceptionistReport;
import co.edu.uptc.presenter.Presenter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
public class AdministrationMenuFrame extends JFrame implements ActionListener {  
    private JButton addParkingButton;
    private JLabel closeSessionLabel;
    private JButton addReceptioinistButton;
    private JButton changePasswordButton;
    private JButton generateReport;
    private JButton registerButtonParking;
    private JButton registerButtonReceptionist;
    private JButton saveButton;
    private JPanel southPanel;
    private JPanel centerPanel;
    private JPanel addParkingPanel;
    private JPanel addReceptioinistPanel;
    private JPanel changePasswordPanel;
    private JPanel generateReportPanel;
    private Presenter presenter;
    private JSpinner fecha;
    private JPanel panelReport;
    private JLabel nameLabel;
    private JTextField nameField ;
    private JLabel addressLabel;
    private JTextField addressField ;
    private JLabel spacesLabel;
    private JTextField spacesField ;
    private JLabel documentLabel;
    private JTextField documentField;
    private JLabel nameLabelRecJLabel;
    private JTextField nameFieldRec;
    private JLabel addressLabelRec;
    private JTextField addressFieldRec;
    private JLabel lastNameLabelRec;
    private JTextField lastNameFieldRec;
    private JLabel numberPhoneLabelRec;
    private JTextField numberPhoneFieldRec;
    private JButton generateButton;
    private JLabel emailLabelRec;
    private JTextField emailFieldRec;
    private JTextField newPasswordField;
    private JTextField repeatPasswordField;
    private double totalIngresosL;
    private JLabel dateLabel;
    private JLabel totalVehicleIngrLabel;

    public AdministrationMenuFrame() {
        super("Menú Administración");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        presenter = Presenter.getInstance();
        setLayout(new BorderLayout());
        fecha = new JSpinner();
        southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        closeSession();
        centerPanel = new JPanel(new GridLayout(1, 2)); 
        leftCenterPanel();
        rightCenterPanel(); 
        
        getContentPane().add(southPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);

        setVisible(true);

    }

    private void closeSession() {
        closeSessionLabel = new JLabel("← Cerrar Sesión");
        closeSessionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        closeSessionLabel.setForeground(Color.BLUE);
        closeSessionLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeSessionLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        closeSessionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            new LogIngPane();
            }
        });
        southPanel.add(closeSessionLabel);
    }

    private void leftCenterPanel() {
       
        JPanel leftPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        gbc.fill = GridBagConstraints.BOTH;

        addParkingButton = new JButton("Añadir Parking");
        gbc.gridx = 0;
        gbc.gridy = 1; 
        gbc.weighty = 1; 
        addParkingButton.addActionListener(this);
        leftPanel.add(addParkingButton, gbc);

        addReceptioinistButton = new JButton("Añadir Receptionista");
        gbc.gridy = 2; 
        addReceptioinistButton.addActionListener(this);
        leftPanel.add(addReceptioinistButton, gbc);

        changePasswordButton = new JButton("Cambiar Contraseña");
        gbc.gridy = 3; 
        changePasswordButton.addActionListener(this);
        leftPanel.add(changePasswordButton, gbc);

        generateReport = new JButton("Generar Reporte");
        gbc.gridy = 4; 
        generateReport.addActionListener(this);
        leftPanel.add(generateReport, gbc);

        centerPanel.add(leftPanel);
    }

    private void rightCenterPanel() {
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS)); 
    
        ImageIcon imagen = new ImageIcon("src/resources/ParkingImagen.png");
        Image img = imagen.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon = new ImageIcon(img);
        
        JLabel imagenParking = new JLabel(scaledIcon);
        imagenParking.setAlignmentX(Component.CENTER_ALIGNMENT); 
    
        JLabel title = new JLabel("Parqueadero UPTC");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT); 
    
        rightPanel.add(Box.createVerticalGlue()); 
        rightPanel.add(imagenParking);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        rightPanel.add(title);
        rightPanel.add(Box.createVerticalGlue()); 
    
        centerPanel.add(rightPanel);
    }

   private JPanel addParkingPanel(){
       JPanel addParkingPanel = new JPanel();
       this.setSize(800, 500); 
       getContentPane().removeAll();
       getContentPane().add(addParkingPanel);
       getContentPane().revalidate();
       getContentPane().repaint();
       addParkingPanel.setLayout(new BorderLayout());
       JPanel formPanel = new JPanel(new GridBagLayout());
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.insets = new Insets(10, 10, 10, 10);
       gbc.fill = GridBagConstraints.HORIZONTAL;

       nameLabel = new JLabel("Nombre del Parqueadero:");
        nameField = new JTextField(20);
       addressLabel = new JLabel("Dirección:");
       addressField = new JTextField(20);
       spacesLabel = new JLabel("Números de espacios disponibles:");
       spacesField = new JTextField(20);

       JLabel scheduleLabel = new JLabel("Horario de Atención:");
       String[] scheduleOptions = {
           "lunes-viernes [ 8:00 am ] - [ 7:00 pm ]",
           "Sábado [ 8:00 am ] - [ 11:00 pm ]",
           "Domingos-Festivos [ 8:00 am ] - [ 9:00 pm ]"};
       JComboBox<String> scheduleBox = new JComboBox<>(scheduleOptions);
       scheduleBox.setPreferredSize(new Dimension(300, 60));
       scheduleBox.setMaximumRowCount(5);
       JLabel titleLabel = new JLabel("Digite los datos para registrar el Parqueadero", JLabel.CENTER);
       titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
       gbc.gridx = 1;
       gbc.gridy = 0;
       formPanel.add(titleLabel, gbc);

        registerButtonParking = new JButton("Registrar Parqueadero");
        registerButtonParking.addActionListener(this);
       

       gbc.gridx = 0;
       gbc.gridy++;
       formPanel.add(nameLabel, gbc);
       gbc.gridx = 1;
       formPanel.add(nameField, gbc);

       gbc.gridx = 0;
       gbc.gridy++;
       formPanel.add(addressLabel, gbc);
       gbc.gridx = 1;
       formPanel.add(addressField, gbc);

       gbc.gridx = 0;
       gbc.gridy++;
       formPanel.add(spacesLabel, gbc);
       gbc.gridx = 1;
       formPanel.add(spacesField, gbc);

       gbc.gridx = 0;
       gbc.gridy++;
       formPanel.add(scheduleLabel, gbc);
       gbc.gridx = 1;
       formPanel.add(scheduleBox, gbc);

       gbc.gridx = 0;
       gbc.gridy++;
       gbc.gridwidth = 2;
       gbc.anchor = GridBagConstraints.CENTER;
       formPanel.add(registerButtonParking, gbc);

       add(formPanel, BorderLayout.CENTER);
       
       JLabel backToMenu = new JLabel("← Volver al Menú");
       backToMenu.setFont(new Font("Arial", Font.PLAIN, 14));
       backToMenu.setForeground(Color.BLUE);
       backToMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       backToMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       backToMenu.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent evt) {
            
            getContentPane().removeAll();
            getContentPane().add(southPanel);
            getContentPane().add(centerPanel);
            getContentPane().revalidate();
            getContentPane().repaint();
           }
       });
       add(backToMenu, BorderLayout.NORTH);
       
    
       return addParkingPanel;
   }


   private JPanel addReceptionistJPanel() {
    JPanel addReceptionistPanel = new JPanel();
    this.setSize(800, 500);
    getContentPane().removeAll();
    getContentPane().add(addReceptionistPanel);
    getContentPane().revalidate();
    getContentPane().repaint();
    addReceptionistPanel.setLayout(new BorderLayout());
    JPanel wrapperPanel = new JPanel(new BorderLayout());
    JPanel formPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel titleLabel = new JLabel("Digite los datos para crear al Recepcionista", JLabel.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.CENTER;
    formPanel.add(titleLabel, gbc);

    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.WEST;

    gbc.gridy++;
    gbc.gridx = 0;
    documentLabel= new JLabel("Documento de identidad:");
    formPanel.add(documentLabel, gbc);
    gbc.gridx = 1;
    gbc.weightx = 1.0;
    documentField = new JTextField(20);
    formPanel.add(documentField, gbc);

    gbc.gridy++;
    gbc.gridx = 0;
    nameLabelRecJLabel=new JLabel("Nombres:");
    formPanel.add(nameLabelRecJLabel, gbc);
    gbc.gridx = 1;
    nameFieldRec = new JTextField(20);
    formPanel.add(nameFieldRec, gbc);

    gbc.gridy++;
    gbc.gridx = 0;
    lastNameLabelRec = new JLabel("Apellidos:");
    formPanel.add(lastNameLabelRec, gbc);
    gbc.gridx = 1;
    lastNameFieldRec = new JTextField(20);
    formPanel.add(lastNameFieldRec, gbc);

    gbc.gridy++;
    gbc.gridx = 0;
    numberPhoneLabelRec = new JLabel("Número de Teléfono:");
    formPanel.add(numberPhoneLabelRec, gbc);
    gbc.gridx = 1;
    numberPhoneFieldRec = new JTextField(20);
    formPanel.add(numberPhoneFieldRec, gbc);

    gbc.gridy++;
    gbc.gridx = 0;
    addressLabelRec=new JLabel("Dirección:");
    formPanel.add(addressLabelRec, gbc);
    gbc.gridx = 1;
    addressFieldRec = new JTextField(20);
    formPanel.add(addressFieldRec, gbc);

    gbc.gridy++;
    gbc.gridx = 0;
    emailLabelRec = new JLabel("E-mail:");
    formPanel.add(emailLabelRec, gbc);
    gbc.gridx = 1;
    emailFieldRec = new JTextField(20);
    formPanel.add(emailFieldRec, gbc);

    registerButtonReceptionist = new JButton("Registrar Recepcionista");
    registerButtonReceptionist.addActionListener(this);
    gbc.gridy++;
    gbc.gridx = 0;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.CENTER;
    formPanel.add(registerButtonReceptionist, gbc);

    wrapperPanel.add(Box.createHorizontalStrut(100), BorderLayout.WEST);
    wrapperPanel.add(Box.createHorizontalStrut(100), BorderLayout.EAST);
    wrapperPanel.add(formPanel, BorderLayout.CENTER);

    addReceptionistPanel.add(wrapperPanel, BorderLayout.CENTER);

    JLabel backToMenu = new JLabel("← Volver al Menú");
    backToMenu.setFont(new Font("Arial", Font.PLAIN, 14));
    backToMenu.setForeground(Color.BLUE);
    backToMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    backToMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    backToMenu.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            getContentPane().removeAll();
            getContentPane().add(southPanel);
            getContentPane().add(centerPanel);
            getContentPane().revalidate();
            getContentPane().repaint();
        }
    });

    addReceptionistPanel.add(backToMenu, BorderLayout.NORTH);

    return addReceptionistPanel;
}

private JPanel changePasswordPanel() {
    JPanel mainPanel = new JPanel(new BorderLayout());
    this.setSize(800, 500);
    getContentPane().removeAll();
    getContentPane().add(mainPanel);
    getContentPane().revalidate();
    getContentPane().repaint();

    JPanel wrapperPanel = new JPanel(new BorderLayout());
    JPanel formPanel = new JPanel(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

  
    JLabel title = new JLabel("Digite los siguientes datos para cambiar la credencial:");
    title.setFont(new Font("Arial", Font.BOLD, 18));
    title.setHorizontalAlignment(SwingConstants.CENTER);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.CENTER;
    formPanel.add(title, gbc);

    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.WEST;

    gbc.gridy++;
    gbc.gridx = 0;
    documentLabel =new JLabel("Documento de Identidad:");
    formPanel.add(documentLabel, gbc);
    gbc.gridx = 1;
    documentField = new JPasswordField(20);
    formPanel.add(documentField, gbc);

    gbc.gridy++;
    gbc.gridx = 0;
    formPanel.add(new JLabel("Nueva Contraseña:"), gbc);
    gbc.gridx = 1;
    newPasswordField = new JPasswordField(20);
    formPanel.add(newPasswordField, gbc);

    gbc.gridy++;
    gbc.gridx = 0;
    formPanel.add(new JLabel("Repetir Nueva Contraseña:"), gbc);
    gbc.gridx = 1;
    repeatPasswordField = new JPasswordField(20);
    formPanel.add(repeatPasswordField, gbc);

    gbc.gridy++;
    gbc.gridx = 0;
    gbc.gridwidth = 2;
    JLabel note = new JLabel("* La contraseña debe ser sin caracteres especiales y de 8 dígitos");
    note.setFont(new Font("Arial", Font.PLAIN, 12));
    note.setForeground(Color.RED);
    formPanel.add(note, gbc);

    gbc.gridy++;
    saveButton = new JButton("Guardar Cambios");
    saveButton.addActionListener(this); 
    formPanel.add(saveButton, gbc);

    wrapperPanel.add(Box.createHorizontalStrut(100), BorderLayout.WEST);
    wrapperPanel.add(Box.createHorizontalStrut(100), BorderLayout.EAST);
    wrapperPanel.add(formPanel, BorderLayout.CENTER);
    mainPanel.add(wrapperPanel, BorderLayout.CENTER);

    JLabel backLabel = new JLabel("← Volver al Menú");
    backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    backLabel.setForeground(Color.BLUE);
    backLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    backLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            getContentPane().removeAll();
            getContentPane().add(southPanel);
            getContentPane().add(centerPanel);
            getContentPane().revalidate();
            getContentPane().repaint();
        }
    });
    mainPanel.add(backLabel, BorderLayout.NORTH);

    return mainPanel;
}
private JPanel generateReportPanel() {
    panelReport = new JPanel(new BorderLayout());
    this.setSize(800, 500);
    getContentPane().removeAll();
    getContentPane().add(panelReport);
    getContentPane().revalidate();
    getContentPane().repaint();

    JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));

    JLabel label = new JLabel("Digite la fecha para la generación del reporte:");
    
    JLabel calendarIcon = new JLabel("📅");
    generateButton = new JButton("Generar");
    generateButton.addActionListener(this);
    Calendar calendar = Calendar.getInstance();

    Date inicio = calendar.getTime();

        calendar.add(Calendar.YEAR, -100);
        Date fechaAnterior = calendar.getTime();

        calendar.add(Calendar.YEAR, 200);
        Date fechaPosterior = calendar.getTime();

        SpinnerModel fechaModel = new SpinnerDateModel(inicio, fechaAnterior, fechaPosterior, Calendar.YEAR);
        fecha.setModel(fechaModel);
        fecha.setEditor(new JSpinner.DateEditor(fecha, "dd/MM/yyyy"));

    center.add(label);
    center.add(fecha);
    center.add(calendarIcon);
    center.add(generateButton);

    panelReport.add(center, BorderLayout.SOUTH);
    JLabel backLabel = new JLabel("← Volver al Menú");
    backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    backLabel.setForeground(Color.BLUE);
    backLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    backLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            getContentPane().removeAll();
            getContentPane().add(southPanel);
            getContentPane().add(centerPanel);
            getContentPane().revalidate();
            getContentPane().repaint();
        }
    });
    panelReport.add(backLabel, BorderLayout.NORTH);
    return panelReport;
}

public void panelReport2() {
    Date fechaSeleccionada = (Date) fecha.getValue();
    totalIngresosL = presenter.getTotalPaymentsByDate(fechaSeleccionada);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String fechaFormateada = sdf.format(fechaSeleccionada);

    JPanel reportTotalIngresosPanel = new JPanel();
    reportTotalIngresosPanel.setLayout(new BoxLayout(reportTotalIngresosPanel, BoxLayout.Y_AXIS));
    reportTotalIngresosPanel.setBorder(BorderFactory.createTitledBorder("Reporte de ingresos"));

    JLabel itemLabel = new JLabel("<html>" +
        "Fecha: " + fechaFormateada + "<br>" +
        "Total ingresos: $" + totalIngresosL + "<br>" +
        "Total de vehículos ingresados: " + presenter.vehicleEntry());
    reportTotalIngresosPanel.add(itemLabel);
    String[] columnNames = {"Recepcionista", "Vehículos", "Ingresos", "Fecha"};
    List<ReceptionistReport> reportList = presenter.getReceptionistReportList();

    Object[][] data = new Object[reportList.size()][4];
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    for (int i = 0; i < reportList.size(); i++) {
        ReceptionistReport report = reportList.get(i);
        data[i][0] = report.getReceptionist();
        data[i][1] = report.getTotalVehicles();
        data[i][2] = "$" + report.getTotalIngress();
        data[i][3] = report.getEntryDateTime().format(formatter);
    }

JTable table = new JTable(data, columnNames);
JScrollPane scrollPane = new JScrollPane(table);
reportTotalIngresosPanel.add(scrollPane);

JPanel panel = new JPanel(new BorderLayout());
panel.setBorder(BorderFactory.createTitledBorder("Reporte de recepcionistas"));
panel.add(scrollPane, BorderLayout.CENTER);
    panelReport.add(reportTotalIngresosPanel, BorderLayout.CENTER);
}


    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == addParkingButton){
        addParkingPanel();
    }
    if(e.getSource() == addReceptioinistButton){
        addReceptionistJPanel();
    }
    if(e.getSource() == changePasswordButton){
        changePasswordPanel();
    }
    if(e.getSource() == generateReport){
        generateReportPanel();
    }
    if(e.getSource() == registerButtonParking){
        presenter.createParking(nameField.getText(), addressField.getText(), Integer.parseInt(spacesField.getText()));
        JOptionPane.showMessageDialog(registerButtonParking, "El parqueadero ha sido registrado Exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
    }
    if(e.getSource() == generateButton){
        generateReportPanel();
        panelReport2();
    }
    if(e.getSource() == closeSessionLabel){
        dispose();
    }
    if(e.getSource() == registerButtonReceptionist){
        JOptionPane.showMessageDialog(registerButtonReceptionist, "El receptionista ha sido registrado Exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
    } 
    if(e.getSource() == saveButton){

        if(newPasswordField.getText().equals(repeatPasswordField.getText())){
            presenter.changeCrededencialReceptionist(Integer.parseInt(documentField.getText()), newPasswordField.getText());
            JOptionPane.showMessageDialog(saveButton, "La contraseña se ha cambiado exitosamente", "Cambio Realizados", JOptionPane.INFORMATION_MESSAGE); 
        }else{
            JOptionPane.showMessageDialog(saveButton, "Las contraseñas no coinciden. Intente nuevamente", "Cambio no Realizado", JOptionPane.INFORMATION_MESSAGE); 
        }
    }
  
    }
   
}


