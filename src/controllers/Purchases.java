package controllers;

public class Purchases {
    int purchaseId;
    String medicineName;
    String dealerName;
    String batchNumber;
    String quantity;
    String purchaseDate;
    String purchaseRate;
    String sellingRate;
    String expiryDate;


    public Purchases(int purchaseId, String medicineName, String dealerName, String batchNumber, String quantity, String purchaseDate, String purchaseRate, String sellingRate, String expiryDate) {
        this.purchaseId = purchaseId;
        this.medicineName = medicineName;
        this.dealerName = dealerName;
        this.batchNumber = batchNumber;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.purchaseRate = purchaseRate;
        this.sellingRate = sellingRate;
        this.expiryDate = expiryDate;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getDealerName() {
        return dealerName;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public String getPurchaseRate() {
        return purchaseRate;
    }

    public String getSellingRate() {
        return sellingRate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchaseRate(String purchaseRate) {
        this.purchaseRate = purchaseRate;
    }

    public void setSellingRate(String sellingRate) {
        this.sellingRate = sellingRate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
