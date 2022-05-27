package DataAccess;

import Application.DataTypes.Airline;
import Application.DataTypes.Plane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;

/**
 * Created by Petru on 19-May-16.
 */

public class AirlineData {

    //fields
    private static Statement statement;
    private static ObservableList<Airline> airlines;
    private static String url = "http://127.0.0.1:8000/api/airline/";

    //get airlines
    public static ObservableList<Airline> getAirlines(){
        airlines = FXCollections.observableArrayList();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
          //  System.out.println(response.body());
            JSONArray airline=new JSONArray(response.body());
            for(int i=0;i<airline.length();i++){
                JSONObject airlinee= airline.getJSONObject(i);
                int airline_id=airlinee.getInt("airline_id");
                String departure_city=airlinee.getString("departure_city");
                String arrival_city=airlinee.getString("arrival_city");

                Airline a = new Airline();
                a.setAirline_id(airline_id);
                a.setDeparture_city(departure_city);
                a.setArrival_city(arrival_city);

                airlines.add(a);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return airlines;
    }

}
