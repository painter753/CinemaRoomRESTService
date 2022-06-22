package cinema.model.request;

public class SeatOrderRequest {

    private int row;
    private int column;

    public SeatOrderRequest() {}

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
