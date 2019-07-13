package entities;

public class User {
    private String ID;
    private String firstName;
    private String lastName;
    private String mobile;
    private String nationalNumber;

    public User() {}
    public User(String ID, String firstName, String lastName, String mobile, String nationalNumber) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.nationalNumber = nationalNumber;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }
}
