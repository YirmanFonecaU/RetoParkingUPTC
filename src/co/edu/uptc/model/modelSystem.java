package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.List;

public class modelSystem {
    private List<Parking> parkingList;
    private List<Receptionist> receptionistList;
    private Receptionist receptionist;
    private Parking parking;
    public modelSystem(){
        parkingList = new ArrayList<Parking>();
        receptionistList = new ArrayList<Receptionist>();
        receptionist = new Receptionist();
        parking = new Parking();
    }

    public void changeCrededencialReceptionist(int idDoucment, String newPassword){
        for(Receptionist receptionist : receptionistList){
            if(receptionist.getId() == idDoucment){
                receptionist.setPassword(newPassword);
            }
        }
    }
    public void addReceptionist(Receptionist receptionist){
       receptionistList.add(receptionist);
    }


}