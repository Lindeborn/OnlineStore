package Controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class LoginController {


    public PasswordField passwordTxF;
    public Label forgotPasswordBTN;
    public TextField usernameTxtF;
    public Button signinBTN;
    public Label loginMessageLabel;



    public void loginButtonAction(ActionEvent actionEvent) {
        if (usernameTxtF.getText().isBlank() == false && passwordTxF.getText().isBlank() == false) {
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username or password");
        }
    }

        public void validateLogin(){


    }
}
