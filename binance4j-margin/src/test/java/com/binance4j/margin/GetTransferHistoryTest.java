package com.binance4j.margin;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.transferhistory.MarginTransferHistoryRequest;
import com.binance4j.margin.transferhistory.MarginTransferHistoryResponse;

public class GetTransferHistoryTest extends MarginTest {
    @Test
    void test() throws ApiException {
        MarginTransferHistoryResponse res = getClient().getTransferHistory(new MarginTransferHistoryRequest())
                .execute();

        assertTrue(hasNoNullProperty(res));
        res.getRows().forEach(row -> assertTrue(getNullProperties(row).isEmpty()));
    }
}
