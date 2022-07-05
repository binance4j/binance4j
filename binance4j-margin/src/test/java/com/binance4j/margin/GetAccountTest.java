package com.binance4j.margin;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.account.MarginAccount;
import com.binance4j.margin.service.TestService;

public class GetAccountTest {
    @Test
    void test() throws ApiException {
        MarginAccount account = TestService.CLIENT.getAccount().execute();

        assertNotNull(account.getBorrowEnabled());
        assertNotNull(account.getMarginLevel());
        assertNotNull(account.getTotalAssetOfBtc());
        assertNotNull(account.getTotalLiabilityOfBtc());
        assertNotNull(account.getTotalNetAssetOfBtc());
        assertNotNull(account.getTradeEnabled());
        assertNotNull(account.getTransferEnabled());

        account.getUserAssets().forEach(asset -> {
            assertNotNull(asset.getAsset());
            assertNotNull(asset.getBorrowed());
            assertNotNull(asset.getFree());
            assertNotNull(asset.getInterest());
            assertNotNull(asset.getLocked());
            assertNotNull(asset.getNetAsset());
        });
    }
}
