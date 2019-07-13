package entities;

public class Transaction {
    private String ID;
    private String time;
    private String  user_id;
    private Integer ticket_id;
    private String payment_status;
    private Integer tickets_count;

    public Transaction() {}
    public Transaction(String ID, String time, String user_id, Integer ticket_id, String payment_status, Integer tickets_count) {
        this.ID = ID;
        this.time = time;
        this.user_id = user_id;
        this.ticket_id = ticket_id;
        this.payment_status = payment_status;
        this.tickets_count = tickets_count;
    }

    public Integer getTickets_count() {
        return tickets_count;
    }

    public void setTickets_count(Integer tickets_count) {
        this.tickets_count = tickets_count;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Integer ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }
}
