package customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;


public class RegisterController {
    @FXML
    public Button registerButton;
    @FXML
    public TextField firstnameTextfield;
    @FXML
    public TextField mailTextfield;
    @FXML
    public TextField numberTextfield;
    @FXML
    public TextField addressTextfield;
    @FXML
    public TextField lastnameTextfield;
    @FXML
    public TextField cityTextfield;
    @FXML
    public ComboBox countryCombobox;
    @FXML
    public PasswordField setPasswordTextfield;
    public PasswordField passwordTextfield1;
    @FXML
    public Button clearAllBTN;
    public Label newUserLBL;

    public Label confirmPWLBL;
    public LoginCustomerController lgCustomer;

    public RegisterController(LoginCustomerController lgCustomer){
        this.lgCustomer = lgCustomer;
    }

    public void registerActionEvent(ActionEvent actionEvent) throws SQLException {
        //newUserLBL.setText("User has been registered successfully");
        lgCustomer.registerCustomer();
        //registerUser();

    }

    private void registerUser() {
        if (setPasswordTextfield.getText().equals(passwordTextfield1.getText())){
            confirmPWLBL.setText("You are set");
        }  else {
            confirmPWLBL.setText("Password does not match");
        }
    }

    
    public void clearAction(ActionEvent actionEvent) {
        firstnameTextfield.setText("");
        lastnameTextfield.setText("");
        mailTextfield.setText("");
        numberTextfield.setText("");
        addressTextfield.setText("");
        cityTextfield.setText("");
        countryCombobox.setButtonCell(null);
        setPasswordTextfield.setText("");
    }
}
