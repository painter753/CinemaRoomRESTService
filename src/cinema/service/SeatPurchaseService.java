package cinema.service;

import cinema.model.*;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SeatPurchaseService {

    private final CinemaRoom cinemaRoom;
    private final SeatPurchaseValidator seatPurchaseValidator;
    private final Map<String, OrderInfo> orders;

    public SeatPurchaseService(CinemaRoom cinemaRoom, SeatPurchaseValidator seatPurchaseValidator) {
        this.cinemaRoom = cinemaRoom;
        this.seatPurchaseValidator = seatPurchaseValidator;
        this.orders = new ConcurrentHashMap<>();
    }

    public OrderInfo order(int row, int column) {
        seatPurchaseValidator.validate(row, column);
        Seat seat = cinemaRoom.bookSeat(row, column);
        int price = seat.getPrice();
        OrderInfo order = new OrderInfo(UUID.randomUUID().toString(), new TicketInfo(row, column, price));
        orders.put(order.getToken(), order);
        return order;
    }

    public RefundInfo refund(String token) {
        if (orders.containsKey(token)) {
            OrderInfo order = orders.remove(token);
            Seat seat = cinemaRoom.cancelBooking(order.getTicket().getRow(), order.getTicket().getColumn());
            return new RefundInfo(new TicketInfo(seat.getRow(), seat.getColumn(), seat.getPrice()));
        } else {
            throw new RuntimeException("Wrong token!");
        }
    }
}
