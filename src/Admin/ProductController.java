package Admin;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
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
    public TableColumn <Product, String>nameTable;
    public TableColumn <Product, String>priceTable;
    public TableColumn <Product, String>supplierTable;
    public TableColumn <Product, String>numberTable;
    public TableColumn <Product, String>discountTable;
    public TableColumn <Product, String>descritionTable;
    public TableColumn <Product, String>typeTable;
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
    //TODO remove from databas
    //Här removar vi objektet från table
    public void deleteAction(ActionEvent actionEvent) throws SQLException {
        ObservableList<Product> allProducts, singleProducts;
        allProducts = productView.getItems();
        singleProducts=productView.getSelectionModel().getSelectedItems();
        singleProducts.forEach(allProducts::remove);
        deleteProduct();

    }
    @Override

    //TODO lägga till dessa i databasen också, se registerproduct() metoden om det funkar?
    public void initialize(URL url, ResourceBundle rb) {
        nameTable.setCellValueFactory(new PropertyValueFactory<>("productname"));
        numberTable.setCellValueFactory(new PropertyValueFactory<>("productnumber"));
        priceTable.setCellValueFactory(new PropertyValueFactory<>("productprice"));
        supplierTable.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        discountTable.setCellValueFactory(new PropertyValueFactory<>("discount"));
        descritionTable.setCellValueFactory(new PropertyValueFactory<>("description"));
        typeTable.setCellValueFactory(new PropertyValueFactory<>("productType"));

    }

    @FXML
    public void registerAction(ActionEvent actionEvent) throws SQLException {
        Product product = new Product(productnamenTXF.getText(), Integer.parseInt(productNumberTXTF.getText()), Double.parseDouble(priceTextfield.getText()),supplierTextfield.getText(),
                Double.parseDouble(discountTextfield.getText()), descriptionTextfield.getText(), productTextfield.getText());
        productView.getItems().add(product);
        registerProduct();


    }

    //FUNKAR
    public void deleteProduct()throws SQLException {
        try {
            PreparedStatement st = connectionDB.prepareStatement("DELETE FROM Table WHERE [Admin].[dbo].[Product]");
            st.setString(1, "");
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //FUNKAR se till att allt stämmer överrens med ordningen i databasen!!!
       public void registerProduct() throws SQLException {
            Statement statement = connectionDB.createStatement();
            statement.executeUpdate("INSERT INTO [Admin].[dbo].[Product] "
                    + "VALUES ('" + productNumberTXTF.getText()
                    + "', '" + productnamenTXF.getText()
                    + "', '" + priceTextfield.getText()
                    + "', '" + supplierTextfield.getText()
                    + "', '" + discountTextfield.getText()
                    + "', '" + descriptionTextfield.getText()
                    + "', '" + productTextfield.getText()
                    + "')");
            connectionDB.close();
    }
}
