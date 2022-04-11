package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreOrdersController {

    private static StoreFrontController mainController;

    private static StoreOrders storeOrders;

    @FXML
    private TextField getTotalCost;

    @FXML
    private ComboBox<Integer> orderNumber;

    @FXML
    private ListView<String> ordersList;

    @FXML
    private void preset(){
        ordersList.getItems().clear();
        ObservableList<Integer> orderNums =
                        FXCollections.observableArrayList(storeOrders.getOrderNumber());
        orderNumber.setItems(orderNums);
        getTotalCost.clear();
        getTotalCost.appendText("$ " + 0.0);
    }

    @FXML
    void cancelSelectedOrder(ActionEvent event) {
        if(orderNumber.getSelectionModel().getSelectedItem() != null) {
            storeOrders.remove(orderNumber.getSelectionModel().getSelectedItem());
            preset();
        }
    }

    @FXML
    void exportOrder(ActionEvent event) {
        //farah writes the code
        return;
    }

    @FXML
    void showOrder(ActionEvent event) {
        if(orderNumber.getSelectionModel().getSelectedItem() != null) {
            int orderN = orderNumber.getSelectionModel().getSelectedItem();
            ObservableList<String> orderDetails =
                    FXCollections.observableArrayList(storeOrders.getOrder(orderN));
            ordersList.setItems(orderDetails);
            getTotalCost.clear();
            getTotalCost.appendText("$ " + storeOrders.getCost(orderN));
        }
    }

    public void setMainController(StoreFrontController storeFrontController) {
        mainController = storeFrontController;
        storeOrders = mainController.storeOrders;
        preset();
    }

}
