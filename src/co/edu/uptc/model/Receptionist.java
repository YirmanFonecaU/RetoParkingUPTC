package co.edu.uptc.model;

public class Receptionist  extends User{
    private double income;
    private int totalVehiclesEntered;

    public Receptionist(){
        super();
        this.id=id;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.direction = direction;
        this.email = email; 
        
    }
    public int getId() {
        return id;    
    }  
    public void setId(int id) {
        this.id = id;    
    }  
    public String getUserName() {
        return userName;    
    }  
    public void setUserName(String userName) {
        this.userName = userName;    
    }  
    public String getPassword() {
        return password;    
    }  
    public void setPassword(String password) {
        this.password = password;    
    }  
    public int getPhone() {
        return phone;    
    }  
    public void setPhone(int phone) {
        this.phone = phone;    
    }  
    public String getDirection() {
        return direction;    
    }  
    public void setDirection(String direction) {
        this.direction = direction;    
    }  
    public String getEmail() {
        return email;    
    }  
    public void setEmail(String email) {
        this.email = email; 
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
    @Override
    public String toString() {
        return "Receptionist [income=" + income + ", totalVehiclesEntered=" + totalVehiclesEntered + ", account="
                 + "]";
    }
    
    

}
