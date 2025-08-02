package conversor;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarConversion {
    public ConversionDolares buscarConversion(String conversion){
        URI direcion = URI.create("https://v6.exchangerate-api.com/v6/1bd9b348ba7656e8743cede7/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direcion)
                .build();
        try {
            HttpResponse< String > response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(), ConversionDolares.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa conversion.");
        }
    }
}
