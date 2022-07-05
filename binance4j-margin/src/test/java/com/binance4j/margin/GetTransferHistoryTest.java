package com.binance4j.margin;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.service.TestService;
import com.binance4j.margin.transferhistory.MarginTransferHistoryRequest;
import com.binance4j.margin.transferhistory.MarginTransferHistoryResponse;

public class GetTransferHistoryTest {
    @Test
    void test() throws ApiException {
        MarginTransferHistoryResponse res = TestService.CLIENT.getTransferHistory(new MarginTransferHistoryRequest())
                .execute();

        assertTrue(TestService.getNullProperties(res).isEmpty());
        res.getRows().forEach(row -> assertTrue(TestService.getNullProperties(row).isEmpty()));
    }
}
