package Application.Control;

import Application.DataTypes.*;
import DataAccess.DataConnection;
import Presentation.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class MainControl {

    //fields
    public static Stage window = new Stage();



    //menu scene
    public static void showMenuScene(){
        //initialization of scene
        MenuScene.initialize();

        //initialization of controller
        MenuSceneControl.initialize();

        //set scene
        window.setScene(MenuScene.getScene());
        window.setTitle("Prishtina International Airport™");
        window.centerOnScreen();

    }


    //login scene
    public static void showLoginScene() {
        //connect to database
        DataConnection.connect();

        //initialization of scene
        LoginScene.initialize();

        //initialization of actions
        LoginSceneControl.initialize();


        //set scene
        window.setScene(LoginScene.getScene());
        window.setTitle("Prishtina International Airport™");
        window.getIcons().add(new Image("/Presentation/icon.png"));

        window.show();
        window.centerOnScreen();
    }


    //view bookings scene
    public static void showViewBookingScene(){
        //initialization of scene
        ViewBookingScene.initialize();

        //initialization of actions
        ViewBookingSceneControl.initialize();

        //set scene
        window.setScene(ViewBookingScene.getScene());
        window.setTitle("Prishtina International Airport™  -  Bookings");
    }


    //view customers scene
    public static void showViewCustomerScene(){
        //initialization of scene
        ViewCustomersScene.initialize();

        //initialization of controller
        ViewCustomerSceneControl.initialize();

        //set scene
        window.setScene(ViewCustomersScene.getScene());
        window.setTitle("Prishtina International Airport™  -  Customers");
    }


    //view flights scene
    public static void showViewFlightsScene(){
        //initialization of scene
        ViewFlightsScene.initialize();

        //initialization of controller
        ViewFlightSceneControl.initialize();

        //set scene
        window.setScene(ViewFlightsScene.getScene());
        window.setTitle("Prishtina International Airport™  -  Flights");
    }


    //view planes scene
    public static void showViewPlanesScene(){
        //initialization of scene
        ViewPlaneScene.initialize();

        //initialization of controller
        ViewPlaneSceneControl.initialize();

        //set scene
        window.setScene(ViewPlaneScene.getScene());
        window.setTitle("Prishtina International Airport™  -  Planes");
    }


    //plane edit dialog
    public static boolean showPlaneEditScene(Plane plane){
        //initialization of scene
        PlaneEditScene.initialize();

        //initialization of control
        PlaneEditSceneControl.initialize();
        PlaneEditSceneControl.setPlane(plane);

        PlaneEditScene.getDialogStage().initOwner(window);
        PlaneEditScene.getDialogStage().setTitle("Plane menu");
        PlaneEditScene.getDialogStage().showAndWait();

        return PlaneEditSceneControl.isOkPressed();
    }


    //customer edit dialog
    public static boolean showCustomerEditScene(Customer customer){
        //initialization of scene
        CustomerEditScene.initialize();

        //initialization of control
        CustomerEditSceneControl.initialize();
        CustomerEditSceneControl.setCustomer(customer);

        CustomerEditScene.getDialogStage().initOwner(window);
        CustomerEditScene.getDialogStage().setTitle("Customer menu");
        CustomerEditScene.getDialogStage().showAndWait();

        return CustomerEditSceneControl.isOkPressed();
    }


    //flight edit dialog
    public static boolean showFlightEditScene(FlightTable flightTable, Flight flight){
        //initialization of scene
        FlightsEditScene.initialize();

        //initialization of controller
        FlightEditSceneControl.initialize();
        FlightEditSceneControl.setFlight(flightTable,flight);

        FlightsEditScene.getDialogStage().initOwner(window);
        FlightsEditScene.getDialogStage().setTitle("Flight menu");
        FlightsEditScene.getDialogStage().showAndWait();

        return FlightEditSceneControl.isOkPressed();
    }


    //booking edit dialog
    public static boolean showBookingEditScene(BookingTable bookingTable, Booking booking) {
        //initialization of scene
        BookingEditScene.initialize();

        //initialization of controller
        BookingEditSceneControl.initialize();
        BookingEditSceneControl.setBooking(bookingTable, booking);

        BookingEditScene.getDialogStage().initOwner(window);
        BookingEditScene.getDialogStage().setTitle("Booking menu");
        BookingEditScene.getDialogStage().showAndWait();

        return BookingEditSceneControl.isOkPressed();

    }

    //client
    public static void showVideo(){

        Parent root = null;
        try {
            root = FXMLLoader.load(MainControl.class.getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.setScene(new Scene(root, 390, 500));
        window.setTitle("Client");

    }

    public static void showChatGroup(){

        Parent root = null;
        try {
            root = FXMLLoader.load(MainControl.class.getResource("sample1.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.setScene(new Scene(root, 330, 560));
        window.setTitle("Client");

    }


    //getters
    public static Stage getWindow() {
        return window;
    }

}
