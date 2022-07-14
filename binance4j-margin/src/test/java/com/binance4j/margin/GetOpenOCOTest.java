package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;

/** TODO JAVADOC */
public class GetOpenOCOTest extends MarginTest {
    // TODO make OCO
    // @Test
    void test1() throws ApiException {
        test(client.getOpenOCO());
    }
}
