package Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Ticket {
    private String ticketNumber;
    private Flight flight;
    private User passenger;
    private int price;
    private Seat seat;




    // Constructor
    public Ticket(String ticketNumber, Flight flight, User passenger, Seat seat) {
        this.ticketNumber = ticketNumber;
        this.flight = flight;
        this.seat = seat;
        this.passenger = passenger;

        // Check if the flightNumber already has a price assigned
        // if (!flightPrices.containsKey(flight)) {
        //     // If not, generate a new random price and associate it with the flightNumber
        //     Random random = new Random();
        //     int newPrice = random.nextInt(501) + 200;
        //     if (seat.getSeatClass().equals("First Class")){
        //         newPrice *= 1.4;
        //     } else if(seat.getSeatClass().equals("Business Class")){
        //         newPrice *= 2;
        //     }
        //     flightPrices.put(flight, newPrice);
        // }
        // this.price = flightPrices.get(flight);
    }


    // Getters
    public int getPrice() {
        return price;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public User getPassenger() {
        return passenger;
    }

    public Seat getSeat() {
        return seat;
    }
    // Setters

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setPassenger(User passenger) {
        this.passenger = passenger;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

}