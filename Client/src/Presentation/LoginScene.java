package Presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;



public class LoginScene {

    //fields
    private static Scene scene;
    private static VBox loginLayout;
    private static Label loginLabel;
    private static Label hermesLabel;
    private static TextField usernameField;
    private static PasswordField passwordField;
    private static Button loginButton;
    private static ImageView img;

    //initialization of objects
    public static  void initialize(){

        img = new ImageView("/Presentation/login.png");
        img.setFitHeight(110);
        img.setFitWidth(110);

        //loginLabel
        loginLabel = new Label("Log in");
        loginLabel.setPadding((new Insets(-90, 0, 30, 0)));
        loginLabel.setStyle("-fx-font-size: 24pt");


        //hermesLabel
        hermesLabel=new Label("");
        hermesLabel.setId("welcome");

        //usernameField
        usernameField=new TextField();
        usernameField.setPromptText("User ID");
        usernameField.setMaxWidth(220);
        usernameField.setAlignment(Pos.CENTER);

        //passwordField
        passwordField=new PasswordField();
        passwordField.setAlignment(Pos.CENTER);
        passwordField.setMaxWidth(220);
        passwordField.setPromptText("Password");

        //buttonField
        loginButton=new Button("Login");
        loginButton.setMaxWidth(120);

        //layout
        loginLayout = new VBox(10);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.getChildren().addAll(img,hermesLabel,loginLabel,usernameField,passwordField,loginButton);

        //scene
        scene = new Scene(loginLayout,400,500);
        scene.getStylesheets().add("Presentation/style.css");



        System.out.println("login screen initialized");
    }


    //getters
    public static Scene getScene() {
        return scene;
    }

    public static VBox getLoginLayout() {
        return loginLayout;
    }

    public static Label getLoginLabel() {
        return loginLabel;
    }

    public static Label getHermesLabel() {
        return hermesLabel;
    }

    public static TextField getUsernameField() {
        return usernameField;
    }

    public static PasswordField getPasswordField() {
        return passwordField;
    }

    public static Button getLoginButton() {
        return loginButton;
    }

}
