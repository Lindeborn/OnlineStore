package Admin;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {


    public PasswordField passwordTxF;
    public TextField usernameTxtF;
    public Button signinBTN;
    public Label loginMessageLabel;



    public void loginButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (!usernameTxtF.getText().isBlank() && !passwordTxF.getText().isBlank()) {
            validateLogin();
            //loginMessageLabel.setText("login");
        } else {
            loginMessageLabel.setText("Please enter username or password");
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
                    loginMessageLabel.setText("Congratulations!");
                }else{
                    loginMessageLabel.setText("Invalid login");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        }
}
