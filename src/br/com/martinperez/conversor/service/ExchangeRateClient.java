package br.com.martinperez.conversor.service;

import br.com.martinperez.conversor.config.Config;
import br.com.martinperez.conversor.domain.ExchangeRateResponse;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateClient {

    private HttpClient client = HttpClient.newHttpClient();
    private Gson gson = new Gson();

    public ExchangeRateResponse fetchRates(String from) {
        String apiKey = Config.getApiKey();
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + from;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            ExchangeRateResponse data =
                    gson.fromJson(json, ExchangeRateResponse.class);

            return data;

        } catch (Exception e) {
            System.out.println("Error contacting the API: " + e.getMessage());
            return null;
        }

    }
}