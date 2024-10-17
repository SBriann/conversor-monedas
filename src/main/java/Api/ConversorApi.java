package Api;

import Model.Conversion;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConversorApi {
    Properties properties = new Properties();
    private final String URL_BASE = "https://v6.exchangerate-api.com/v6/";

    public Conversion convertir (String codMonedaOrigen, String codMonedaDestino, int monto) {
        try (InputStream input = ConversorApi.class.getResourceAsStream("/config.properties")) {
            // Obtener la clave de la API del archivo de propiedades
            properties.load(input);
            final String API_KEY = properties.getProperty("api.key");

            // Definir la url
            URI url = URI.create(URL_BASE + API_KEY + "/pair/" + codMonedaOrigen + "/" + codMonedaDestino + "/" + monto);

            // Crear el cliente y la petición
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .build();

            try {
                // Generar la petición y obtener la respuesta
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                // Hacer el mapeo usando la libreria Gson
                return new Gson().fromJson(response.body(), Conversion.class);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
