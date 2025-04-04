package co.edu.uptc.model;

import java.util.ArrayList;

public class Ticket {
    private int ticketID;
    private Vehicle vehicle;
    private LocalDateTime entryDateTime;
    private LocalDateTime  exitDateTime;
    private double totalPay;
    private ArrayList<Object> registroTicket;       
    private Parking parking;
    
    public Ticket(){
        this.ticketID= ticketID;
        this.vehicle= vehicle;
        this.entryDateTime=entryDateTime;
        this.exitDateTime=entryDateTime;
        this.totalPay=totalPay;
        this.registroTicket=  new ArrayList <>();
    }
    
    
    public void registrarSalida(LocalDateTime exitDateTime) {
        this.exitDateTime = exitDateTime;
        this.totalPay = totalPay();
    }
    public double totalPay(){
         if (exitDateTime == null || entryDateTime == null) {
            return 0.0;
        }
        long minutos = ChronoUnit.MINUTES.between(entryDateTime, exitDateTime);
        double tarifaPorMinuto = 0.05; 
        return minutos * tarifaPorMinuto;
    }
    public String printTicket(){
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Vehículo: " + vehiculo.getPlaca());
        System.out.println("Hora de ingreso: " + entryDateTime);
        System.out.println("Hora de salida: " + (exitDateTime != null ? exitDateTime : "Aún en el parqueadero"));
        System.out.println("Total a pagar: $" + totalPagar);
}


}
