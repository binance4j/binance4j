package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.GetAllOCOParams;

/** TODO JAVADOC */
public class GetAllOCOTest extends MarginTest {
    // TODO make OCO
    // @Test
    void test1() throws ApiException {
        test(client.getAllOCO(new GetAllOCOParams()));
    }
}
