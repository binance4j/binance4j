package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;

public class GetMyTradesTest extends MarginTest {
    // TODO make orders
    // @Test
    void test1() throws ApiException {
        test(client.getMyTrades());
    }
}
