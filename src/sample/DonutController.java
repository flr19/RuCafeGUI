package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DonutController {

    private ObservableList<Integer> quant =
            FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    private ObservableList<String> donutTypes =
            FXCollections.observableArrayList("Yeast Donuts", "Cake Donuts", "Donut Holes");

    private ObservableList<String> typeYeast=
            FXCollections.observableArrayList("Glazed Chocolate", "Vanilla Creme", "Strawberry Frosted", "Jelly");

    private ObservableList<String> typeCake=
            FXCollections.observableArrayList("Chocolate", "Mango", "Sugar", "Jelly");

    private ObservableList<String> typeHole=
            FXCollections.observableArrayList("Glazed", "Vanilla", "Jelly", "Sugar");

    private Order currOrder = new Order();

    Image yeastDonutImage = new Image("");
    Image cakeDonutImage = new Image("");
    Image donutHolesImage = new Image("");

    @FXML
    private ListView<String> availableDonuts;

    @FXML
    private ImageView imageBanner;

    @FXML
    private ComboBox<Integer> quantity;

    @FXML
    private ComboBox<String> selectDonutType;

    @FXML
    private ListView<String> selectedDonuts;

    @FXML
    private TextField subTotal;

    public DonutController() {
        System.out.println("first");
    }

    @FXML
    public void initialize() {
        imageBanner = new ImageView(yeastDonutImage);

        selectDonutType = new ComboBox<String>();
        selectDonutType.setItems(donutTypes);
        selectDonutType.getSelectionModel().select("Yeast Donut");

        availableDonuts = new ListView<String>(typeYeast);

        quantity = new ComboBox<Integer>();
        quantity.setItems(quant);
        quantity.getSelectionModel().select(1);

        currOrder = new Order();
    }

    @FXML
    void addDonutOrder(ActionEvent event) {
        //return currOrder to the main controller
    }

    @FXML
    void removeDonuts(ActionEvent event) {
        String donutType = selectDonutType.getSelectionModel().getSelectedItem();
        String donutSelected = selectedDonuts.getSelectionModel().getSelectedItem();
        int currIndex = 0;
        int commaIndex = 0;
        while(currIndex < donutSelected.length()){
            if(donutSelected.charAt(currIndex) == ','){
                commaIndex = currIndex;
            }
            currIndex++;
        }
        int numDonuts = Integer.parseInt(donutSelected.substring(commaIndex + 2));
        String donutFlavor = donutSelected.substring(0, commaIndex);

        Donut donut;
        if(donutType.equals("Yeast Donuts")){
            donut = new Donut(1, donutFlavor, numDonuts);
        }
        else if(donutType.equals("Cake Donuts")){
            donut = new Donut(2, donutFlavor, numDonuts);
        }
        else{
            donut = new Donut(3, donutFlavor, numDonuts);
        }
        currOrder.remove(donut);
        selectedDonuts.getItems().remove(donutSelected);
        availableDonuts.getItems().add(donutFlavor);
        subTotal.clear();
        subTotal.appendText("$ " + currOrder.getTotalPrice());

        quantity.getSelectionModel().select(1);

    }

    @FXML
    void selectDonuts(ActionEvent event) {
        String donutType = selectDonutType.getSelectionModel().getSelectedItem();
        String donutFlavor = availableDonuts.getSelectionModel().getSelectedItem();
        int numDonuts = quantity.getSelectionModel().getSelectedItem();
        Donut donut;
        if(donutType.equals("Yeast Donuts")){
            donut = new Donut(1, donutFlavor, numDonuts);
        }
        else if(donutType.equals("Cake Donuts")){
            donut = new Donut(2, donutFlavor, numDonuts);
        }
        else{
            donut = new Donut(3, donutFlavor, numDonuts);
        }
        currOrder.add(donut);
        selectedDonuts.getItems().add(donutFlavor + ", " + quantity);
        availableDonuts.getItems().remove(donutFlavor);
        subTotal.clear();
        subTotal.appendText("$ " + currOrder.getTotalPrice());

        quantity.getSelectionModel().select(1);
    }

    @FXML
    void viewTypeDonut(ActionEvent event) {
        String selected = selectDonutType.getSelectionModel().getSelectedItem();
        if(selected.equals("Yeast Donuts")){
            availableDonuts = new ListView<String>(typeYeast);
            imageBanner = new ImageView(yeastDonutImage);
        }
        else if(selected.equals("Cake Donuts")){
            availableDonuts = new ListView<String>(typeCake);
            imageBanner = new ImageView(cakeDonutImage);
        }
        else{
            availableDonuts = new ListView<String>(typeHole);
            imageBanner = new ImageView(donutHolesImage);
        }
        selectedDonuts = new ListView<String>();
        quantity.getSelectionModel().select(1);
        subTotal.clear();
        currOrder = new Order();
    }

}
