package cinema.service;

import cinema.model.CinemaRoom;
import cinema.model.OrderInfo;
import cinema.model.StatsInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaStatisticsService {

    private final CinemaRoom cinemaRoom;
    private final CinemaOrdersService cinemaOrdersService;


    public CinemaStatisticsService(CinemaRoom cinemaRoom, CinemaOrdersService cinemaOrdersService) {
        this.cinemaRoom = cinemaRoom;
        this.cinemaOrdersService = cinemaOrdersService;
    }

    public StatsInfo getStats() {
        StatsInfo statsInfo = new StatsInfo();
        List<OrderInfo> orders = cinemaOrdersService.getOrders();
        int currentIncome = orders.stream().mapToInt(order -> order.getTicket().getPrice()).sum();
        int availableSeatsCount = cinemaRoom.getAvailableSeats().size();
        int purchasedTicketsCount = orders.size();
        return new StatsInfo(currentIncome, availableSeatsCount, purchasedTicketsCount);
    }


}
