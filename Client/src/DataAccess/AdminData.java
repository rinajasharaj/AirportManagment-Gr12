package DataAccess;

import Application.DataTypes.Admin;
import Application.DataTypes.Plane;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class AdminData {

    //fields
    private static ArrayList<Admin> admins;
    private static Statement statement;
    private static String url = "http://127.0.0.1:8000/api/admins/";

    //get admins
    public static ArrayList<Admin> getAdmins(){
        admins = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            //  System.out.println(response.body());
            JSONArray admin=new JSONArray(response.body());
            for(int i=0;i<admin.length();i++){
                JSONObject adminobj= admin.getJSONObject(i);
                int admin_id=adminobj.getInt("admin_id");
                String first_name= adminobj.getString("first_name");
                String last_name= adminobj.getString("last_name");
                String password= adminobj.getString("password");

                Admin a = new Admin();
                a.setAdmin_id(admin_id);
                a.setFirst_name(first_name);
                a.setLast_name(last_name);
                a.setPassword(password);

                admins.add(a);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return admins;
    }


}
