package sample;


import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Arrays;

public class DonutController {

    @FXML
    private ListView availableDonuts;

    @FXML
    private ListView selectedDonuts;

    private static ArrayList<String> usualTypeYeast= new ArrayList<String>(
            Arrays.asList("Glazed Chocolate", "Vanilla Creme", "Strawberry Frosted", "Jelly"));

    private static ArrayList<String> usualTypeCake= new ArrayList<String>(
            Arrays.asList("Chocolate", "Mango", "Sugar", "Jelly"));

    private static ArrayList<String> usualTypeHole= new ArrayList<String>(
            Arrays.asList("Glazed", "Vanilla", "Jelly", "Sugar"));

}
