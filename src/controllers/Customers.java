package controllers;

public class Customers  {

    int customerId;
    String customerName;
    String customerContact;
    String customerAddress;

    public Customers(int customerId, String customerName,
                     String customerContact, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.customerAddress = customerAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
