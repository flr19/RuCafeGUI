package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller for Your Orders view
 *
 * @author Prince Rawal
 * @author Farah Lubaba Rouf
 */

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

    public YourOrderController() {

    }

    /**
     * initializes the Your Orders view
     */

    @FXML
    private void preset() {
        if (order != null && !order.toStringList().isEmpty()) {
            ObservableList<String> orderString =
                    FXCollections.observableArrayList(order.toStringList());
            ordersList.setItems(orderString);
            subTotal.clear();
            salesTax.clear();
            total.clear();
            subTotal.appendText("$ " + String.format("%.2f", order.getTotalPrice()));
            salesTax.appendText("$ " + String.format("%.2f", order.getTotalPrice() * 0.06625));
            total.appendText("$ " + String.format("%.2f", (order.getTotalPrice() + order.getTotalPrice() * 0.06625)));
        } else {
            subTotal.clear();
            salesTax.clear();
            total.clear();
            ordersList.getItems().clear();
            subTotal.appendText("$ " + 0.00);
            salesTax.appendText("$ " + 0.00);
            total.appendText("$ " + 0.00);
        }

    }

    /**
     * Place an order
     */

    @FXML
    void addToStore(ActionEvent event) {
        if (order.emptyOrder()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No orders here");
            alert.setContentText("Please place an order.");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Order Placed");
        alert.setContentText("Finished placing all orders.");
        alert.showAndWait();
        storeOrders.add(order.copyOfOrder());
        order.resetOrder();
        preset();
    }

    /**
     * Remove selected item from orders list
     */

    @FXML
    void removeSelectedItem(ActionEvent event) {
        if (ordersList.getSelectionModel().getSelectedItem() != null) {
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
                subTotal.appendText("$ " + String.format("%.2f", order.getTotalPrice()));
                salesTax.appendText("$ " + String.format("%.2f", order.getTotalPrice() * 0.06625));
                total.appendText("$ " + String.format("%.2f", (order.getTotalPrice() + order.getTotalPrice() * 0.06625)));
            } else {
                ordersList.getItems().clear();
                subTotal.clear();
                salesTax.clear();
                total.clear();
                subTotal.appendText("$ " + 0.00);
                salesTax.appendText("$ " + 0.00);
                total.appendText("$ " + 0.00);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No orders here");
            alert.setContentText("Please select an order to remove.");
            alert.showAndWait();
            return;
        }
    }

    /**
     * Sets controller to main controller
     *
     * @param storeFrontController object reference to main controller
     */

    public void setMainController(StoreFrontController storeFrontController) {
        mainController = storeFrontController;
        order = mainController.order;
        storeOrders = mainController.storeOrders;
        preset();
    }
}
