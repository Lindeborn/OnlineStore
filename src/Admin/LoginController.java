package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class LoginController implements Initializable {


    public PasswordField passwordTxF;
    public TextField usernameTxtF;
    public Button signinBTN;
    public Label loginMessageLabel;
    public Button cancelBTN;
    public ImageView shieldImangeView;

    public LoginController() throws SQLException, ClassNotFoundException {
        SqlServerConnection ConnectNow = new SqlServerConnection();
        Connection connectionDB = ConnectNow.connect();
        Statement statement = connectionDB.createStatement();
    }


    public void loginButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        if (!usernameTxtF.getText().isBlank() && !passwordTxF.getText().isBlank()) {
            validateLogin();
            //loginMessageLabel.setText("login");
        } else {
            loginMessageLabel.setText("Please enter username or password");
        }
    }

        public void validateLogin() throws SQLException, ClassNotFoundException, IOException {
            if ((usernameTxtF.getText().equals("Admin")) && (passwordTxF.getText().equals("Admin123"))) {
                Stage stage = (Stage) signinBTN.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("ProductPanel.fxml"));
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();
            } else {
                System.out.println("login failure");

            }
        }

    public void CancelButtonAction(ActionEvent actionEvent) {
    Stage stage = (Stage) cancelBTN.getScene().getWindow();
    stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File shieldFile = new File("Images/key.png");
        Image shieldImange = new Image(shieldFile.toURI().toString());
        shieldImangeView.setImage(shieldImange);
    }
}
