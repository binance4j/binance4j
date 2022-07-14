package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.RepayRecordParams;

/** TODO JAVADOC */
public class GetRepayRecordTest extends MarginTest {
    // TODO borrow and repay
    // @Test
    void test1() throws ApiException {
        test(client.getRepayRecord(new RepayRecordParams(asset)));
    }
}
