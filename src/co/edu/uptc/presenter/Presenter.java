package co.edu.uptc.presenter;

import co.edu.uptc.model.ModelSystem;
import java.util.Date;


public class Presenter {
    private static Presenter presenter;
    private ModelSystem model;
    

    
    public Presenter(){
        this.model = new ModelSystem();
        System.out.println("ModelSystem creado en Presenter!");
    }
    public String exitVehicleAndPrintTicket(String plate){
        return model.processAndSaveTicketExit(plate);
    }
    public int vehicleEntry (){
        return model.vehicleEntry();
    }

    public boolean verifyRol(String user){
        return model.validateRol(user);
    }
    public boolean logIn(String user, String password){
        return model.LogIn(user, password);
    }
     public void setReceptionistTurn(String user){
        model.setReceptionistTurn(user);
    }
    public String getReceptionistTurn(){
        return model.getReceptionistTurn();
    }
    public void changeCrededencialReceptionist(int idDoucment, String newPassword) {
        model.changeCrededencialReceptionist(idDoucment, newPassword);
    }

    public void createParking(String name, String address, int spaces) {
        model.addParking(name, address, spaces);
    }
    public static Presenter getInstance() {
        if (presenter == null) {
            presenter = new Presenter();
            System.out.println("Creo instacia presenter!");
        }
        return presenter;
    }
    public double getTotalPaymentsByDate(Date fechaSeleccionada) {
        return model.getTotalPaymentsByDate(fechaSeleccionada);
    }
    
    
}
