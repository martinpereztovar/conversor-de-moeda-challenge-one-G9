package br.com.martinperez.conversor.service;

import br.com.martinperez.conversor.domain.ExchangeRateResponse;

public class CurrencyConverter {
    private ExchangeRateClient client = new ExchangeRateClient();

    public double convert(String from, String to, double amount) {

        ExchangeRateResponse data = client.fetchRates(from);

        if (data == null || data.getConversionRates() == null) {
            throw new RuntimeException("Could not fetch exchange rates.");
        }

        Double rate = data.getConversionRates().get(to);

        if (rate == null) {
            throw new RuntimeException("Currency not supported: " + to);
        }

        return amount * rate;
    }
}
