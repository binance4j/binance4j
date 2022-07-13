package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.asset.MarginAsset;
import com.binance4j.margin.asset.MarginAssetParams;

public class GetAssetTest extends MarginTest {
    @Test
    void test1() throws ApiException {
        MarginAsset asset = getClient().getAsset(new MarginAssetParams(getAsset())).execute();
        test(asset);
    }
}
