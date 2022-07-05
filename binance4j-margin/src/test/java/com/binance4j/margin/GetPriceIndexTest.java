package com.binance4j.margin;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.margin.priceindex.PriceIndexRequest;
import com.binance4j.margin.service.TestService;

public class GetPriceIndexTest {
    @Test
    void test() {
        TestService.CLIENT.getPriceIndex(new PriceIndexRequest(TestService.SYMBOL)).then(res -> {
            assertNotNull(res.getCalcTime());
            assertNotNull(res.getPrice());
            assertNotNull(res.getSymbol());
        });
    }
}
