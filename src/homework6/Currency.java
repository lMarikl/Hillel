package homework6;

import java.util.List;

class Currency {
    private String currency;
    private double saleRateNB;
    private List<Currency> exchangeRate;

    List<Currency> getExchangeRate() {
        return exchangeRate;
    }

    String getCurrency() {
        return currency;
    }

    double getSaleRateNB() {
        return saleRateNB;
    }
}
