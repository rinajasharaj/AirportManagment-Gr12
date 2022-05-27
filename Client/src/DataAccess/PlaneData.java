package DataAccess;

import Application.DataTypes.Plane;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;


public class PlaneData {

    //fields
    private static Statement statement;
    private static ObservableList<Plane> planes;
    private static String url = "http://127.0.0.1:8000/api/plane/";


    //get planes
    public static ObservableList<Plane> getPlanes(){
        planes = FXCollections.observableArrayList();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
          //  System.out.println(response.body());
            JSONArray plane=new JSONArray(response.body());
            for(int i=0;i<plane.length();i++){
                JSONObject planee= plane.getJSONObject(i);
                int plane_id=planee.getInt("plane_id");
                String plane_name= planee.getString("plane_name");
                int first_class=planee.getInt("first_class");
                int coach=planee.getInt("coach");
                int economy=planee.getInt("economy");

                Plane p = new Plane();
                p.setPlane_id(plane_id);
                p.setFirst_class(first_class);
                p.setCoach(coach);
                p.setEconomy(economy);
                p.setPlane_name(plane_name);

                planes.add(p);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return planes;
    }



    //method to add a plane
    public static void insertPlanes(Plane plane)
    {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String input="{ \"plane_name\":\""+plane.getPlane_name()+"\", \"first_class\":\""+plane.getFirst_class()+"\", \"coach\":\""+plane.getCoach()+"\", \"economy\":\""+plane.getEconomy()+"\" }";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(input))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            planes.add(plane);
            plane.setPlane_id(planes.indexOf(plane) + 1);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }



    //method to update a plane details
    public static void updatePlane(Plane plane){
        try{
            String urlpatch = url+plane.getPlane_id()+"/";
            HttpClient client = HttpClient.newHttpClient();
            String input="{ \"plane_name\":\""+plane.getPlane_name()+"\", \"first_class\":\""+plane.getFirst_class()+"\", \"coach\":\""+plane.getCoach()+"\", \"economy\":\""+plane.getEconomy()+"\" }";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlpatch))
                    .method("PATCH", HttpRequest.BodyPublishers.ofString(input))
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            planes.set(plane.getPlane_id() - 1, plane);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }



    //method to export plane list to .txt
    public static void exportPlanes()
    {
        String filePath = "C:\\Exported_Planes.txt";
        try{
            FileOutputStream out = new FileOutputStream(filePath);
            for(Plane p : planes)
            {
                String planesData = p.toString();
                out.write(planesData.getBytes());
            }
            out.close();


        }catch (Exception e){}


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Planes Exported!");
        alert.setHeaderText("Success!");
        alert.showAndWait();
    }

}
