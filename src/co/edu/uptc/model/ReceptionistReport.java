package co.edu.uptc.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceptionistReport {

    private User receptionist;
    private int totalVehicles;
    private double totalIngress;
    private LocalDateTime entryDateTime;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ReceptionistReport(User receptionist, int totalVehicles, double totalIngress, LocalDateTime dateLocalTime) {
        this.receptionist = receptionist;
        this.totalVehicles = totalVehicles;
        this.totalIngress = totalIngress;
        this.entryDateTime = dateLocalTime;
    }

    public User getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(User receptionist) {
        this.receptionist = receptionist;
    }

    public int getTotalVehicles() {
        return totalVehicles;
    }

    public void setTotalVehicles(int totalVehicles) {
        this.totalVehicles = totalVehicles;
    }

    public double getTotalIngress() {
        return totalIngress;
    }

    public void setTotalIngress(double totalIngress) {
        this.totalIngress = totalIngress;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(LocalDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

}
