package br.com.martinperez.conversor.config;

public class Config {
    public static String getApiKey() {
        String apiKey = System.getenv("EXCHANGE_RATE_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new RuntimeException(
                    "API key not configured. Set EXCHANGE_RATE_KEY in your Run Configuration."
            );
        }

        return apiKey;
    }
}
