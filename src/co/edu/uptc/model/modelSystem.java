package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelSystem {

    private List<Parking> parkingList;
    private List<Receptionist> receptionistList;
    protected Map<String, String> account;
    private Receptionist receptionist;
    private Parking parking;

    public ModelSystem() {
        parkingList = new ArrayList<Parking>();
        receptionistList = new ArrayList<Receptionist>();
        account= new HashMap<String, String>();
        receptionist = new Receptionist();
        parking = new Parking();
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

}
