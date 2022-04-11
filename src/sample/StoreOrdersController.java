package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Optional;

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
        //no orders to cancel, show alert
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No orders here");
            alert.setContentText("No orders to cancel.");
            alert.showAndWait();
            return;
        }
    }

    @FXML
    void exportOrder(ActionEvent event) throws FileNotFoundException {
        if(storeOrders.getSize()==0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No orders here");
            alert.setContentText("No orders to export.");
            alert.showAndWait();
            return;
        }
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File for the Export");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targetFile = chooser.showSaveDialog(stage);
       PrintWriter pw = new PrintWriter(targetFile);
       pw.print(storeOrders.stringForExportingOrders(storeOrders.toStringList()));
      //  pw.print(storeOrders.toStringList());
        pw.close();

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
            getTotalCost.appendText("$ " + String.format("%.2f", storeOrders.getCost(orderN)));
        }
    }

    public void setMainController(StoreFrontController storeFrontController) {
        mainController = storeFrontController;
        storeOrders = mainController.storeOrders;
        preset();
    }

}
