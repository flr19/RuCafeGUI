package sample;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CoffeeController {

    private ObservableList<Integer> quant =
            FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    private ObservableList<String> sizes =
            FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");

    private Coffee currCoffee;

    Image image = new Image("");

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

    public CoffeeController() {
        System.out.println("first");
    }

    @FXML
    public void initialize() {
        coffeeImage = new ImageView();
        coffeeImage = new ImageView(image);

        coffeeSize = new ComboBox<String>();
        coffeeSize.setItems(sizes);
        coffeeSize.getSelectionModel().select("Short");

        quantity = new ComboBox<Integer>();
        quantity.setItems(quant);
        quantity.getSelectionModel().select(1);

        currCoffee = new Coffee(1, 1); //1 short coffee
    }

    @FXML
    void addToOrder(ActionEvent event) {
        //send coffee to the current order
    }

    @FXML
    void updateCaramel(ActionEvent event) {
        if(hasCaramel.isSelected()){
            currCoffee.add("Caramel");
        }
        else{
            currCoffee.remove("Caramel");
        }
        subTotal.clear();
        subTotal.appendText("$ " + currCoffee.itemPrice());
    }

    @FXML
    void updateCream(ActionEvent event) {
        if(hasCream.isSelected()){
            currCoffee.add("Cream");
        }
        else{
            currCoffee.remove("Cream");
        }
        subTotal.clear();
        subTotal.appendText("$ " + currCoffee.itemPrice());
    }

    @FXML
    void updateMilk(ActionEvent event) {
        if(hasMilk.isSelected()){
            currCoffee.add("Milk");
        }
        else{
            currCoffee.remove("Milk");
        }
        subTotal.clear();
        subTotal.appendText("$ " + currCoffee.itemPrice());
    }

    @FXML
    void updateQuantity(ActionEvent event) {
        int numCoffee = quantity.getSelectionModel().getSelectedItem();
        currCoffee.setNumItems(numCoffee);

        subTotal.clear();
        subTotal.appendText("$ " + currCoffee.itemPrice());
    }

    @FXML
    void updateSize(ActionEvent event) {
        String size = coffeeSize.getSelectionModel().getSelectedItem();
        currCoffee.setSize(size);

        subTotal.clear();
        subTotal.appendText("$ " + currCoffee.itemPrice());
    }

    @FXML
    void updateSyrup(ActionEvent event) {
        if(hasSyrup.isSelected()){
            currCoffee.add("Syrup");
        }
        else{
            currCoffee.remove("Syrup");
        }
        subTotal.clear();
        subTotal.appendText("$ " + currCoffee.itemPrice());
    }

    @FXML
    void updateWhippedCream(ActionEvent event) {
        if(hasWhippedCream.isSelected()){
            currCoffee.add("Whipped Cream");
        }
        else{
            currCoffee.remove("Whipped Cream");
        }
        subTotal.clear();
        subTotal.appendText("$ " + currCoffee.itemPrice());
    }

}
