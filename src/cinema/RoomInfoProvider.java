package cinema;

import cinema.model.CinemaRoom;
import cinema.model.RoomInfo;
import cinema.model.Seat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomInfoProvider {

    private final CinemaRoom cinemaRoom;

    public RoomInfoProvider(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public RoomInfo getInfo() {
        Seat[][] seatsMatrix = cinemaRoom.getSeatsMatrix();
        int totalRows = seatsMatrix.length;
        int totalColumns = seatsMatrix[0].length;
        List<Seat> availableSeats = new ArrayList<>();

        for (Seat[] rows : seatsMatrix) {
            for (Seat seat : rows) {
                availableSeats.add(seat);
            }
        }
        return new RoomInfo(totalRows, totalColumns, availableSeats);
    }

}
