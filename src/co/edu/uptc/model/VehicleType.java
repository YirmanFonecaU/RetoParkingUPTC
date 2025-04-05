package co.edu.uptc.model;

public enum VehicleType {
    CAR("Carro"),
    MOTORCYCLE("Moto");
    
    private String displayName;
    
    VehicleType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public static VehicleType fromString(String text) {
        for (VehicleType type : VehicleType.values()) {
            if (type.displayName.equalsIgnoreCase(text)) {
                return type;
            }
        }
        return CAR; 
    }
}
