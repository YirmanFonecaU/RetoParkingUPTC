package co.edu.uptc.model;

public class Receptionist  extends User{
    private double income;
    private int totalVehiclesEntered;
    public Receptionist(){
        super();
        
    }
    public double getIncome() {
        return income;
    }
    public void setIncome(double income) {
        this.income = income;
    }
    public int getTotalVehiclesEntered() {
        return totalVehiclesEntered;
    }
    public void setTotalVehiclesEntered(int totalVehiclesEntered) {
        this.totalVehiclesEntered = totalVehiclesEntered;
    }
    

}
