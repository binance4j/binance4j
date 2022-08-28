package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getAsset} params.
 * 
 * @param asset Asset we want infos about.
 */
@Param(weight = 10)
public record AssetParams(String asset) implements Params {
}