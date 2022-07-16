package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.IsolatedTierDataParams;

/** TODO JAVADOC */
public class GetIsolatedMarginTierDataTest extends MarginTest {
    @Test
    void test1() throws ApiException {
        test(client.getIsolatedMarginTierData(new IsolatedTierDataParams(symbol)));
    }
}
