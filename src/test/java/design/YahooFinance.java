package design;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

public class YahooFinance {

    private static final String YAHOO_FINANCE_URL = "http://ichart.finance.yahoo.com/table.csv?s=";

    public static BigDecimal getPrice(final String ticker) {
        try {
            final URL searchURL = new URL(YAHOO_FINANCE_URL.concat(ticker));
            final BufferedReader reader = new BufferedReader(new InputStreamReader(searchURL.openStream()));
            final String data = reader.lines().skip(1).findFirst().get();
            final String[] dataItems = data.split(",");
            return new BigDecimal(dataItems[dataItems.length - 1]);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
