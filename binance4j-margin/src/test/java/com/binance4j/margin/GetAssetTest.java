package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.asset.MarginAsset;
import com.binance4j.margin.asset.MarginAssetRequest;

public class GetAssetTest extends MarginTest {
    @Test
    void test1() throws ApiException {
        MarginAsset asset = getClient().getAsset(new MarginAssetRequest(getAsset())).execute();
        test(asset);
    }
}
