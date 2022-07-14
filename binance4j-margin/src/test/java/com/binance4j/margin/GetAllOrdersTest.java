package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.AllOrdersParams;

public class GetAllOrdersTest extends MarginTest {
    @Test
    void test1() throws ApiException {
        AllOrdersParams params = new AllOrdersParams(symbol);
        test(client.getAllOrders(params));
    }
}
