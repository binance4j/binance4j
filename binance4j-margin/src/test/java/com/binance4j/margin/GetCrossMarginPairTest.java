package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.pair.MarginPair;
import com.binance4j.margin.pair.MarginPairRequest;

public class GetCrossMarginPairTest extends MarginTest {

    @Test
    void test() throws ApiException {
        MarginPair pair = getClient().getCrossMarginPair(new MarginPairRequest(getSymbol())).execute();
        test(pair);
    }
}
