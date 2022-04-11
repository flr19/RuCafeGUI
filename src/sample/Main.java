package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Contains the main method to start the application
 *
 * @author Prince Rawal
 * @author Farah Lubaba Rouf
 */

public class Main extends Application {

    /**
     * Method to load the FXML and start the application
     *
     * @param primaryStage of the RUCafe
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StoreFront.fxml"));
        primaryStage.setTitle("WELCOME TO RU CAFE!!");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
