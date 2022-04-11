package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreOrdersController {

    private StoreOrders orders;

    @FXML
    private TextField getTotalCost;

    @FXML
    private ComboBox<Integer> orderNumber;

    @FXML
    private ListView<String> ordersList;

    public StoreOrdersController(){
        //nothing
    }

    @FXML
    private void initialize(){
        ordersList = new ListView<String>();
        ObservableList<Integer> orderNums =
                        FXCollections.observableArrayList(orders.getOrderNumber());
        orderNumber = new ComboBox<Integer>();
        orderNumber.setItems(orderNums);
        getTotalCost.appendText("$ " + 0.0);
    }

    @FXML
    void cancelSelectedOrder(ActionEvent event) {
        orders.remove(orderNumber.getSelectionModel().getSelectedItem());
        ordersList = new ListView<String>();
        ObservableList<Integer> orderNums =
                FXCollections.observableArrayList(orders.getOrderNumber());
        orderNumber = new ComboBox<Integer>();
        orderNumber.setItems(orderNums);
        getTotalCost.clear();
        getTotalCost.appendText("$ " + 0.0);
    }

    @FXML
    void exportOrder(ActionEvent event) {
        //farah writes the code
    }

    @FXML
    void showOrder(ActionEvent event) {
        int orderN = orderNumber.getSelectionModel().getSelectedItem();
        ObservableList<String> orderDetails =
                FXCollections.observableArrayList(orders.getOrder(orderN));
        ordersList = new ListView<String>(orderDetails);
        getTotalCost.clear();
        getTotalCost.appendText("$ " + orders.getCost(orderN));
    }

}
