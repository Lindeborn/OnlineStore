package customer;

import Admin.SqlServerConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginCustomerController {
    public PasswordField passwordTxF;
    public TextField usernameTxtF;
    public Button signinBTN;
    public Button newCustomerButton;
    public SqlServerConnection ConnectNow;
    public Connection connectionDB;
    public RegisterController reg;


    public LoginCustomerController() throws SQLException, ClassNotFoundException {
        ConnectNow = new SqlServerConnection();
        connectionDB = ConnectNow.connect();

        //reg = new RegisterController(this);
    }

    public void loginButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (!usernameTxtF.getText().isBlank() && !passwordTxF.getText().isBlank()) {
            validateLogin();
            //loginMessageLabel.setText("login");
        } else {
            //loginMessageLabel.setText("Please enter username or password");
        }
    }

    public void validateLogin() throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement ps = connectionDB.prepareStatement("SELECT Email, Password FROM Customer WHERE Email = ? AND Password = ?");
            ps.setString(1, usernameTxtF.getText());
            ps.setString(2, passwordTxF.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){
                System.out.println("Login Success!");
            }
            else{
                System.out.println("Login Failed.");
            }
        } catch (SQLException ex) {
        }
    }

    public void createAccountForm(ActionEvent event) throws IOException, SQLException {
        Stage stage = (Stage) newCustomerButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RegisterNewCustomer.fxml"));

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void registerCustomer() throws SQLException {
        Statement statement = connectionDB.createStatement();
        statement.executeUpdate("INSERT INTO Customer "
                + "VALUES ('" + reg.mailTextfield.getText()
                + "', '" + reg.numberTextfield.getText()
                + "', '" + reg.firstnameTextfield.getText()
                + "', '" + reg.lastnameTextfield.getText()
                + "', '" + reg.addressTextfield.getText()
                + "', '" + reg.countryCombobox.getValue().toString()
                + "', '" + reg.cityTextfield.getText()
                + "', '" + reg.setPasswordTextfield.getText()
                + "')");
        connectionDB.close();
    }
}
