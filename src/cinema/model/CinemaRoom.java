package cinema.model;

import java.util.ArrayList;
import java.util.List;

public class CinemaRoom {

    private Seat[][] seatsMatrix;
    private final boolean[][] availabilityMatrix;

    private final int rows;
    private final int columns;

    public CinemaRoom(int rows, int columns) {
        this.seatsMatrix = new Seat[rows][columns];
        this.availabilityMatrix = new boolean[rows][columns];
        fillMatrix();
        this.rows = rows;
        this.columns = columns;
    }

    private void fillMatrix() {
        for (int i = 0; i < seatsMatrix.length; i++) {
            for (int j = 0; j < seatsMatrix[i].length; j++) {
                int row = i + 1;
                int column = j + 1;
                seatsMatrix[i][j] = new Seat(row, column, row <= 4 ? 10 : 8);
                availabilityMatrix[i][j] = true;
            }
        }
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < seatsMatrix.length; i++) {
            for (int j = 0; j < seatsMatrix[i].length; j++) {
                if (availabilityMatrix[i][j]) seats.add(seatsMatrix[i][j]);
            }
        }
        return seats;
    }

    public boolean isAvailableSeat(int row, int column) {
        return availabilityMatrix[row - 1][column - 1];
    }

    public Seat bookSeat(int row, int column) {
        availabilityMatrix[row - 1][column - 1] = false;
        return seatsMatrix[row - 1][column - 1];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
