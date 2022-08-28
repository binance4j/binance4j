package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * [MarketClient.getBookTicker] params.
 * 
 * @param symbol Symbol.
 */
@Param(weight = 2, recvWindow = false, timestamp = false)
data class BookTickerParams(String symbol) : Params {

}