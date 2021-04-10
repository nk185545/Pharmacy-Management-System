package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    private Button customerButton;
    @FXML
    private Button dealerButton;
    @FXML
    private Button purchaseButton;
    @FXML
    private Button saleCounterButton;
    @FXML
    private Button inventoryButton;

    @FXML
    private GridPane customerGridPane;
    @FXML
    private TextField txt_customerId;
    @FXML
    private TextField txt_customerName;
    @FXML
    private TextField txt_customerContact;
    @FXML
    private TextArea txt_customerAddress;
    @FXML
    private TableView<Customers> table_customers;
    @FXML
    private TableColumn<Customers, Integer> col_customerId;
    @FXML
    private TableColumn<Customers, String> col_customerName;
    @FXML
    private TableColumn<Customers, String> col_customerContact;
    @FXML
    private TableColumn<Customers, String> col_customerAddress;

    @FXML
    private GridPane dealerGridPane;
    @FXML
    private TextField txt_dealerId;
    @FXML
    private TextField txt_dealerName;
    @FXML
    private TextField txt_dealerContact;
    @FXML
    private TextArea txt_dealerAddress;
    @FXML
    private TableView<Dealers> table_dealers;
    @FXML
    private TableColumn<Dealers, Integer> col_dealerId;
    @FXML
    private TableColumn<Dealers, String> col_dealerName;
    @FXML
    private TableColumn<Dealers, String> col_dealerContact;
    @FXML
    private TableColumn<Dealers, String> col_dealerAddress;

    @FXML
    private GridPane purchaseGridPane;
    @FXML
    private TextField txt_purchaseId;
    @FXML
    private DatePicker txt_purchaseDate;
    @FXML
    private TextField txt_medicineName;
    @FXML
    private TextField txt_batchNumber;
    @FXML
    private TextField txt_drName;
    @FXML
    private TextField txt_purchaseRate;
    @FXML
    private DatePicker txt_expiryDate;
    @FXML
    private TextField txt_sellingRate;
    @FXML
    private TextField txt_quantity;
    @FXML
    private TableView<Purchases> table_purchases;
    @FXML
    private TableColumn<Purchases, Integer> col_purchaseId;
    @FXML
    private TableColumn<Purchases, String> col_medicineName;
    @FXML
    private TableColumn<Purchases, String> col_drName;
    @FXML
    private TableColumn<Purchases, String> col_batchNumber;
    @FXML
    private TableColumn<Purchases, String> col_quantity;
    @FXML
    private TableColumn<Purchases, String> col_purchaseDate;
    @FXML
    private TableColumn<Purchases, String> col_purchaseRate;
    @FXML
    private TableColumn<Purchases, String> col_sellingRate;
    @FXML
    private TableColumn<Purchases, String> col_expiryDate;

    @FXML
    private GridPane saleCounterGridPane;
    @FXML
    private DatePicker txt_dateSale;
    @FXML
    private TextField txt_cusName;
    @FXML
    private TextField txt_prName;
    @FXML
    private TextField txt_qt;
    @FXML
    private TextField txt_exDate;
    @FXML
    private TextField txt_rate;
    @FXML
    private TextField txt_amount;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TableView<SaleCounter> table_sales;
    @FXML
    private TableColumn<SaleCounter, String> col_medName;
    @FXML
    private TableColumn<SaleCounter, String> col_batch;
    @FXML
    private TableColumn<SaleCounter, String> col_qt;
    @FXML
    private TableColumn<SaleCounter, String> col_amount;

    @FXML
    private GridPane inventoryGridPane;
    @FXML
    private TextField txt_productName;
    @FXML
    private TextField txt_batNumber;
    @FXML
    private TextField txt_quantitiyLessEqual;
    @FXML
    private DatePicker txt_expiresOrBefore;
    @FXML
    private TableView<Inventory> table_inventory;
    @FXML
    private TableColumn<Inventory, String> col_productName;
    @FXML
    private TableColumn<Inventory, String> col_batNumber;
    @FXML
    private TableColumn<Inventory, Integer> col_quant;
    @FXML
    private TableColumn<Inventory, String> col_purDate;
    @FXML
    private TableColumn<Inventory, String> col_purRate;
    @FXML
    private TableColumn<Inventory, String> col_selRate;
    @FXML
    private TableColumn<Inventory, String> col_expDate;


    @FXML
    private ImageView pharmacy_logo;

    ObservableList<Customers> listCustomer;
    ObservableList<Dealers> listDealers;
    ObservableList<Purchases> listPurchases;
    ObservableList<SaleCounter> listSales;
    ObservableList<Inventory> listInventory;
    ObservableList<String> list = FXCollections.observableArrayList();

    int ind = -1;
    Connection conn = null;
    PreparedStatement pst = null;
    String cvalue = null;
    public void addCustomers () {
        conn = DatabaseConnection.getConnection();
        String sql = "insert into customer_table (CustomerId, CustomerName, CustomerContact," +
                     " CustomerAddress) values (?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_customerId.getText());
            pst.setString(2, txt_customerName.getText());
            pst.setString(3, txt_customerContact.getText());
            pst.setString(4, txt_customerAddress.getText());
            pst.execute();
            updateTableCustomers();

            txt_customerId.clear();
            txt_customerName.clear();
            txt_customerContact.clear();
            txt_customerAddress.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void getSelectedCustomers() {
        ind = table_customers.getSelectionModel().getSelectedIndex();
        if (ind <= -1) {

            return;
        }
        txt_customerId.setText(col_customerId.getCellData(ind).toString());
        txt_customerName.setText(col_customerName.getCellData(ind));
        txt_customerContact.setText(col_customerContact.getCellData(ind));
        txt_customerAddress.setText(col_customerAddress.getCellData(ind));
    }
    public void updateCustomers () {
        try {
            conn = DatabaseConnection.getConnection();
            String val1 = txt_customerId.getText();
            String val2 = txt_customerName.getText();
            String val3 = txt_customerContact.getText();
            String val4 = txt_customerAddress.getText();

            String sql = "update customer_table set customerId = '" + val1 + "', " +
                    "customerName = '" + val2 + "', customerContact = '" + val3 +"'," +
                    " customerAddress = '" + val4 + "' where customerId = '" + val1 + "' ";
            pst = conn.prepareStatement(sql);
            pst.execute();

            updateTableCustomers();
            txt_customerId.clear();
            txt_customerName.clear();
            txt_customerContact.clear();
            txt_customerAddress.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteCustomers() {
        conn = DatabaseConnection.getConnection();
        String sql = "delete from customer_table where customerId = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_customerId.getText());
            pst.execute();
            updateTableCustomers();

            txt_customerId.clear();
            txt_customerName.clear();
            txt_customerContact.clear();
            txt_customerAddress.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addDealer() {
        conn = DatabaseConnection.getConnection();
        String sql = "insert into dealer_table (DealerId, DealerName, DealerContact, " +
                     "DealerAddress) values (?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_dealerId.getText());
            pst.setString(2, txt_dealerName.getText());
            pst.setString(3, txt_dealerContact.getText());
            pst.setString(4, txt_dealerAddress.getText());
            pst.execute();

            updateTableDealers();

            txt_dealerId.clear();
            txt_dealerName.clear();
            txt_dealerContact.clear();
            txt_dealerAddress.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void getSelectedDealers() {
        ind = table_dealers.getSelectionModel().getSelectedIndex();
        if (ind <= -1) {

            return;
        }
        txt_dealerId.setText(col_dealerId.getCellData(ind).toString());
        txt_dealerName.setText(col_dealerName.getCellData(ind));
        txt_dealerContact.setText(col_dealerContact.getCellData(ind));
        txt_dealerAddress.setText(col_dealerAddress.getCellData(ind));
    }
    public void updateDealers () {
        try {
            conn = DatabaseConnection.getConnection();
            String val1 = txt_dealerId.getText();
            String val2 = txt_dealerName.getText();
            String val3 = txt_dealerContact.getText();
            String val4 = txt_dealerAddress.getText();

            String sql = "update dealer_table set dealerId = '" + val1 + "', " +
                    "dealerName = '" + val2 + "', dealerContact = '" + val3 +"'," +
                    " dealerAddress = '" + val4 + "' where dealerId = '" + val1 + "' ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            updateTableDealers();

            txt_dealerId.clear();
            txt_dealerName.clear();
            txt_dealerContact.clear();
            txt_dealerAddress.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDealers() {
        conn = DatabaseConnection.getConnection();
        String sql = "delete from dealer_table where dealerId = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_dealerId.getText());
            pst.execute();
            updateTableDealers();

            txt_dealerId.clear();
            txt_dealerName.clear();
            txt_dealerContact.clear();
            txt_dealerAddress.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String purchaseDate() {
        LocalDate ld = txt_purchaseDate.getValue();
        return String.valueOf(ld);
    }
    public String expiryDate() {
        LocalDate ld = txt_expiryDate.getValue();
        return String.valueOf(ld);
    }
    public void comboChanged() {
        cvalue = comboBox.getValue();
    }
    public void addPurchase() {
        conn = DatabaseConnection.getConnection();
        String sql = "insert into purchase_table (MedicineName, DealerName, " +
                     "BatchNumber, Quantity, PurchaseDate, PurchaseRate, " +
                     "SellingRate, ExpiryDate) values (?, ?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "insert into inventorytable (ProductName, BatchNumber, Quantity," +
                       "PurchaseDate, PurchaseRate, SellingRate, ExpiryDate) values (?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = conn.prepareStatement(sql);

            pst.setString(1, txt_medicineName.getText());
            pst.setString(2, txt_drName.getText());
            pst.setString(3, txt_batchNumber.getText());
            pst.setString(4, txt_quantity.getText());
            pst.setString(5, purchaseDate());
            pst.setString(6, txt_purchaseRate.getText());
            pst.setString(7, txt_sellingRate.getText());
            pst.setString(8, expiryDate());
            pst.execute();
            updateTablePurchases();

            pst = conn.prepareStatement(sql2);
            pst.setString(1, txt_medicineName.getText());
            pst.setString(2, txt_batchNumber.getText());
            pst.setString(3, txt_quantity.getText());
            pst.setString(4, purchaseDate());
            pst.setString(5, txt_purchaseRate.getText());
            pst.setString(6, txt_sellingRate.getText());
            pst.setString(7, expiryDate());
            pst.execute();
            updateTableInventory();

            txt_purchaseId.clear();
            txt_medicineName.clear();
            txt_drName.clear();
            txt_batchNumber.clear();
            txt_quantity.clear();
            txt_purchaseRate.clear();
            txt_sellingRate.clear();
            txt_purchaseDate.setValue(null);
            txt_expiryDate.setValue(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void getSelectedPurchases() {
        ind = table_purchases.getSelectionModel().getSelectedIndex();
        if (ind <= -1) {
            return;
        }
        txt_purchaseId.setText(String.valueOf(col_purchaseId.getCellData(ind)));
        txt_medicineName.setText(col_medicineName.getCellData(ind));
        txt_drName.setText(col_drName.getCellData(ind));
        txt_batchNumber.setText(col_batchNumber.getCellData(ind));
        txt_quantity.setText(col_quantity.getCellData(ind));
        txt_purchaseDate.setValue(LocalDate.parse(col_purchaseDate.getCellData(ind)));
        txt_purchaseRate.setText(col_purchaseRate.getCellData(ind));
        txt_sellingRate.setText(col_sellingRate.getCellData(ind));
        txt_expiryDate.setValue(LocalDate.parse(col_expiryDate.getCellData(ind)));
    }
    public void deletePurchases() {
        conn = DatabaseConnection.getConnection();
        String sql = "delete from purchase_table where purchaseId = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_purchaseId.getText());
            pst.execute();
            updateTablePurchases();

            txt_purchaseId.clear();
            txt_medicineName.clear();
            txt_drName.clear();
            txt_batchNumber.clear();
            txt_quantity.clear();
            txt_purchaseRate.clear();
            txt_sellingRate.clear();
            txt_purchaseDate.setValue(null);
            txt_expiryDate.setValue(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addItemSales() {
        conn = DatabaseConnection.getConnection();
        String sql = "insert into saleitemtable (productName, batch, quantity, amount) values (?, ?, ?, ?)";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_prName.getText());
            pst.setString(2, cvalue);
            pst.setString(3, txt_qt.getText());
            pst.setString(4, txt_amount.getText());
            pst.execute();
            updateTableSales();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void getSelectedSales() {
        ind = table_sales.getSelectionModel().getSelectedIndex();
    }
//    public void deleteSales() {
//        conn = DatabaseConnection.getConnection();
//        String sql = "delete from purchase_table where sale_id = ?";
//        try {
//            pst = conn.prepareStatement(sql);
////            pst.setString(1, id.getText());
//            pst.execute();
//            updateTableSales();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public Date purchaseDateInv() {
//        java.util.Date date = java.util.Date.from(txt_expiresOrBefore.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
//
//        return new Date(date.getTime());
//    }
    public void searchButton() {
        conn = DatabaseConnection.getConnection();
        String sql = "select * from inventorytable where ProductName = ? and batchNumber = ? and quantity <= ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_productName.getText());
            pst.setString(2, String.valueOf(txt_batNumber.getText()));
            pst.setString(3, String.valueOf(txt_quantitiyLessEqual.getText()));
//            pst.setString(4, String.valueOf(purchaseDateInv()));
            pst.execute();
//            updateTableInventory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTableCustomers() {
        col_customerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        col_customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        col_customerContact.setCellValueFactory(new PropertyValueFactory<>("customerContact"));
        col_customerAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        listCustomer = DatabaseConnection.getDataCustomers();
        table_customers.setItems(listCustomer);
    }
    public void updateTableDealers() {
        col_dealerId.setCellValueFactory(new PropertyValueFactory<>("DealerId"));
        col_dealerName.setCellValueFactory(new PropertyValueFactory<>("DealerName"));
        col_dealerContact.setCellValueFactory(new PropertyValueFactory<>("DealerContact"));
        col_dealerAddress.setCellValueFactory(new PropertyValueFactory<>("DealerAddress"));
        listDealers = DatabaseConnection.getDataDealers();
        table_dealers.setItems(listDealers);
    }
    public void updateTablePurchases() {
        col_purchaseId.setCellValueFactory(new PropertyValueFactory<>("PurchaseId"));
        col_medicineName.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
        col_drName.setCellValueFactory(new PropertyValueFactory<>("DealerName"));
        col_batchNumber.setCellValueFactory(new PropertyValueFactory<>("BatchNumber"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        col_purchaseDate.setCellValueFactory(new PropertyValueFactory<>("PurchaseDate"));
        col_purchaseRate.setCellValueFactory(new PropertyValueFactory<>("PurchaseRate"));
        col_sellingRate.setCellValueFactory(new PropertyValueFactory<>("SellingRate"));
        col_expiryDate.setCellValueFactory(new PropertyValueFactory<>("ExpiryDate"));
        listPurchases = DatabaseConnection.getDataPurchases();
        table_purchases.setItems(listPurchases);
    }
    public void updateTableSales() {
        col_medName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        col_batch.setCellValueFactory(new PropertyValueFactory<>("Batch"));
        col_qt.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        col_amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        listSales = DatabaseConnection.getDataSales();
        table_sales.setItems(listSales);
    }
    public void updateTableInventory() {
        col_productName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        col_batNumber.setCellValueFactory(new PropertyValueFactory<>("BatchNumber"));
        col_quant.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        col_purDate.setCellValueFactory(new PropertyValueFactory<>("PurchaseDate"));
        col_purRate.setCellValueFactory(new PropertyValueFactory<>("PurchaseRate"));
        col_selRate.setCellValueFactory(new PropertyValueFactory<>("SellingRate"));
        col_expDate.setCellValueFactory(new PropertyValueFactory<>("ExpiryDate"));
        listInventory = DatabaseConnection.getDataInventories();
        table_inventory.setItems(listInventory);
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        File logoFile = new File("Img/logo_pharmacy.jpg");
        Image logoImage = new Image(logoFile.toURI().toString());
        pharmacy_logo.setImage(logoImage);
        for (int i = 1; i < 50; i++)
            list.add(String.valueOf(i));
        comboBox.setItems(list);

        updateTableCustomers();
        updateTableDealers();
        updateTablePurchases();
        updateTableSales();
        updateTableInventory();
    }

    @FXML
    private void handleButtonClicks(ActionEvent event) {

        if (event.getSource() == customerButton) {
            customerGridPane.toFront();
            customerGridPane.setVisible(true);
            dealerGridPane.setVisible(false);
            purchaseGridPane.setVisible(false);
            saleCounterGridPane.setVisible(false);
            inventoryGridPane.setVisible(false);

            customerButton.setStyle("-fx-background-color: #3083b3;");
            dealerButton.setStyle("-fx-background-color: #96d8e9;");
            purchaseButton.setStyle("-fx-background-color: #96d8e9;");
            saleCounterButton.setStyle("-fx-background-color: #96d8e9;");
            inventoryButton.setStyle("-fx-background-color: #96d8e9;");
        }

        else if (event.getSource() == dealerButton) {
            dealerGridPane.toFront();
            dealerGridPane.setVisible(true);
            customerGridPane.setVisible(false);
            purchaseGridPane.setVisible(false);
            saleCounterGridPane.setVisible(false);
            inventoryGridPane.setVisible(false);

            customerButton.setStyle("-fx-background-color: #96d8e9;");
            dealerButton.setStyle("-fx-background-color: #3083b3;");
            purchaseButton.setStyle("-fx-background-color: #96d8e9;");
            saleCounterButton.setStyle("-fx-background-color: #96d8e9;");
            inventoryButton.setStyle("-fx-background-color: #96d8e9;");
        }
        else if (event.getSource() == purchaseButton) {
            purchaseGridPane.toFront();
            purchaseGridPane.setVisible(true);
            customerGridPane.setVisible(false);
            dealerGridPane.setVisible(false);
            saleCounterGridPane.setVisible(false);
            inventoryGridPane.setVisible(false);

            customerButton.setStyle("-fx-background-color: #96d8e9;");
            dealerButton.setStyle("-fx-background-color: #96d8e9;");
            purchaseButton.setStyle("-fx-background-color: #3083b3;");
            saleCounterButton.setStyle("-fx-background-color: #96d8e9;");
            inventoryButton.setStyle("-fx-background-color: #96d8e9;");
        }
        else if (event.getSource() == saleCounterButton) {
            saleCounterGridPane.toFront();
            saleCounterGridPane.setVisible(true);
            customerGridPane.setVisible(false);
            dealerGridPane.setVisible(false);
            purchaseGridPane.setVisible(false);
            inventoryGridPane.setVisible(false);

            customerButton.setStyle("-fx-background-color: #96d8e9;");
            dealerButton.setStyle("-fx-background-color: #96d8e9;");
            purchaseButton.setStyle("-fx-background-color: #96d8e9;");
            saleCounterButton.setStyle("-fx-background-color: #3083b3;");
            inventoryButton.setStyle("-fx-background-color: #96d8e9;");

        }
        else if (event.getSource() == inventoryButton) {
            inventoryGridPane.toFront();
            inventoryGridPane.setVisible(true);
            customerGridPane.setVisible(false);
            dealerGridPane.setVisible(false);
            purchaseGridPane.setVisible(false);
            saleCounterGridPane.setVisible(false);

            customerButton.setStyle("-fx-background-color: #96d8e9;");
            dealerButton.setStyle("-fx-background-color: #96d8e9;");
            purchaseButton.setStyle("-fx-background-color: #96d8e9;");
            saleCounterButton.setStyle("-fx-background-color: #96d8e9;");
            inventoryButton.setStyle("-fx-background-color: #3083b3;");
        }
    }

}
