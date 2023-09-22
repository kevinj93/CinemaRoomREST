package cinema;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class Stats {
    private int current_income, number_of_available_seats, number_of_purchased_tickets;

    public Stats(Room room) {
        current_income = 0;
        number_of_available_seats = 0;
        number_of_purchased_tickets = 0;

        ArrayList<Ticket> seats = room.getAvailable_seats();

        number_of_available_seats = seats.size();

        for (Ticket seat : seats) {
            if (seat.hasToken()) {
                current_income += seat.getPrice();
                number_of_purchased_tickets += 1;
                number_of_available_seats -= 1;
            }
        }

    }

    public int getCurrent_income() {
        return current_income;
    }

    public int getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public int getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }
}
