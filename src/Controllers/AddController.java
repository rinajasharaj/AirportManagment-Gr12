package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import components.AboutComponent;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    public void btnDeleteClick(ActionEvent actionEvent) {
    }
}
