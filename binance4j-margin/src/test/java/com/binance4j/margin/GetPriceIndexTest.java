package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.priceindex.PriceIndexRequest;

public class GetPriceIndexTest extends MarginTest {
    @Test
    void test() throws ApiException {
        test(getClient().getPriceIndex(new PriceIndexRequest(getSymbol())).execute());
    }
}
