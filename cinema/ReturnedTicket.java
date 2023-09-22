package cinema;

public class ReturnedTicket {
    private Ticket returned_ticket;

    public ReturnedTicket (Ticket ticket) {
        this.returned_ticket = ticket;

    }

    public Ticket getReturned_ticket() {
        return returned_ticket;
    }
}
