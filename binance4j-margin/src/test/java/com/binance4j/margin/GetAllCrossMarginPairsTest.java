package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

public class GetAllCrossMarginPairsTest extends MarginTest {
    @Test
    void test() throws ApiException {
        test(getClient().getAllCrossMarginPairs().execute());
    }
}
