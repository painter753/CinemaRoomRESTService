package cinema.service;

import cinema.model.*;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SeatPurchaseService {
    private final SeatPurchaseValidator seatPurchaseValidator;
    private final CinemaOrdersService cinemaOrdersService;
    private final Map<String, OrderInfo> orders;

    public SeatPurchaseService(SeatPurchaseValidator seatPurchaseValidator, CinemaOrdersService cinemaOrdersService) {
        this.seatPurchaseValidator = seatPurchaseValidator;
        this.cinemaOrdersService = cinemaOrdersService;
        this.orders = new ConcurrentHashMap<>();
    }

    public OrderInfo order(int row, int column) {
        seatPurchaseValidator.validate(row, column);
        return cinemaOrdersService.createOrder(row, column);
    }

    public RefundInfo refund(String token) {
        return cinemaOrdersService.refundOrder(token);
    }
}
