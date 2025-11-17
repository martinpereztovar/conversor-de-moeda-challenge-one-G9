package br.com.martinperez.conversor;

import br.com.martinperez.conversor.service.ExchangeRateClient;


public class Main {
    public static void main(String[] args) {

        ExchangeRateClient client = new ExchangeRateClient();

        client.createRequest("USD");
    }
}
