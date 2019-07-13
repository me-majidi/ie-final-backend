package requestTypes;

public class ReservationRequest {
    private Integer ticketId;
    private Integer ticketsCount;
    private String buyerFirstName;
    private String buyerLastName;
    private String buyerMobileNumber;
    private String buyerNationalNumber;

    public ReservationRequest() {

    }

    public ReservationRequest(Integer ticketId, Integer ticketsCount, String buyerFirstName, String buyerLastName, String buyerMobileNumber, String buyerNationalNumber) {
        this.ticketId = ticketId;
        this.ticketsCount = ticketsCount;
        this.buyerFirstName = buyerFirstName;
        this.buyerLastName = buyerLastName;
        this.buyerMobileNumber = buyerMobileNumber;
        this.buyerNationalNumber = buyerNationalNumber;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getTicketsCount() {
        return ticketsCount;
    }

    public void setTicketsCount(Integer ticketsCount) {
        this.ticketsCount = ticketsCount;
    }

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }

    public String getBuyerMobileNumber() {
        return buyerMobileNumber;
    }

    public void setBuyerMobileNumber(String buyerMobileNumber) {
        this.buyerMobileNumber = buyerMobileNumber;
    }

    public String getBuyerNationalNumber() {
        return buyerNationalNumber;
    }

    public void setBuyerNationalNumber(String buyerNationalNumber) {
        this.buyerNationalNumber = buyerNationalNumber;
    }
}
