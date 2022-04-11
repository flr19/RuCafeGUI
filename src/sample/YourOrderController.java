package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class YourOrderController {

    private Order currOrder;

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
    private void initialize(){
        if(!currOrder.toStringList().isEmpty()){
            ObservableList<String> order =
                    FXCollections.observableArrayList(currOrder.toStringList());
            ordersList = new ListView<String>(order);
            subTotal.appendText("$ " + currOrder.getTotalPrice());
            salesTax.appendText("$ " + currOrder.getTotalPrice()*0.06625);
            total.appendText("$ " + (currOrder.getTotalPrice() + currOrder.getTotalPrice()*0.06625));
        }
        else {
            ordersList = new ListView<String>();
            subTotal.appendText("$ " + 0.00);
            salesTax.appendText("$ " + 0.00);
            total.appendText("$ " + 0.00);
        }

    }

    @FXML
    void addToStore(ActionEvent event) {
        //Add order to the store orders list
    }

    @FXML
    void removeSelectedItem(ActionEvent event) {
        String item = ordersList.getSelectionModel().getSelectedItem();
        //getting item number from the string (format -> "Item #: ...")
        int currIndex = 5;
        while(item.charAt(currIndex) != ':'){
            currIndex++;
        }
        currOrder.remove(Integer.parseInt(item.substring(5, currIndex))-1);
        if(!currOrder.toStringList().isEmpty()) {
            ObservableList<String> order =
                    FXCollections.observableArrayList(currOrder.toStringList());
            ordersList = new ListView<String>(order);
            subTotal.appendText("$ " + currOrder.getTotalPrice());
            salesTax.appendText("$ " + currOrder.getTotalPrice() * 0.06625);
            total.appendText("$ " + (currOrder.getTotalPrice() + currOrder.getTotalPrice() * 0.06625));
        }
        else {
            ordersList = new ListView<String>();
            subTotal.appendText("$ " + 0.00);
            salesTax.appendText("$ " + 0.00);
            total.appendText("$ " + 0.00);
        }
    }

}
