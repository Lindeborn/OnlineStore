package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class LoginController {
    public PasswordField passwordTxF;
    public TextField usernameTxtF;
    public Button signinBTN;
    public Label loginMessageLabel;
    public Button cancelBTN;
    private Connection connectionDB;
    private SqlServerConnection ConnectNow;



    public void loginButtonAction(ActionEvent actionEvent) throws IOException {
        if ((usernameTxtF.getText().equals("Admin")) && (passwordTxF.getText().equals("Admin123"))) {
            Stage stage = (Stage) signinBTN.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("ProductPanel.fxml"));
            Scene scene = new Scene(root, 900, 400);
            stage.setScene(scene);
            stage.show();
        }else if (usernameTxtF.getText().isBlank() || passwordTxF.getText().isBlank()) {
            loginMessageLabel.setText("Please enter username and password");
        }else {
            loginMessageLabel.setText("Wrong username or password");
        }
    }


    public void CancelButtonAction(ActionEvent actionEvent) {
    Stage stage = (Stage) cancelBTN.getScene().getWindow();
    stage.close();
    }
}
