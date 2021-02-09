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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginCustomerController {
    public PasswordField passwordTxF;
    public TextField usernameTxtF;
    public Button signinBTN;
    public Button newCustomerButton;


    public void loginButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (!usernameTxtF.getText().isBlank() && !passwordTxF.getText().isBlank()) {
            validateLogin();
            //loginMessageLabel.setText("login");
        } else {
            //loginMessageLabel.setText("Please enter username or password");
        }
    }

    public void validateLogin() throws SQLException, ClassNotFoundException {
        SqlServerConnection ConnectNow = new SqlServerConnection();
        Connection connectionDB = ConnectNow.connect();

        String verifyLogin  = "Select " + usernameTxtF.getText();

        try{
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1) ==1){
                   createAccountForm();
                    //loginMessageLabel.setText("Congratulations!");
                    createAccountForm();
                }else{
                    //loginMessageLabel.setText("Invalid login");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void createAccountForm() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("RegisterNewCustomer.fxml"));
            Stage registerStage = new Stage();
            registerStage.setTitle("Hello World");
            registerStage.setScene(new Scene(root, 500, 400));
            registerStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
