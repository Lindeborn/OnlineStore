package customer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class ShopController {
    public Button addButton;
    public Button removeButton;
    public ListView basketList = new ListView();
    public ListView itemsList = new ListView();
    public Button editButton;

    public ShopController(){
        basketList.getItems().addAll("Hawaii", "Calzone", "Kebabpizza", "Vegeteriana");
        basketList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void addAction(ActionEvent actionEvent) {
    }

    public void removeAction(ActionEvent actionEvent) {
    }

    public void editAction(ActionEvent actionEvent) {
    }
}
