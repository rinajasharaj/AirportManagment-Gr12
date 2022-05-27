package Presentation;

import Application.Control.*;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * MAIN CLASS - Prishtina International Airport ---
 */


public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    //start method
    public void start(Stage primaryStage)throws Exception {

        //show the login screen
        MainControl.showLoginScene();

    }


}
