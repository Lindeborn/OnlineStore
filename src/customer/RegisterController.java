package customer;

import Admin.SqlServerConnection;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class RegisterController {
    @FXML
    public Button registerButton;
    @FXML
    public TextField firstnameTextfield;
    @FXML
    public TextField mailTextfield;
    @FXML
    public TextField numberTextfield;
    @FXML
    public TextField addressTextfield;
    @FXML
    public TextField lastnameTextfield;
    @FXML
    public TextField cityTextfield;
    @FXML
    public ComboBox countryCombobox;
    @FXML
    public PasswordField setPasswordTextfield;
    public PasswordField passwordTextfield1;
    @FXML
    public Button clearAllBTN;
    public Label newUserLBL;

    public Label confirmPWLBL;

    private SqlServerConnection ConnectNow;
    private Connection connectionDB;

    public RegisterController() throws SQLException, ClassNotFoundException {
        ConnectNow = new SqlServerConnection();
        connectionDB = ConnectNow.connect();
    }

    public void registerActionEvent(ActionEvent actionEvent) throws SQLException, IOException {
        registerCustomer();
        registerUser();

    }

    private void registerUser() throws IOException {
        if (setPasswordTextfield.getText().equals(passwordTextfield1.getText())){
            System.out.println("you are set");
            Stage stage = (Stage) registerButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("ShopCustomer.fxml"));

            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();

        }  else {
            confirmPWLBL.setText("Password does not match");
        }
    }


    public void clearAction(ActionEvent actionEvent) {
        firstnameTextfield.setText("");
        lastnameTextfield.setText("");
        mailTextfield.setText("");
        numberTextfield.setText("");
        addressTextfield.setText("");
        cityTextfield.setText("");
        countryCombobox.setButtonCell(null);
        setPasswordTextfield.setText("");
    }


    public void registerCustomer() throws SQLException {
        Statement statement = connectionDB.createStatement();
        statement.executeUpdate("INSERT INTO Customer "
                + "VALUES ('" + mailTextfield.getText()
                + "', '" + numberTextfield.getText()
                + "', '" + firstnameTextfield.getText()
                + "', '" + lastnameTextfield.getText()
                + "', '" + addressTextfield.getText()
                + "', '" + countryCombobox.getValue().toString()
                + "', '" + cityTextfield.getText()
                + "', '" + setPasswordTextfield.getText()
                + "')");
        connectionDB.close();
    }

    public void countryCombobox(ActionEvent actionEvent) {
        countryCombobox.setItems( FXCollections.observableArrayList( Countries.values()));
        countryCombobox.getItems().setAll(Countries.values());

    }
}
