package co.edu.uptc.presenter;

import java.util.Date;

import co.edu.uptc.model.ModelSystem;
import co.edu.uptc.model.Ticket;

public class Presenter {

    private static Presenter presenter;
    private ModelSystem model;

    public Presenter() {
        this.model = new ModelSystem();
        System.out.println("ModelSystem creado en Presenter!");
    }

    public String exitVehicleAndPrintTicket(String plate) {
        return model.processAndSaveTicketExit(plate);
    }
    public int vehicleEntry (){
        return model.vehicleEntry();
    }

    public boolean verifyRol(String user) {
        return model.validateRol(user);
    }
    public void createParking(String name, String address, int spaces){
        model.createParking(name, address, spaces);
    }

    public boolean logIn(String user, String password) {
        return model.LogIn(user, password);
    }

    public void setReceptionistTurn(String user) {
        model.setReceptionistTurn(user);
    }

    public String getReceptionistTurn() {
        return model.getReceptionistTurn();
    }

    public int getNextTickedId() {
        return model.getNextTickedId();
    }

    public Ticket createTicked(String plate, String type) {
        return model.createTicket(plate, type);
    }

    public boolean validatePlate(String plate) {
        return model.validatePlate(plate);
    }

    public boolean vehicleParked(String plate) {
        return model.vehicleParked(plate);
    }

    public boolean spaces(String type) {
        return model.spaces(type);
    }

    public int minorSpaces(String type) {
        return model.minorSpaces(type);
    }
    public Ticket exitVehicleTicket(String plate){
        return model.registerVehicleExit(plate);
    }
public double change(double totalPay, double userPay){
    return model.change(totalPay, userPay);
}
public void generateReport(){
    model.generateReceptionistReport();
}
    public void changeCrededencialReceptionist(int idDoucment, String newPassword) {
        model.changeCrededencialReceptionist(idDoucment, newPassword);
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
