package com.binance4j.margin;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.account.MarginAccount;
import com.binance4j.margin.service.TestService;

public class GetAccountTest {
    @Test
    void test() throws ApiException {
        MarginAccount account = TestService.CLIENT.getAccount().execute();
        assertTrue(TestService.hasNoNullProperty(account));
        account.getUserAssets().forEach(asset -> assertTrue(TestService.hasNoNullProperty(asset)));
    }
}
