package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.google.gson.Gson;
import model.ExchangeResponse;

public class ApiClient {

    private static final HttpClient client = HttpClient.newHttpClient();

    public static String getJson(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static ExchangeResponse obtenerTasas(String url) throws IOException,  InterruptedException {
        String json = getJson(url);
        Gson gson = new Gson();
        return gson.fromJson(json, ExchangeResponse.class);
    }
}
