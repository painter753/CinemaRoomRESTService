package cinema.model;

public class OrderInfo {

    private final String token;
    private final TicketInfo ticket;

    public OrderInfo(String token, TicketInfo ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public TicketInfo getTicket() {
        return ticket;
    }
}
