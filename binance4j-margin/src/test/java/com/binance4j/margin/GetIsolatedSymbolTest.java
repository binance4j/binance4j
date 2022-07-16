package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.PairParams;

/** TODO JAVADOC */
public class GetIsolatedSymbolTest extends MarginTest {
    @Test
    void test1() throws ApiException {
        test(client.getIsolatedSymbol(new PairParams(symbol)));
    }
}
