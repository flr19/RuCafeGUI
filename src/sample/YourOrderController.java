package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class YourOrderController {

    private static StoreFrontController mainController;

    private static Order order;

    private static StoreOrders storeOrders;

    @FXML
    private ListView<String> ordersList;

    @FXML
    private TextField salesTax;

    @FXML
    private TextField subTotal;

    @FXML
    private TextField total;

    public YourOrderController(){

    }

    @FXML
    private void preset(){
        if(order != null && !order.toStringList().isEmpty()){
            ObservableList<String> orderString =
                    FXCollections.observableArrayList(order.toStringList());
            ordersList.setItems(orderString);
            subTotal.clear();
            salesTax.clear();
            total.clear();
            subTotal.appendText("$ " + order.getTotalPrice());
            salesTax.appendText("$ " + order.getTotalPrice()*0.06625);
            total.appendText("$ " + (order.getTotalPrice() + order.getTotalPrice()*0.06625));
        }
        else {
            subTotal.clear();
            salesTax.clear();
            total.clear();
            ordersList.getItems().clear();
            subTotal.appendText("$ " + 0.00);
            salesTax.appendText("$ " + 0.00);
            total.appendText("$ " + 0.00);
        }

    }

    @FXML
    void addToStore(ActionEvent event) {
        storeOrders.add(order.copyOfOrder());
        order.resetOrder();
        preset();
    }

    @FXML
    void removeSelectedItem(ActionEvent event) {
        if(ordersList.getSelectionModel().getSelectedItem() != null) {
            String item = ordersList.getSelectionModel().getSelectedItem();
            //getting item number from the string (format -> "Item #: ...")
            int currIndex = 5;
            while (item.charAt(currIndex) != ':') {
                currIndex++;
            }
            order.remove(Integer.parseInt(item.substring(5, currIndex)) - 1);
            if (!order.toStringList().isEmpty()) {
                ObservableList<String> orderString =
                        FXCollections.observableArrayList(order.toStringList());
                ordersList.setItems(orderString);
                subTotal.clear();
                salesTax.clear();
                total.clear();
                subTotal.appendText("$ " + order.getTotalPrice());
                salesTax.appendText("$ " + order.getTotalPrice() * 0.06625);
                total.appendText("$ " + (order.getTotalPrice() + order.getTotalPrice() * 0.06625));
            } else {
                ordersList.getItems().clear();
                subTotal.clear();
                salesTax.clear();
                total.clear();
                subTotal.appendText("$ " + 0.00);
                salesTax.appendText("$ " + 0.00);
                total.appendText("$ " + 0.00);
            }
        }
    }

    public void setMainController(StoreFrontController storeFrontController) {
        mainController = storeFrontController;
        order = mainController.order;
        storeOrders = mainController.storeOrders;
        preset();
    }
}
