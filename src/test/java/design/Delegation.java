package design;

import org.junit.Test;
import utils.CalculateNAV;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class Delegation {

    @Test
    public void shouldMockThePriceFinderFunctionality() {
        //mocking the price finder implementation that could be a web-service or a query to DB
        final CalculateNAV calculateNAV = new CalculateNAV(ticker -> new BigDecimal(10));

        assertThat(
                calculateNAV.computeStockWorth("any value", 7))
                .isEqualTo(new BigDecimal(70)
                );
    }

    @Test
    public void shouldInjectYahooWebServiceFunctionality() {
        final CalculateNAV calculateNAV = new CalculateNAV(YahooFinance::getPrice);

        assertThat(
                calculateNAV.computeStockWorth("GOOG", 1)
        ).isPositive();
    }
}
