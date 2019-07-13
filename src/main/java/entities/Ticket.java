package entities;

public class Ticket {
    private Integer ID;
    private Integer capaciy;
    private Integer price;
    private String from;
    private String to;
    private String company;
    private String departDate;

    public Ticket() {
    }

    public Ticket(Integer ID, Integer capaciy, Integer price, String from, String to, String company, String departDate) {
        this.ID = ID;
        this.capaciy = capaciy;
        this.price = price;
        this.from = from;
        this.to = to;
        this.company = company;
        this.departDate = departDate;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getcapaciy() {
        return capaciy;
    }

    public void setcapaciy(Integer capaciy) {
        this.capaciy = capaciy;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
