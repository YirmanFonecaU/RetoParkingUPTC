package co.edu.uptc.model;

public class Vehicle {
    private String plate;
    private VehicleType type;
    
    public Vehicle(String plate, VehicleType type) {
        this.plate = plate;
        this.type = type;
    }

    public String getPlate() {
        return plate;
    }
    
    public VehicleType getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return "Vehicle [plate=" + plate + ", type=" + type + "]";
    }
}
