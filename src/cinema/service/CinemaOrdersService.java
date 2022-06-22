package cinema.service;

import cinema.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CinemaOrdersService {

    private final CinemaRoom cinemaRoom;
    private final Map<String, OrderInfo> orders;

    public CinemaOrdersService(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
        this.orders = new ConcurrentHashMap<>();
    }

    public OrderInfo createOrder(int row, int column) {
        Seat seat = cinemaRoom.bookSeat(row, column);
        int price = seat.getPrice();
        String token = UUID.randomUUID().toString();
        OrderInfo order = new OrderInfo(token, new TicketInfo(row, column, price));
        orders.put(token, order);
        return order;
    }

    public RefundInfo refundOrder(String token) {
        if (orders.containsKey(token)) {
            OrderInfo order = orders.remove(token);
            Seat seat = cinemaRoom.cancelBooking(order.getTicket().getRow(), order.getTicket().getColumn());
            return new RefundInfo(new TicketInfo(seat.getRow(), seat.getColumn(), seat.getPrice()));
        } else {
            throw new RuntimeException("Wrong token!");
        }
    }

    public List<OrderInfo> getOrders() {
        return List.copyOf(orders.values());
    }

}
