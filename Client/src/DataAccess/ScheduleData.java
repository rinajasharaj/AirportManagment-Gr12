package DataAccess;

import Application.DataTypes.Plane;
import Application.DataTypes.Schedule;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 5/19/2016.
 */

public class ScheduleData {

    //fields
    private static Statement statement;
    private static ArrayList<Schedule> schedules;
    private static String url = "http://127.0.0.1:8000/api/schedule/";

    //get schedules
    public static ArrayList<Schedule> getSchedules(){
        schedules = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());
            JSONArray schedule=new JSONArray(response.body());
            for(int i=0;i<schedule.length();i++){
                JSONObject scheduleobj= schedule.getJSONObject(i);
                int schedule_id=scheduleobj.getInt("schedule_id");
                String departure_date=scheduleobj.getString("departure_date");
                String departure_time=scheduleobj.getString("departure_time");
                String arrival_date=scheduleobj.getString("arrival_date");
                String arrival_time=scheduleobj.getString("arrival_time");

                Schedule s = new Schedule();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                s.setSchedule_id(schedule_id);
                s.setDeparture_date(dateFormat.parse(departure_date));
                s.setDeparture_time(departure_time);
                s.setArrival_date(dateFormat.parse(arrival_date));
                s.setArrival_time(arrival_time);

                schedules.add(s);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return schedules;
    }



    //method to add a schedule
    public static void insertSchedule(Schedule schedule){
        try {
            HttpClient client = HttpClient.newHttpClient();
            String input="{ \"departure_date\":\""+schedule.getDeparture_date() +"\", \"departure_time\":\""+schedule.getDeparture_time()+"\", \"arrival_date\":\""+schedule.getArrival_date()+"\", \"arrival_time\":\""+schedule.getArrival_time()+"\" }";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(input))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

}
