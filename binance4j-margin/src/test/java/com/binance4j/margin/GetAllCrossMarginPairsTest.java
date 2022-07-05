package com.binance4j.margin;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.service.TestService;

public class GetAllCrossMarginPairsTest {

    @Test
    void test() throws ApiException {
        TestService.CLIENT.getAllCrossMarginPairs().execute().forEach(pair -> {
            assertNotNull(pair.getBase());
            assertNotNull(pair.getId());
            assertNotNull(pair.isBuyAllowed());
            assertNotNull(pair.isMarginTrade());
            assertNotNull(pair.isSellAllowed());
        });
    }
}
