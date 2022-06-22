package cinema.service;

import cinema.model.CinemaRoom;
import cinema.model.RoomInfo;
import cinema.model.Seat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomInfoService {

    private final CinemaRoom cinemaRoom;

    public RoomInfoService(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public RoomInfo getInfo() {
        int totalRows = cinemaRoom.getRows();
        int totalColumns = cinemaRoom.getColumns();
        List<Seat> availableSeats = cinemaRoom.getAvailableSeats();

        return new RoomInfo(totalRows, totalColumns, availableSeats);
    }

}
