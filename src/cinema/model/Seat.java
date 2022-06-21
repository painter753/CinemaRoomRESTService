package cinema.model;

public class Seat {

    private final int row;
    private final int column;
    private boolean isFree = true;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
