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

        Statement statement = connectionDB.createStatement();

        try {
            PreparedStatement ps = connectionDB.prepareStatement("SELECT Email, Password FROM Email WHERE Email = ? AND Password = ?");
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

        statement.executeUpdate("INSERT INTO Email " + "VALUES ('" + usernameTxtF.getText() + "', " + "'" + passwordTxF.getText() + "')");
        connectionDB.close();

        /*String verifyLogin  = "Select " + usernameTxtF.getText() ;

        try{
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1) ==1){
                    //loginMessageLabel.setText("Congratulations!");
                }else{
                    //loginMessageLabel.setText("Invalid login");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

    }
    public void createAccountForm(ActionEvent event) throws IOException {
        Stage stage = (Stage) newCustomerButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RegisterNewCustomer.fxml"));

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
