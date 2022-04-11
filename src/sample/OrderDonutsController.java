package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderDonutsController{


    private static StoreFrontController mainController;

    private static Order order;

    private ObservableList<Integer> quant =
            FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    private ObservableList<String> donutTypes =
            FXCollections.observableArrayList("Yeast Donuts", "Cake Donuts", "Donut Holes");

    private ObservableList<String> typeYeast;

    private ObservableList<String> typeCake=
            FXCollections.observableArrayList("Chocolate", "Mango", "Sugar", "Jelly");

    private ObservableList<String> typeHole=
            FXCollections.observableArrayList("Glazed", "Vanilla", "Jelly", "Sugar");

    private Order currOrder = new Order();

    Image yeastDonutImage = new Image("file:download.jpg");
    Image cakeDonutImage = new Image("file:download.jpg");
    Image donutHolesImage = new Image("file:download.jpg");

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

    @FXML
    public void initialize(){

        typeYeast = FXCollections.observableArrayList
                ("Glazed Chocolate", "Vanilla Creme", "Strawberry Frosted", "Jelly");

        typeCake = FXCollections.observableArrayList
                ("Chocolate", "Mango", "Sugar", "Jelly");

        typeHole = FXCollections.observableArrayList
                ("Glazed", "Vanilla", "Jelly", "Sugar");

        imageBanner.setImage(yeastDonutImage);

        selectDonutType.setItems(donutTypes);
        selectDonutType.getSelectionModel().select("Yeast Donuts");

        availableDonuts.setItems(typeYeast);

        selectedDonuts.getItems().clear();

        subTotal.clear();

        quantity.setItems(quant);
        quantity.getSelectionModel().select((Integer) 1);

        currOrder = new Order();
    }

    @FXML
    void addDonutOrder(ActionEvent event) {
        order.add(currOrder);
        initialize();
    }

    @FXML
    void removeDonuts(ActionEvent event) {
        if(selectedDonuts.getSelectionModel().getSelectedItem() != null) {
            String donutSelected = selectedDonuts.getSelectionModel().getSelectedItem();
            int currIndex = 0;
            int commaIndex = 0;
            while (currIndex < donutSelected.length()) {
                if (donutSelected.charAt(currIndex) == ',') {
                    commaIndex = currIndex;
                }
                currIndex++;
            }
            int numDonuts = Integer.parseInt(donutSelected.substring(commaIndex + 2));
            String donutFlavor = donutSelected.substring(6, commaIndex); //6 is the start of flavor name
            String donutType = donutSelected.substring(0, 3);

            System.out.println("HGSDHVHV");

            Donut donut;
            if (donutType.equals("Yst")) {
                donut = new Donut(1, donutFlavor, numDonuts);
                typeYeast.add(donutFlavor);
            } else if (donutType.equals("Cke")) {
                donut = new Donut(2, donutFlavor, numDonuts);
                typeCake.add(donutFlavor);
            } else {
                donut = new Donut(3, donutFlavor, numDonuts);
                typeHole.add(donutFlavor);
            }

            String donutTypeSelected = selectDonutType.getSelectionModel().getSelectedItem();
            if(donutTypeSelected.equals("Yeast Donuts")){
                availableDonuts.setItems(typeYeast);
            }
            else if(donutTypeSelected.equals("Cake Donuts")){
                availableDonuts.setItems(typeCake);
            }
            else{
                availableDonuts.setItems(typeHole);
            }

            currOrder.remove(donut);
            selectedDonuts.getItems().remove(donutSelected);
            subTotal.clear();
            subTotal.appendText("$ " + currOrder.getTotalPrice());

            quantity.getSelectionModel().select(0);
        }
    }

    @FXML
    void selectDonuts(ActionEvent event) {
        if(availableDonuts.getSelectionModel().getSelectedItem() != null) {
            String donutType = selectDonutType.getSelectionModel().getSelectedItem();
            String donutFlavor = availableDonuts.getSelectionModel().getSelectedItem();
            int numDonuts = quantity.getSelectionModel().getSelectedItem();
            Donut donut;
            String type;
            if (donutType.equals("Yeast Donuts")) {
                type = "Yst";
                donut = new Donut(1, donutFlavor, numDonuts);
                typeYeast.remove(donutFlavor);
                availableDonuts.setItems(typeYeast);
            } else if (donutType.equals("Cake Donuts")) {
                type = "Cke";
                donut = new Donut(2, donutFlavor, numDonuts);
                typeCake.remove(donutFlavor);
                availableDonuts.setItems(typeCake);
            } else {
                type = "Hol";
                donut = new Donut(3, donutFlavor, numDonuts);
                typeHole.remove(donutFlavor);
                availableDonuts.setItems(typeHole);
            }
            currOrder.add(donut);
            selectedDonuts.getItems().add(type + " - " + donutFlavor + ", " + numDonuts);
            subTotal.clear();
            subTotal.appendText("$ " + currOrder.getTotalPrice());

            quantity.getSelectionModel().select(0);
        }
    }

    @FXML
    void viewTypeDonut(ActionEvent event) {
        String selected = selectDonutType.getSelectionModel().getSelectedItem();
        if(selected.equals("Yeast Donuts")){
            availableDonuts.setItems(typeYeast);
            imageBanner.setImage(yeastDonutImage);
        }
        else if(selected.equals("Cake Donuts")){
            availableDonuts.setItems(typeCake);
            imageBanner.setImage(cakeDonutImage);
        }
        else{
            availableDonuts.setItems(typeHole);
            imageBanner.setImage(donutHolesImage);
        }
        quantity.getSelectionModel().select(0);
    }

    public void setMainController(StoreFrontController storeFrontController) {
        mainController = storeFrontController;
        order = mainController.order;
    }
}
