package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public MainController(String s) {
    }

    @FXML
    private Button btnAirMan;

    @FXML
    private Button btnAirTable;

    public void btnAirManClick(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/AddScene.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Airline Managment Systemmm");
        primaryStage.setScene(new Scene(root, 602, 400));
        primaryStage.show();
    }

    public void btnAirTableClick(ActionEvent actionEvent) {
    }

}
