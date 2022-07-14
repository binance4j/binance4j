package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.ToggleBurnParams;

public class ToggleBNBBurnOnSpotTradeAndMarginInterestTest extends MarginTest {
    @Test
    void test1() throws ApiException {
        test(client.toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(true, true)));
        test(client.toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(true, true)));
    }
}
