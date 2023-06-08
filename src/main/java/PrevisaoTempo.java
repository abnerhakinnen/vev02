package main.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PrevisaoTempo {
    public static void main(String[] args) {
        try {
            // Configurar a URL da API
            String apiUrl = "https://api.weatherapi.com/v1/current.json?key=a794ce0b86a242038d9163337230806&q=Quixad%C3%A1";
            URL url = new URL(apiUrl);

            // Criar a conexão HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Definir o método da requisição e outras propriedades
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Enviar a requisição e obter a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Aqui você pode fazer o tratamento dos dados retornados pela API
                System.out.println(response.toString());
            } else {
                System.out.println("Erro na requisição. Código de resposta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUrl(URL url) {
    }

    public void setApiKey(String string) {
    }

    public void executarPrevisaoTempo() {
    }
}
