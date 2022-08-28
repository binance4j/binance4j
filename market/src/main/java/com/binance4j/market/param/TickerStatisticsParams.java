package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * [MarketClient.get24hTickerStatistics] params.
 * 
 * @param symbol Symbol.
 */
@Param(weight = 40, recvWindow = false, timestamp = false)
data class TickerStatisticsParams(String symbol) : Params {

}