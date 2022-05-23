package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddController {

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfSource;

    @FXML
    private TextField tfDestination;

    @FXML
    private TextField tfDate;

    @FXML
    private TextField tfArrivalTime;

    @FXML
    private TextField tfDepartTime;

    @FXML
    private TextField tfNumOfP;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    public void btnCreateClick(ActionEvent actionEvent) {
    }

    public void btnUpdateClick(ActionEvent actionEvent) {
    }

    public void btnDeleteClick(ActionEvent actionEvent) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/MainScene.fxml"));
//        loader.setController(new MainController("Controllers.MainController"));
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//        Stage primaryStage = new Stage();
//        primaryStage.setTitle("Airline Managment Systemmm");
//        primaryStage.setScene(scene);
//        primaryStage.show();

    }
}
