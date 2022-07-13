package com.binance4j.margin;

import java.math.BigDecimal;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.transfer.MarginIsolatedTransferParams;
import com.binance4j.margin.transfer.MarginIsolatedTransferType;

public class IsolatedTransferTest extends MarginTest {
    // TODO
    // @Test
    void test1() throws ApiException {
        test(client.isolatedTransfer(new MarginIsolatedTransferParams(asset, symbol,
                MarginIsolatedTransferType.SPOT, MarginIsolatedTransferType.ISOLATED_MARGIN, new BigDecimal(1))));
    }
}
