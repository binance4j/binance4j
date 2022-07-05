package com.binance4j.margin;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.service.TestService;

public class GetAllAssetsTest {
    @Test
    void test() throws ApiException {
        TestService.CLIENT.getAllAssets().execute().forEach(asset -> {
            assertNotNull(asset.getAssetFullName());
            assertNotNull(asset.getAssetName());
            assertNotNull(asset.getIsBorrowable());
            assertNotNull(asset.getIsMortgageable());
            assertNotNull(asset.getUserMinBorrow());
            assertNotNull(asset.getUserMinRepay());
        });
        ;
    }
}
