import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverter {
    private static final String API_KEY = "83a3e85fcfaeb910f8a46720"; // Reemplaza con tu API Key
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    private Map<String, CurrencyRecord> exchangeRates = new HashMap<>();

    public CurrencyConverter() {
        // Inicializar con las monedas requeridas
        String[] currencies = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};
        for (String currency : currencies) {
            exchangeRates.put(currency, new CurrencyRecord(currency, currency, 0.0));
        }
    }

    public void updateExchangeRates() throws IOException {
        URL url = new URL(API_URL + API_KEY + "/latest/USD");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Error: " + responseCode);
        }

        InputStreamReader reader = new InputStreamReader(conn.getInputStream());
        JsonElement jsonElement = JsonParser.parseReader(reader);
        reader.close();

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        for (String currency : exchangeRates.keySet()) {
            double rate = rates.get(currency).getAsDouble();
            exchangeRates.put(currency, new CurrencyRecord(currency, currency, rate));
        }
    }

    public double convert(String from, String to, double amount) {
        double rateFrom = exchangeRates.get(from).rate();
        double rateTo = exchangeRates.get(to).rate();
        return amount * (rateTo / rateFrom);
    }

    public Map<String, CurrencyRecord> getExchangeRates() {
        return exchangeRates;
    }
}
