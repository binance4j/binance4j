package com.binance4j.margin;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.asset.MarginAsset;
import com.binance4j.margin.asset.MarginAssetRequest;
import com.binance4j.margin.service.TestService;

public class GetAssetTest {
    @Test
    void test() throws ApiException {
        MarginAsset asset = TestService.CLIENT.getAsset(new MarginAssetRequest(TestService.ASSET)).execute();
        assertNotNull(asset.getAssetFullName());
        assertNotNull(asset.getAssetName());
        assertNotNull(asset.getIsBorrowable());
        assertNotNull(asset.getIsMortgageable());
        assertNotNull(asset.getUserMinBorrow());
        assertNotNull(asset.getUserMinRepay());
    }
}
