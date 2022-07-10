package com.binance4j.margin;

import java.math.BigDecimal;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.OrderSide;
import com.binance4j.margin.oco.MarginOCOOrder;

//TODO
public class NewOCOTest extends MarginTest {
    // TODO
    // @Test
    void test1() throws ApiException {
        test(client.newOCO(new MarginOCOOrder(symbol, OrderSide.BUY, new BigDecimal(1), new BigDecimal(1),
                new BigDecimal(1))));
    }
}
