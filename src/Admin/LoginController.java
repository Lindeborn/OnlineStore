package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
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

        Statement statement = connectionDB.createStatement();

            try {
                PreparedStatement ps = connectionDB.prepareStatement("SELECT Email, Password FROM Email WHERE Email = ? AND Password = ?");
                ps.setString(1, usernameTxtF.getText());
                ps.setString(2, passwordTxF.getText());
                ResultSet result = ps.executeQuery();
                if(result.next()){
                    loginMessageLabel.setText("Congratulations!");
                }
                else{
                    loginMessageLabel.setText("Invalid login");
                }
            } catch (SQLException ex) {
            }

        statement.executeUpdate("INSERT INTO Email " + "VALUES ('" + usernameTxtF.getText() + "', " + "'" + passwordTxF.getText() + "')");
        connectionDB.close();

        /*String verifyLogin  = "Select " + usernameTxtF.getText();

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
        }*/
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
