package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.interest.InterestHistoryParams;

public class GetInterestHistoryTest extends MarginTest {
    @Test
    void test1() throws ApiException {
        test(client.getInterestHistory(new InterestHistoryParams(asset)));
    }
}
