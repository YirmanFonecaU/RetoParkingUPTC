package co.edu.uptc.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private String name;
    private String address;
    private int spaces;
    private Map<VehicleType, Integer> totalSpacesByType;
    private List<Vehicle> parkedVehicles;
    private List<Ticket> allTickets;
    private List<Ticket> ResiveTickets;
    private int vehicleEntry;
   

    public int getVehicleEntry() {
        return vehicleEntry;
    }

    public void setVehicleEntry(int vehicleEntry) {
        this.vehicleEntry = vehicleEntry;
    }
    private int nextTicketId;

    public Parking(String name, String address, int spaces) {
        this.name = name;
        this.address = address;
        this.totalSpacesByType = new HashMap<>();
        this.spaces = spaces;
        this.totalSpacesByType.put(VehicleType.CAR, spaces/2);
        this.totalSpacesByType.put(VehicleType.MOTORCYCLE, spaces-(spaces/2));
        this.parkedVehicles = new ArrayList<>();
        this.allTickets = new ArrayList<>();
        this.nextTicketId = 1000;
    }
    
    
    public int getTotalSpaces() {
        return totalSpacesByType.values().stream().mapToInt(Integer::intValue).sum();
    }
    
    public int getAvailableSpaces(VehicleType type) {
        int occupied = (int) parkedVehicles.stream()
                .filter(v -> v.getType() == type)
                .count();
        return totalSpacesByType.getOrDefault(type, 0) - occupied;
    }
    
    public int getTotalAvailableSpaces() {
        return getTotalSpaces() - parkedVehicles.size();
    }
    
    public boolean hasSpace(VehicleType vehicleTypetype) {
        return getAvailableSpaces(vehicleTypetype) > 0;
    }
    
    /*public boolean isVehicleParked(String plate) {
        return parkedVehicles.stream()
                .anyMatch(v -> v.getPlate().equalsIgnoreCase(plate));
    }*/
    public boolean isVehicleParked(String plate) {
        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle.getPlate().equalsIgnoreCase(plate)) {
                return true;
            }
        }
        return false;
    }
    
    public Ticket createEntryTicket(Vehicle vehicle) {
        if (!hasSpace(vehicle.getType())) {
            return null;
        }
        
        parkedVehicles.add(vehicle);
        Ticket ticket = new Ticket(nextTicketId++, vehicle, LocalDateTime.now(), LocalDateTime.now());
        allTickets.add(ticket);
        vehicleEntry++;
        nextTicketId++;
        return ticket;
    }
    
    public Ticket findActiveTicket(String plate) {
        return allTickets.stream()
                .filter(t -> t.getVehicle().getPlate().equalsIgnoreCase(plate) && t.getExitDateTime() == null)
                .findFirst()
                .orElse(null);
    }
    
    public Ticket processExit(String plate) {
        Ticket ticket = findActiveTicket(plate);
        if (ticket != null) {
            ticket.checkOut(LocalDateTime.now());
            parkedVehicles.removeIf(v -> v.getPlate().equalsIgnoreCase(plate));
            return ticket;
        }
        return null;
    }
    
    public Map<VehicleType, Integer> getAvailabilityByType() {
        Map<VehicleType, Integer> availability = new HashMap<>();
        for (VehicleType type : VehicleType.values()) {
            availability.put(type, getAvailableSpaces(type));
        }
        return availability;
    }
    
    public void setSpaces(VehicleType type, int spaces) {
        totalSpacesByType.put(type, spaces);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    
    public List<Vehicle> getParkedVehicles() {
        return parkedVehicles;
    }
    
    public List<Ticket> getAllTickets() {
        return allTickets;
    }
    
    public Map<VehicleType, Integer> getTotalSpacesByType() {
        return totalSpacesByType;
    }

    public int getNextTicketId() {
        return nextTicketId;
    }

    
}
