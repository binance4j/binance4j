package com.binance4j.margin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.transferhistory.MarginTransferHistoryRequest;

public class GetTransferHistoryTest extends MarginTest {
    @Test
    @DisplayName("Response properties should not be null")
    void test1() throws ApiException {
        test(getClient().getTransferHistory(new MarginTransferHistoryRequest()));
    }

    @Test
    @DisplayName("Response properties should not be null")
    void test2() throws ApiException {
        test(getClient().getTransferHistory());
    }
}
