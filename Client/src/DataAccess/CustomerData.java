package DataAccess;

import Application.DataTypes.Customer;
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

public class CustomerData {

    //fields
    private static Statement statement;
    private static ObservableList<Customer> customers;
    private static String url = "http://127.0.0.1:8000/api/customer/";


    //get customers
    public static ObservableList<Customer> getCustomers(){
        customers = FXCollections.observableArrayList();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            //  System.out.println(response.body());
            JSONArray customer=new JSONArray(response.body());
            for(int i=0;i<customer.length();i++){
                JSONObject customere= customer.getJSONObject(i);
                int customer_id=customere.getInt("customer_id");
                String first_name= customere.getString("first_name");
                String last_name= customere.getString("last_name");
                int age=customere.getInt("age");
                String passport_number= customere.getString("passport_number");
                String phone_nr= customere.getString("phone_nr");

                Customer c = new Customer();
                c.setCustomer_id(customer_id);
                c.setFirst_name(first_name);
                c.setLast_name(last_name);
                c.setAge(age);
                c.setPassport_number(passport_number);
                c.setPhone_nr(phone_nr);

                customers.add(c);;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return customers;
    }



    //method to add a customer
    public static void insertCustomer(Customer customer)
    {
        try{
            HttpClient client = HttpClient.newHttpClient();
            String input="{ \"first_name\":\""+customer.getFirst_name()+"\", \"last_name\":\""+customer.getLast_name()+"\", \"age\":\""+customer.getAge()+"\", \"passport_number\":\""+customer.getPassport_number()+"\", \"phone_nr\":\""+customer.getPhone_nr()+"\" }";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(input))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            customers.add(customer);
            customer.setCustomer_id(customers.indexOf(customer) + 1);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


    //method to update a customer
    public static void updateCustomer(Customer customer){
        try{
            String urlpatch = url+customer.getCustomer_id()+"/";
            HttpClient client = HttpClient.newHttpClient();
            String input="{ \"first_name\":\""+customer.getFirst_name()+"\", \"last_name\":\""+customer.getLast_name()+"\", \"age\":\""+customer.getAge()+"\", \"passport_number\":\""+customer.getPassport_number()+"\", \"phone_nr\":\""+customer.getPhone_nr()+"\" }";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlpatch))
                    .method("PATCH", HttpRequest.BodyPublishers.ofString(input))
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            customers.set(customer.getCustomer_id() - 1, customer);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

}
