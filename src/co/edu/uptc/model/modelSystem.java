package co.edu.uptc.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ModelSystem {

    private List<Parking> parkingList;
    private List<Receptionist> receptionistList;
    protected Map<String, String> account;
    private Receptionist receptionist;
    private Parking currentParking;
    private boolean isLoggendIn;
    private String receptionistTurn;

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

        currentParking = new Parking("ParkingUPTC", "Universidad Pedagógica y Tecnológica de Colombia");
        parkingList.add(currentParking);
        
        isLoggendIn = false;
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

    public void addReceptionist(Receptionist receptionist) {
        receptionistList.add(receptionist);
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
