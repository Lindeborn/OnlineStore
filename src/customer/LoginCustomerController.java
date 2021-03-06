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
    }

    public void loginButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (!usernameTxtF.getText().isBlank() && !passwordTxF.getText().isBlank()) {
            validateLogin();
        } else {
            //loginMessageLabel.setText("Please enter username or password");
        }
    }

    public void validateLogin() {
        try {
            PreparedStatement ps = connectionDB.prepareStatement("SELECT Email, Password FROM Customer WHERE Email = ? AND Password = ?");
            ps.setString(1, usernameTxtF.getText());
            ps.setString(2, passwordTxF.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){
                System.out.println("Login Success!");
                Stage stage = (Stage) signinBTN.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("ShopCustomer.fxml"));
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();
            }
            else{
                System.out.println("Login Failed.");
            }
        } catch (SQLException | IOException ex) {
        }
    }

    public void createAccountForm(ActionEvent event) throws IOException {
        Stage stage = (Stage) newCustomerButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RegisterNewCustomer.fxml"));

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
