package controllers;

public class SaleCounter {

    int invoId;
    String productName;
    String batch;
    String quantity;
    String amount;

    public SaleCounter(int invoId, String productName, String batch, String quantity, String amount) {
        this.invoId = invoId;
        this.productName = productName;
        this.batch = batch;
        this.quantity = quantity;
        this.amount = amount;
    }


    public int getInvoId() {
        return invoId;
    }

    public String getProductName() {
        return productName;
    }

    public String getBatch() {
        return batch;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setInvoId(int invoId) {
        this.invoId = invoId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
