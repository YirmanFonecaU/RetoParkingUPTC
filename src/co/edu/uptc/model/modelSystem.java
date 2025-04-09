package co.edu.uptc.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ModelSystem {

    private List<Parking> parkingList;
    private List<Receptionist> receptionistList;
    protected Map<String, String> account;
    private Receptionist receptionist;
    private Parking currentParking;
    private boolean isLoggendIn;
    private String receptionistTurn;
    private List<Ticket> printedtickets;
    private int totalVehicle;
    private double totalpayments;
    

    private static final Pattern CAR_PLATE_PATTERN = Pattern.compile("^[A-Z]{3}\\d{3}$");
    private static final Pattern MOTORCYCLE_PLATE_PATTERN = Pattern.compile("^[A-Z]{3}\\d{2}[A-Z]$");

    public ModelSystem() {
        parkingList = new ArrayList<Parking>();
        receptionistList = new ArrayList<Receptionist>();
        account= new HashMap<String, String>();
        account.put("admin", "password");
        account.put("key", "value");
        receptionist = new Receptionist();
        account= new HashMap<String, String>();
        printedtickets = new ArrayList<Ticket>();
        
        currentParking = new Parking("ParkingUPTC", "Universidad Pedagógica y Tecnológica de Colombia", 20);
        parkingList.add(currentParking);
        
        isLoggendIn = false;
    }
    
    public void savePrintedTicket(Ticket ticket){
        printedtickets.add(ticket);
    }
    public List<Ticket> getPrintedTickets(){
        return printedtickets;
    }
    public String processAndSaveTicketExit(String plate){
        Ticket ticket = registerVehicleExit(plate);
        if(ticket!=null){
            savePrintedTicket(ticket);
            return ticket.printTicket();
        }
        return JOptionPane.showInputDialog("No se encontro un ticket activo para la placa " + plate, "Error");
    }
    public boolean validateRol(String user){
        boolean validate= false;
        if(user.equals("admin"))
        validate=true;
        return validate;
    }

    public boolean  LogIn(String user, String password) {
        boolean validate = false;
        if (account.containsKey(user)) {
            if (account.get(user).equals(password)) {
                validate = true;
            }
        }
        return validate;
    }

    public void changeCrededencialReceptionist(int idDoucment, String newPassword) {
        for (Receptionist receptionist : receptionistList) {
            if (receptionist.getId() == idDoucment) {
                receptionist.setPassword(newPassword);
            }
        }
    }
    public void createTicket(String plate, String type){
       VehicleType typeVehicle= VehicleType.fromString(type);
        Vehicle vehicle= new Vehicle(plate, typeVehicle);
        addTicket(vehicle);

    }
    private void addTicket( Vehicle vehicle){
        currentParking.createEntryTicket(vehicle);
    }

    public void addReceptionist(int document, String name, String lastName, String email, String phone) {
        String password = "" ;
        String userName = name + " "+ lastName;
        receptionistList.add(new Receptionist(document, userName, password, email, phone));
    }

    public void addParking(String name, String address, int spaces) {
        parkingList.add(new Parking(name, address, spaces));
       
    }
    public boolean validatePlate(String plate, VehicleType type) {
        if (plate == null || plate.trim().isEmpty()) {
            return false;
        }
        
        plate = plate.toUpperCase().trim();
        
        if (type == VehicleType.CAR) {
            return CAR_PLATE_PATTERN.matcher(plate).matches();
        } else {
            return MOTORCYCLE_PLATE_PATTERN.matcher(plate).matches();
        }
    }
    public void logOut() {
        
        isLoggendIn = false;
    }


    public boolean isLoggedIn() {
        return isLoggendIn;
    }
    public Map<VehicleType, Integer> getAvailabilityByType() {
        return currentParking.getAvailabilityByType();
    }
    
    public int getTotalAvailableSpaces() {
        return currentParking.getTotalAvailableSpaces();
    }
    
    public Ticket registerVehicleEntry(String plate, VehicleType type) {
        if (!validatePlate(plate, type)) {
            return null;
        }
        
        if (currentParking.isVehicleParked(plate)) {
            return null; // Vehicle already in parking
        }
        
        if (!currentParking.hasSpace(type)) {
            return null; // No space available
        }
        
        Vehicle vehicle = new Vehicle(plate, type);
        return currentParking.createEntryTicket(vehicle);
    }
    public List<Ticket> getTicketsByDate(Date inputDate) {
        List<Ticket> filtered = new ArrayList<>();
        LocalDate selectedDate = inputDate.toInstant()
                                          .atZone(ZoneId.systemDefault())
                                          .toLocalDate();
    
        for (Ticket ticket : getAllTickets()) {
            if (ticket.getDate().toLocalDate().equals(selectedDate)) {
                filtered.add(ticket);
            }
        }
        return filtered;
    }
        public double getTotalPaymentsByDate(Date targetDate) {
            List<Ticket> filtered = getTicketsByDate(targetDate);
            totalpayments =0;
            for (Ticket ticket : filtered) {
                totalpayments += ticket.getTotalPay();
            }
            return totalpayments;
        }

    public int vehicleEntry(){
        return currentParking.getVehicleEntry();
    }
    
    public Ticket registerVehicleExit(String plate) {
        return currentParking.processExit(plate);
    }
    
    public void setSpaces(VehicleType type, int spaces) {
        currentParking.setSpaces(type, spaces);
    }
    
    public List<Ticket> getAllTickets() {
        return currentParking.getAllTickets();
    }

    
    public Ticket findActiveTicket(String plate) {
        return currentParking.findActiveTicket(plate);
    }
    
    public boolean isLowOnSpaces() {
        return currentParking.getTotalAvailableSpaces() < 5;
    }
    
    public Parking getCurrentParking() {
        return currentParking;
    }
     public String getReceptionistTurn() {
        return receptionistTurn;
    }

    public void setReceptionistTurn(String receptionistTurn) {
        this.receptionistTurn = receptionistTurn;
    }

}
