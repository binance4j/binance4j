package com.binance4j.margin;

import java.math.BigDecimal;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.NewOCOOrderParams;

//TODO
public class NewOCOTest extends MarginTest {
    // TODO Test
    void test1() throws ApiException {
        test(client.newOCO(new NewOCOOrderParams(symbol, OrderSide.BUY, new BigDecimal(1), new BigDecimal(1),
                new BigDecimal(1))));
    }
}
