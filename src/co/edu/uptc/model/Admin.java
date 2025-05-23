
package co.edu.uptc.model;


import co.edu.uptc.model.Parking;
import co.edu.uptc.model.Receptionist;
import co.edu.uptc.model.User;
import java.util.ArrayList;
import java.util.List;


public class Admin extends User{
    private List<Parking> parkingList;
    private List<Receptionist> receptionistList;
    
    
    public Admin(){
        this.id=id;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.direction = direction;
        this.email = email; 
        parkingList = new ArrayList<Parking>();
        receptionistList = new ArrayList<Receptionist>();
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
        public String toString(){
            return "ID: "+id+"\n"+"Username: "+userName+"\n"+"Password: "+password+"\n"+"Phone: "+phone+"\n"+"Direction: "+direction+"\n"+"Email: "+email;  
        }
        public List<Parking> getParkingList() {
            return parkingList;
        }
        public void setParkingList(List<Parking> parkingList) {
            this.parkingList = parkingList;
        }
        public List<Receptionist> getReceptionistList() {
            return receptionistList;
        }
        public void setReceptionistList(List<Receptionist> receptionistList) {
            this.receptionistList = receptionistList;
        }
        
 }

