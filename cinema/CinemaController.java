package cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@RestController
public class CinemaController {

    @Autowired
    Room room;

//    @GetMapping("/seats")
//    public ArrayList<Seat> returnRoom () {
//        return room.getAvailable_seats();
//    }

    @GetMapping("/seats")

    public Room returnRoom() {
        return room;
    }

    @PostMapping("/purchase")
    public ResponseEntity getSeat(@RequestBody Ticket seat) {

        boolean hasRow = seat.getRow() != null;
        boolean hasColumn = seat.getColumn() != null;

        if (hasRow && hasColumn) {
            int row = seat.getRow();
            int col = seat.getColumn();

            if (room.getSeat(row, col) == null) {
                return new ResponseEntity<>(new Error("The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
            }

            Ticket.STATUS seatStatus = room.getSeat(row, col).getStatus();

            if (seatStatus != Ticket.STATUS.TAKEN) {
                Token token = new Token();

                room.getSeat(row, col).setTaken();
                room.getSeat(row, col).setToken(token);

                Reservation reservation = new Reservation(token, room.getSeat(row, col));

//            room.removeSeat(row, col);
                return new ResponseEntity<>(reservation, HttpStatus.resolve(200));
            } else {
                return new ResponseEntity<>(new Error("The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
            }

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/return")
    public ResponseEntity returnTicket(@RequestBody Token token) {
        String _token = token.getToken();
        ArrayList<Ticket> tickets = room.getAvailable_seats();

        for (Ticket ticket : tickets) {
            if (ticket.hasToken()) {
                if (Objects.equals(ticket.getToken().getToken(), _token)) {
                    ticket.setAvailable();
                    ticket.setToken(null);

                    ReturnedTicket returned_ticket = new ReturnedTicket(ticket);

                    return new ResponseEntity<>(returned_ticket, HttpStatus.resolve(200));
                }
            }
        }

        return new ResponseEntity<>(new Error("Wrong token!"), HttpStatus.resolve(400));
    }

    @GetMapping("/stats")
    public ResponseEntity getStats(@RequestParam(required = false) String password) {
        if (password != null && password.equals("super_secret")) {
            Stats stats = new Stats(room);
            return new ResponseEntity<>(stats, HttpStatus.resolve(200));
        }

    return new ResponseEntity<>(new Error("The password is wrong!"), HttpStatus.resolve(401));
    }
}
