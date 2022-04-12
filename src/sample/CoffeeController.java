package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Controller for ordering coffee view
 *
 * @author Prince Rawal
 * @author Farah Lubaba Rouf
 */

public class CoffeeController {

    private ObservableList<Integer> quant =
            FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    private ObservableList<String> sizes =
            FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");

    private Coffee currCoffee;

    private static StoreFrontController mainController;

    private static Order order;

    Image image = new Image("file:download.jpg");

    @FXML
    private ImageView coffeeImage;

    @FXML
    private ComboBox<String> coffeeSize;

    @FXML
    private CheckBox hasCaramel;

    @FXML
    private CheckBox hasCream;

    @FXML
    private CheckBox hasMilk;

    @FXML
    private CheckBox hasSyrup;

    @FXML
    private CheckBox hasWhippedCream;

    @FXML
    private ComboBox<Integer> quantity;

    @FXML
    private TextField subTotal;

    Image coffeePic = new Image("file:pics/150929101049-black-coffee-stock.jpg");

    /**
     * initializes the Order Coffee view
     */

    @FXML
    public void preset() {

        currCoffee = new Coffee(1, 1); //1 short coffee

        coffeeImage.setImage(coffeePic);
        hasMilk.setSelected(false);
        hasSyrup.setSelected(false);
        hasCaramel.setSelected(false);
        hasCream.setSelected(false);
        hasWhippedCream.setSelected(false);

        //coffeeImage.setImage(image);

        coffeeSize.setItems(sizes);
        coffeeSize.getSelectionModel().select("Short");

        quantity.setItems(quant);
        quantity.getSelectionModel().select(0);

        subTotal.clear();
        subTotal.appendText("$ " + String.format("%.2f", currCoffee.itemPrice()));
    }

    /**
     * adds a coffee to the order
     */

    @FXML
    void addToOrder(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Order Success");
        alert.setHeaderText("Successfully added");
        alert.setContentText("Coffee added to order.");
        alert.showAndWait();
        order.add(currCoffee);
        preset();
    }

    /**
     * adds caramel if caramel is ticked
     */

    @FXML
    void updateCaramel(ActionEvent event) {
        if(hasCaramel.isSelected()){
            currCoffee.add("Caramel");
        }
        else{
            currCoffee.remove("Caramel");
        }
        subTotal.clear();
        subTotal.appendText("$ " + String.format("%.2f", currCoffee.itemPrice()));
    }

    /**
     * adds cream if it is ticked
     */

    @FXML
    void updateCream(ActionEvent event) {
        if(hasCream.isSelected()){
            currCoffee.add("Cream");
        }
        else{
            currCoffee.remove("Cream");
        }
        subTotal.clear();
        subTotal.appendText("$ " + String.format("%.2f", currCoffee.itemPrice()));
    }

    /**
     * adds milk if it is ticked
     */

    @FXML
    void updateMilk(ActionEvent event) {
        if(hasMilk.isSelected()){
            currCoffee.add("Milk");
        }
        else{
            currCoffee.remove("Milk");
        }
        subTotal.clear();
        subTotal.appendText("$ " + String.format("%.2f", currCoffee.itemPrice()));
    }

    /**
     * increases quantity according to what is chosen
     */

    @FXML
    void updateQuantity(ActionEvent event) {
        int numCoffee = quantity.getSelectionModel().getSelectedItem();
        currCoffee.setNumItems(numCoffee);

        subTotal.clear();
        subTotal.appendText("$ " + String.format("%.2f", currCoffee.itemPrice()));
    }

    /**
     * increases size of coffee
     */

    @FXML
    void updateSize(ActionEvent event) {
        String size = coffeeSize.getSelectionModel().getSelectedItem();
        currCoffee.setSize(size);

        subTotal.clear();
        subTotal.appendText("$ " + String.format("%.2f", currCoffee.itemPrice()));
    }

    /**
     * adds syrup if it is ticked
     */

    @FXML
    void updateSyrup(ActionEvent event) {
        if(hasSyrup.isSelected()){
            currCoffee.add("Syrup");
        }
        else{
            currCoffee.remove("Syrup");
        }
        subTotal.clear();
        subTotal.appendText("$ " + String.format("%.2f", currCoffee.itemPrice()));
    }

    /**
     * adds whipped cream if it is ticked
     */

    @FXML
    void updateWhippedCream(ActionEvent event) {
        if(hasWhippedCream.isSelected()){
            currCoffee.add("Whipped Cream");
        }
        else{
            currCoffee.remove("Whipped Cream");
        }
        subTotal.clear();
        subTotal.appendText("$ " + String.format("%.2f", currCoffee.itemPrice()));
    }

    /**
     * Sets controller to main controller
     * @param storeFrontController object reference to main controller
     */

    public void setMainController(StoreFrontController storeFrontController) {
        mainController = storeFrontController;
        order = mainController.order;
        preset();
    }
}
