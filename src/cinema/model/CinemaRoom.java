package cinema.model;

public class CinemaRoom {

    private final Seat[][] seatsMatrix;

    public CinemaRoom(int rows, int columns) {
        this.seatsMatrix = initMatrix(rows, columns);
    }

    private Seat[][] initMatrix(int rows, int columns) {
        Seat[][] seats = new Seat[rows][columns];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat(i + 1, j + 1);
            }
        }
        return seats;
    }

    public Seat[][] getSeatsMatrix() {
        return seatsMatrix;
    }
}
