package cinema.service;

import cinema.model.CinemaRoom;
import cinema.model.OrderInfo;
import cinema.model.Seat;
import org.springframework.stereotype.Service;

@Service
public class SeatPurchaseService {

    private final CinemaRoom cinemaRoom;
    private final SeatPurchaseValidator seatPurchaseValidator;

    public SeatPurchaseService(CinemaRoom cinemaRoom, SeatPurchaseValidator seatPurchaseValidator) {
        this.cinemaRoom = cinemaRoom;
        this.seatPurchaseValidator = seatPurchaseValidator;
    }

    public OrderInfo order(int row, int column) {
        seatPurchaseValidator.validate(row, column);
        Seat seat = cinemaRoom.bookSeat(row, column);
        int price = seat.getPrice();
        return new OrderInfo(row, column, price);
    }
}
