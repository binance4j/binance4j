package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.ToogleAccountParams;

public class DisableEnableIsolatedAccountTest extends MarginTest {
    // TODO activate isolated account
    // @Test
    void test1() throws ApiException {
        test(client.disableIsolatedAccount(new ToogleAccountParams(symbol)));
        test(client.enableIsolatedAccount(new ToogleAccountParams(symbol)));
    }
}
