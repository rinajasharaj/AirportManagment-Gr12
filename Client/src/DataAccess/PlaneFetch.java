package DataAccess;
import Application.DataTypes.Plane;
import com.google.gson.Gson;
import javafx.concurrent.Task;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PlaneFetch extends Task<Plane[]> {
        private Gson gson = new Gson();
        private String url = "http://127.0.0.1:8000/api/plane/";

        @Override
        protected Plane[] call() throws Exception {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), Plane[].class);
        }

}
