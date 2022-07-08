package com.binance4j.margin;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.account.MarginAccount;

public class GetAccountTest extends MarginTest {
    @Test
    void test() throws ApiException {
        MarginAccount account = getClient().getAccount().execute();
        assertTrue(hasNoNullProperty(account));
        account.getUserAssets().forEach(asset -> assertTrue(hasNoNullProperty(asset)));
    }
}
