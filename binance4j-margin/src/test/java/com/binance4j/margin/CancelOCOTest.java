package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.CancelMarginOCOParams;

//TODO
public class CancelOCOTest extends MarginTest {
    // TODO make OCO
    // @Test
    void test1() throws ApiException {
        test(client.cancelOCO(new CancelMarginOCOParams(symbol)));
    }
}
