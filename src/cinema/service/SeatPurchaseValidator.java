package cinema.service;

import cinema.model.CinemaRoom;
import org.springframework.stereotype.Service;

@Service
public class SeatPurchaseValidator {

    private CinemaRoom cinemaRoom;

    public SeatPurchaseValidator(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public void validate(int row, int column) {
        if (row <= 0 || row > cinemaRoom.getRows() || column <= 0 || column > cinemaRoom.getColumns()) throw new RuntimeException("The number of a row or a column is out of bounds!");
        if (! cinemaRoom.isAvailableSeat(row, column)) throw new RuntimeException("The ticket has been already purchased!");
    }

}
