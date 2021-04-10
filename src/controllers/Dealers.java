package controllers;

public class Dealers  {
    int dealerId;
    String dealerName;
    String dealerContact;
    String dealerAddress;


    public Dealers(int dealerId, String dealerName, String dealerContact, String dealerAddress) {
        this.dealerId = dealerId;
        this.dealerName = dealerName;
        this.dealerContact = dealerContact;
        this.dealerAddress = dealerAddress;
    }

    public int getDealerId() {
        return dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public String getDealerContact() {
        return dealerContact;
    }

    public String getDealerAddress() {
        return dealerAddress;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public void setDealerContact(String dealerContact) {
        this.dealerContact = dealerContact;
    }

    public void setDealerAddress(String dealerAddress) {
        this.dealerAddress = dealerAddress;
    }
}
