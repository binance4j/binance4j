package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.getPriceIndex] params.
 * 
 * @param symbol Symbol.
 */
@Param
data class PriceIndexParams(String symbol) : Params {
}