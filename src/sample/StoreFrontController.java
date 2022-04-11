package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreFrontController{

    protected static StoreOrders storeOrders;
    protected static Order order;

    @FXML
    public void initialize() {
        order = new Order();
        storeOrders = new StoreOrders();
    }

    @FXML
    void orderCoffee(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderingCoffee.fxml"));
        Parent root = loader.load();
        CoffeeController coffeeController = loader.getController();
        coffeeController.setMainController(this);
        Stage stage = new Stage();
        stage.setTitle("Order Coffee!!");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    @FXML
    void orderDonuts(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderDonuts.fxml"));
        Parent root = loader.load();
        OrderDonutsController orderDonutsController= loader.getController();
        orderDonutsController.setMainController(this);
        Stage stage = new Stage();
        stage.setTitle("Order Donuts!!");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    @FXML
    void storeOrders(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrders.fxml"));
        Parent root = loader.load();
        StoreOrdersController storeOrdersController = loader.getController();
        storeOrdersController.setMainController(this);
        Stage stage = new Stage();
        stage.setTitle("Manage Store");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    @FXML
    void yourOrder(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("YourOrder.fxml"));
        Parent root = loader.load();
        YourOrderController yourOrderController = loader.getController();
        yourOrderController.setMainController(this);
        Stage stage = new Stage();
        stage.setTitle("Finish Your Order!!");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

}
