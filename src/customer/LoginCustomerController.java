package customer;

import Admin.SqlServerConnection;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

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
                    //loginMessageLabel.setText("Congratulations!");
                }else{
                    //loginMessageLabel.setText("Invalid login");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void createAccountForm(ActionEvent event) throws IOException {
        Scene scenes = newCustomerButton.getScene();
        Window window = scenes.getWindow();
        Stage stages = (Stage) window;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterNewCostumer.fxml")); // create and load() view
        Stage stage = (Stage) newCustomerButton.getScene().getWindow();
        Scene scene = new Scene(loader.getRoot());
        stage.setScene(scene);
    }
}
