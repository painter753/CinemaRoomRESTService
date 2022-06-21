package cinema.model;

import java.util.List;

public class RoomInfo {

    private final int totalRows;
    private final int totalColumns;
    private final List<Seat> availableSeats;

    public RoomInfo(int totalRows, int totalColumns, List<Seat> availableSeats) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = availableSeats;
    }


    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }
}
