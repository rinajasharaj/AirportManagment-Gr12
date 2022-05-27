package DataAccess;

import Application.DataTypes.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.ResultSet;
import java.sql.Statement;



public class FlightData {

    //fields
    private static Statement statement;
    private static ObservableList<Flight> flights;
    private static String url = "http://127.0.0.1:8000/api/flight/";


    //get flights
    public static ObservableList<Flight> getFlight(){
        flights = FXCollections.observableArrayList();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            JSONArray flight=new JSONArray(response.body());
            for(int i=0;i<flight.length();i++){
                JSONObject flightss= flight.getJSONObject(i);
                int flight_id=flightss.getInt("flight_id");
                int plane_id1= flightss.getInt("plane_id1");
                int airline_id1= flightss.getInt("airline_id1");
                int schedule_id1= flightss.getInt("airline_id1");
                Double price=flightss.getDouble("price");

                Flight f = new Flight();
                f.setFlight_id(flight_id);
                f.setPlane_id(plane_id1);
                f.setAirline_id(airline_id1);
                f.setSchedule_id(schedule_id1);
                f.setPrice(price);

                flights.add(f);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return flights;
    }



    //method to add a flight
    public static void insertFlight(Flight flight)
    {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String input = "{ \"plane_id1\":\"" + flight.getPlane_id() + "\", \"airline_id1\":\"" + flight.getAirline_id() + "\", \"schedule_id1\":\"" + flight.getSchedule_id() + "\", \"price\":\"" + flight.getPrice() + "\" }";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(input))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


    //method to update a flight
    public static void updateFlight(Flight flight){
        try{
            String urlpatch = url+flight.getFlight_id()+"/";
            HttpClient client = HttpClient.newHttpClient();
            String input = "{ \"plane_id1\":\"" + flight.getPlane_id() + "\", \"airline_id1\":\"" + flight.getAirline_id() + "\", \"schedule_id1\":\"" + flight.getSchedule_id() + "\", \"price\":\"" + flight.getPrice() + "\" }";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlpatch))
                    .method("PATCH", HttpRequest.BodyPublishers.ofString(input))
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


    //method to export flight list to .txt
    public static void exportFlights()
    {
        String filePath = "C:\\test.txt";
        try{
            FileOutputStream out = new FileOutputStream(filePath);
            for(Flight f : flights)
            {
                String flightData = f.toString();
                out.write(flightData.getBytes());
            }
            out.close();


        }catch (Exception e){}


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Flights Exported!");
        alert.setHeaderText("Success!");
        alert.showAndWait();
    }

}

