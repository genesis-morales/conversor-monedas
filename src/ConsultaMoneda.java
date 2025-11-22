import com.google.gson.Gson;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaMoneda {


    public BigDecimal convertirCRC(String monedaDestino, BigDecimal cantidadCRC) {
        Moneda data = consulta("CRC");
        BigDecimal tasa = data.conversion_rates().get(monedaDestino);

        if (tasa == null) {
            throw  new RuntimeException("Moneda destino no existente" + monedaDestino);
        }

        return cantidadCRC.multiply(tasa);
    }

    public Moneda consulta(String base_code) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/9617a30bad7531c6b122e460/latest/" + base_code);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró la conversion de moneda " + base_code);
        }
    }
}
