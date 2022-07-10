package com.binance4j.margin;

import java.math.BigDecimal;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.transfer.MarginIsolatedTransferRequest;
import com.binance4j.margin.transfer.MarginIsolatedTransferType;

public class IsolatedTransferTest extends MarginTest {
    // TODO
    // @Test
    void test1() throws ApiException {
        test(client.isolatedTransfer(new MarginIsolatedTransferRequest(asset, symbol,
                MarginIsolatedTransferType.SPOT, MarginIsolatedTransferType.ISOLATED_MARGIN, new BigDecimal(1))));
    }
}
