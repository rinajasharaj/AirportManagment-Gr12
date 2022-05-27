package DataAccess;

import Application.DataTypes.Booking;
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
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 5/19/2016.
 */

public class BookingData {

    //fields
    private static Statement statement;
    private static ObservableList<Booking> bookings;
    private static String url = "http://127.0.0.1:8000/api/booking/";


    //get bookings
    public static ObservableList<Booking> getBookings(){
        bookings = FXCollections.observableArrayList();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            //  System.out.println(response.body());
            JSONArray booking=new JSONArray(response.body());
            for(int i=0;i<booking.length();i++){
                JSONObject bookingobj= booking.getJSONObject(i);
                int booking_id=bookingobj.getInt("booking_id");
                int customer_id1=bookingobj.getInt("customer_id1");
                int flight_id1=bookingobj.getInt("flight_id1");
                String class_field=bookingobj.getString("class_field");

                Booking b = new Booking();
                b.setBooking_id(booking_id);
                b.setCustomer_id(customer_id1);
                b.setFlight_id(flight_id1);
                b.setFare_class(class_field);

                bookings.add(b);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bookings;
    }



    //method to add a booking
    public static void insertBooking(Booking booking)
    {
        try{
            HttpClient client = HttpClient.newHttpClient();
            String input="{ \"customer_id1\":\""+booking.getCustomer_id()+"\", \"flight_id1\":\""+booking.getFlight_id()+"\", \"class_field\":\""+booking.getFare_class()+"\" }";
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



    //method to edit a booking
    public static void updateBooking(Booking booking){
        try{
            String urlpatch = url+booking.getBooking_id()+"/";
            HttpClient client = HttpClient.newHttpClient();
            String input="{ \"customer_id1\":\""+booking.getCustomer_id()+"\", \"flight_id1\":\""+booking.getFlight_id()+"\", \"class_field\":\""+booking.getFare_class()+"\" }";
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



    //method to remove a booking
    public static void deleteBooking(Booking booking){
        try{
            statement.executeUpdate("DELETE FROM booking WHERE booking_id = " + booking.getBooking_id() + ";");
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

}
