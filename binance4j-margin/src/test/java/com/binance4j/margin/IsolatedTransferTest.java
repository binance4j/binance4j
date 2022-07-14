package com.binance4j.margin;

import java.math.BigDecimal;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.dto.IsolatedTransferType;
import com.binance4j.margin.param.NewIsolatedTransferParams;

/** TODO JAVADOC */
public class IsolatedTransferTest extends MarginTest {
    // TODO Test
    void test1() throws ApiException {
        test(client.newIsolatedTransfer(new NewIsolatedTransferParams(asset, symbol,
                IsolatedTransferType.SPOT, IsolatedTransferType.ISOLATED_MARGIN, new BigDecimal(1))));
    }
}
