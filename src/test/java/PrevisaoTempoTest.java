package test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class PrevisaoTempoTest {

    @org.junit.jupiter.api.Test

    public void testExtrairGrausDaAPI() throws Exception {
        // Configurar a URL da API
        String apiUrl = "https://api.weatherapi.com/v1/current.json?key=a794ce0b86a242038d9163337230806&q=Quixad%C3%A1";
        URL url = new URL(apiUrl);

        // Criar a conexão HTTP
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Definir o método da requisição e outras propriedades
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        // Ler a resposta da API
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Aqui você pode fazer o tratamento dos dados retornados pela API
            double graus = extrairGrausDaResposta(response.toString());
        } else {
            // Tratar erro na requisição
            System.out.println("Erro na requisição. Código de resposta: " + responseCode);
        }
    }

    private double extrairGrausDaResposta(String response) {
        // Implemente a extração dos graus dos dados da resposta da API
        // Parseie o JSON e extraia os graus da estrutura de dados correspondente
        // Retorne os graus extraídos como um double
        // Exemplo simplificado: considerando que o campo "temp_c" está diretamente no
        // JSON de resposta
        JSONObject jsonResponse = new JSONObject(response);
        double graus = jsonResponse.getJSONObject("current").getDouble("temp_c");

        return graus;
    }
}
