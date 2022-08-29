package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.getAsset] params.
 * 
 * @param asset Asset we want infos about.
 */
data class AssetParams(String asset) : Params {
}