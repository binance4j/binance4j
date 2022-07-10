package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.account.ToogleAccountRequest;

public class DisableEnableIsolatedAccountTest extends MarginTest {
    // TODO activate isolated account
    // @Test
    void test1() throws ApiException {
        test(client.disableIsolatedAccount(new ToogleAccountRequest(symbol)));
        test(client.enableIsolatedAccount(new ToogleAccountRequest(symbol)));
    }
}
