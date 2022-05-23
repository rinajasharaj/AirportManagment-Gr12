package sample;

import Controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("../views/AddScene.fxml"));
//        primaryStage.setTitle("Airline Managment Systemmm");
//        primaryStage.setScene(new Scene(root, 602, 400));
//        primaryStage.show();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/MainScene.fxml"));
        loader.setController(new MainController("Controllers.MainController"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Airline Managment Systemmm");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
