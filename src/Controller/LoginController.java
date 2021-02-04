package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {


    public PasswordField passwordTxF;
    public Label forgotPasswordBTN;
    public TextField usernameTxtF;
    public Button signinBTN;
    public Label loginMessageLabel;



    public void loginButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (usernameTxtF.getText().isBlank() == false && passwordTxF.getText().isBlank() == false) {
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username or password");
        }
    }

        public void validateLogin() throws SQLException, ClassNotFoundException {
        SqlServerConnection connectionNow = new SqlServerConnection();
            Connection connectionDB = connectionNow.connect();

    }
}
