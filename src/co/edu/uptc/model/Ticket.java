package co.edu.uptc.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Ticket {
    private int ticketID;
    private Vehicle vehicle;
    private LocalDateTime entryDateTime;
    private LocalDateTime  exitDateTime;
    private double totalPay;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final double RATE_PER_MINUTE = 100.0;
   
    
    public Ticket(int ticketID, Vehicle vehicle, LocalDateTime entryDateTime){
        this.ticketID= ticketID;
        this.vehicle= vehicle;
        this.entryDateTime=entryDateTime;
    }
    
    public void checkOut(LocalDateTime exitDateTime){
        this.exitDateTime= exitDateTime;
        this.totalPay= calculateTotalPay();
    }
    public double calculateTotalPay() {
        if (exitDateTime == null) {
            return 0;
        }
        long minutes = java.time.Duration.between(entryDateTime, exitDateTime).toMinutes();

        return Math.max(1, minutes) * RATE_PER_MINUTE;
    }
    public String printEntryTicket() {
        return "Detalles de ingreso\n" +
               "Fecha: " + entryDateTime.format(formatter) + "\n" +
               "Referencia: " + ticketID + "\n" +
               "Estado: Aprobado\n" +
               "Placa: " + vehicle.getPlate() + "\n" +
               "Fracción: $2.000";
    }
    public String printExitTicket() {
        return "Detalles del pago\n" +
               "Fecha de pago: " + exitDateTime.format(formatter) + "\n" +
               "Referencia: " + ticketID + "\n" +
               "Estado: Aprobado\n" +
               "Forma de pago: Efectivo\n" +
               "Valor pagado: " + String.format("%.0f", totalPay) + "\n" +
               "Placa: " + vehicle.getPlate();
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(LocalDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public LocalDateTime getExitDateTime() {
        return exitDateTime;
    }

    public void setExitDateTime(LocalDateTime exitDateTime) {
        this.exitDateTime = exitDateTime;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }
    
   
    }


