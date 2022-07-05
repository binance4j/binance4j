package com.binance4j.margin;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.pair.MarginPair;
import com.binance4j.margin.pair.MarginPairRequest;
import com.binance4j.margin.service.TestService;

public class GetCrossMarginPairTest {

    @Test
    void test() throws ApiException {
        MarginPair pair = TestService.CLIENT.getCrossMarginPair(new MarginPairRequest(TestService.SYMBOL)).execute();

        assertNotNull(pair.getBase());
        assertNotNull(pair.getId());
        assertNotNull(pair.isBuyAllowed());
        assertNotNull(pair.isMarginTrade());
        assertNotNull(pair.isSellAllowed());
    }
}
