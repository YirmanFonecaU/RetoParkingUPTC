package co.edu.uptc.model;

import java.time.LocalDateTime;
import java.util.List;

public class Receptionist  extends User{
    private double income;
    private int totalVehiclesEntered;
    private double totalIngress;
    private int totalVehicles;
    private List<ReceptionistReport> report;
    public Receptionist(){
        income=0;
        totalVehiclesEntered=0;
        totalIngress=0;
      totalVehicles=0;  
    }

    public Receptionist(int id, String userName, String password, String direcction, String email){
        super();
        this.id=0;
        this.userName = "";
        this.password = password;
        this.phone = phone;
        this.direction = direction;
        this.email = email; 
        
        
    }
    public ReceptionistReport generateReport(){
        User receptionist= new User();
        ReceptionistReport reportRecep= new ReceptionistReport(receptionist, totalVehicles, totalIngress,LocalDateTime.now());
        report.add(reportRecep);
        return reportRecep;
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
    public double getTotalIngress() {
        return totalIngress;
    }
    public void setTotalIngress(double totalIngress) {
        this.totalIngress = totalIngress;
    }
    public int getTotalVehicles() {
        return totalVehicles;
    }
    public void setTotalVehicles(int totalVehicles) {
        this.totalVehicles = totalVehicles;
    }
    public List<ReceptionistReport> getReport() {
        return report;
    }
    public void setReport(List<ReceptionistReport> report) {
        this.report = report;
    }
    
    

}
