package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for Store Front view
 *
 * @author Prince Rawal
 * @author Farah Lubaba Rouf
 */

public class StoreFrontController {

    protected static StoreOrders storeOrders;
    protected static Order order;
    @FXML
    private ImageView coffeeBanner;

    @FXML
    private ImageView storeOrdersBanner;

    @FXML
    private ImageView yourOrderBanner;

    Image coffeePic= new Image("file:pics/coffeee.jpg");
    Image yourOrdersPic = new Image("file:pics/yourOrders.jpg");
    Image storeOrdersPic = new Image("file:pics/storeOrders.png");



    /**
     * initializes the Store Front view
     */

    @FXML
    public void initialize() {
        coffeeBanner.setImage(coffeePic);
        storeOrdersBanner.setImage(storeOrdersPic);
        yourOrderBanner.setImage(yourOrdersPic);
        order = new Order();
        storeOrders = new StoreOrders();
    }

    /**
     * Loads the Order Coffee page
     */

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

    /**
     * Loads the order donuts view
     */

    @FXML
    void orderDonuts(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderDonuts.fxml"));
        Parent root = loader.load();
        OrderDonutsController orderDonutsController = loader.getController();
        orderDonutsController.setMainController(this);
        Stage stage = new Stage();
        stage.setTitle("Order Donuts!!");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    /**
     * Loads the store orders view
     */

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

    /**
     * Loads the your orders view
     */

    @FXML
    void yourOrder(ActionEvent event) throws IOException {
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
