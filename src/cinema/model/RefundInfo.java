package cinema.model;

public class RefundInfo {

    private TicketInfo returnedTicket;

    public RefundInfo() {}
    public RefundInfo(TicketInfo returnedTicket) {
        this.returnedTicket = returnedTicket;
    }

    public TicketInfo getReturnedTicket() {
        return returnedTicket;
    }

    public void setReturnedTicket(TicketInfo returnedTicket) {
        this.returnedTicket = returnedTicket;
    }
}
