package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductController {
    @FXML
    public TextField priceTextfield;
    @FXML
    public TextField productNumberTXTF;
    @FXML
    public TextField productnamenTXF;
    @FXML
    public TextField productTextfield;
    @FXML
    public TextField supplierTextfield;
    @FXML
    public TextField discountTextfield;
    @FXML
    public TextField descriptionTextfield;
    @FXML
    public Button editButton;
    @FXML
    public Button deleteBTN;
    @FXML
    public Button registerBTN;
    @FXML
    public TableView <Product>productView;
    public TableColumn nameTable;
    public TableColumn priceTable;
    public TableColumn supplierTable;
    private SqlServerConnection ConnectNow;
    private Connection connectionDB;

    public ProductController() throws SQLException, ClassNotFoundException {
        ConnectNow = new SqlServerConnection();
        connectionDB = ConnectNow.connect();
    }


    @FXML
    public void editAction(ActionEvent actionEvent) {

    }

    @FXML
    public void deleteAction(ActionEvent actionEvent) {

    }

    @FXML
    public void registerAction(ActionEvent actionEvent) throws SQLException {
        String name = productnamenTXF.getText();
        String number = productNumberTXTF.getText();
        String price = priceTextfield.getText();
        String supplier = supplierTextfield.getText();
        String discount = discountTextfield.getText();
        String description = descriptionTextfield.getText();
        String produktType = productTextfield.getText();
        Product product = new Product(name, number, price, supplier, discount, description, produktType);
        productView.getItems().add(product);
        registerProduct();


    }

    //TODO insert into productregister databas
        public void registerProduct() throws SQLException {
            Statement statement = connectionDB.createStatement();
            statement.executeUpdate("INSERT INTO product "
                    + "VALUES ('" + productnamenTXF.getText()
                    + "', '" + productNumberTXTF.getText()
                    + "', '" + priceTextfield.getText()
                    + "', '" + supplierTextfield.getText()
                    + "', '" + discountTextfield.getText()
                    + "', '" + descriptionTextfield.getText()
                    + "', '" + productTextfield.getText()
                    + "')");
            connectionDB.close();
    }
}
