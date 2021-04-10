package controllers;

public class Inventory {

    int id;
    int quantity;
    String productName;
    String batchNumber;
    String purchaseDate;
    String purchaseRate;
    String sellingRate;
    String expiryDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseRate() {
        return purchaseRate;
    }

    public void setPurchaseRate(String purchaseRate) {
        this.purchaseRate = purchaseRate;
    }

    public String getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(String sellingRate) {
        this.sellingRate = sellingRate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Inventory(int id, String productName, String batchNumber, int quantity,
                     String purchaseDate, String purchaseRate, String sellingRate,
                     String expiryDate) {
        this.id = id;
        this.productName = productName;
        this.batchNumber = batchNumber;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.purchaseRate = purchaseRate;
        this.sellingRate = sellingRate;
        this.expiryDate = expiryDate;
    }
}
