package co.edu.uptc.model;

import java.util.ArrayList;

public class Parking {
    private String name;
    private String direction;
    private int totalSpaces;
    private String businesHours;
    private ArrayList<Vehicle> parkedVehicles;
    private ArrayList<Ticket> allTickets;

    public Parking(){
        this.name=name;
        this.direction=direction;
        this.totalSpaces=totalSpaces;
        this.parkedVehicles=new ArrayList<>();
        this.allTickets=new ArrayList<>();
    }

    public boolean registerVehicleEntry(Vehicle vehicle){
          if (vehiculosEstacionados.size() < totalSpaces) {
            vehiculosEstacionados.add(vehiculo);
            Ticket ticket = new Ticket(tickets.size() + 1, vehiculo, java.time.LocalDateTime.now());
            tickets.add(ticket);
            return true;
        }
        return false;
    }
    public void registerVehicleExit(String placa){
          for (Ticket ticket : tickets) {
            if (ticket.getVehiculo().getPlaca().equals(placa) && ticket.getHoraSalida() == null) {
                ticket.registrarSalida(java.time.LocalDateTime.now());
                vehiculosEstacionados.remove(ticket.getVehiculo());
                return true;
            }
        }
        return false;
    }
    public void checkAvailableSpaces(){
                return vehiculosEstacionados.size() < espaciosTotales;

    }
      public void guardarTicket(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> obtenerTickets() {
        return tickets;
    }

    


}
