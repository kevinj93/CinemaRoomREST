package cinema;

import java.util.ArrayList;

public class Room {
    private int total_rows;
    private int total_columns;
    private ArrayList<Ticket> available_seats = new ArrayList<>();
    public Room(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;

        for (int i = 0; i < total_rows; i++) {
            for (int j = 0; j < total_columns; j++) {
                Ticket seat = new Ticket(i+1, j+1);
                available_seats.add(seat);
            }
        }
    }

    public ArrayList<Ticket> getAvailable_seats() {

        return available_seats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public Ticket getSeat (int row, int column) {
        for (Ticket seat : available_seats) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                return seat;
            }
        }
        return null;
    }

    public void removeSeat(int row, int column) {

        for (Ticket seat : available_seats) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                available_seats.remove(seat);
            }
        }

    }


}
