package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.dto.Asset;
import com.binance4j.margin.param.AssetParams;

/** TODO JAVADOC */
public class GetAssetTest extends MarginTest {
    @Test
    void test1() throws ApiException {
        Asset asset = getClient().getAsset(new AssetParams(getAsset())).execute();
        test(asset);
    }
}
