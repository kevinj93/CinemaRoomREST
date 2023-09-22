package cinema;

import java.util.ArrayList;

public class Reservation {
    private Token token;
    private Ticket ticket;

    public Reservation(Token token, Ticket ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getToken() {
        return token.getToken();
    }
}
