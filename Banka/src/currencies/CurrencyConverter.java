package currencies;

import java.util.Map;

public class CurrencyConverter {
    private static final Map<String, Double> RATES = Map.of(
            "CZK", 1.0,
            "EUR", 25.1,
            "USD", 23.4
    );

    public static double convert(double amount, String from, String to) {
        double inCZK = amount * RATES.get(from);
        double result = inCZK / RATES.get(to);
        return Math.round(result * 100) / 100.0;
    }
}
