package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.transferhistory.MarginTransferHistoryParams;

public class GetTransferHistoryTest extends MarginTest {
    @Test

    void test1() throws ApiException {
        test(getClient().getTransferHistory(new MarginTransferHistoryParams()));
    }

    @Test

    void test2() throws ApiException {
        test(getClient().getTransferHistory());
    }
}
