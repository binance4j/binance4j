package com.binance4j.market.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * {@link MarketClient#getKlines} params.
 * 
 * @param symbol   Trading pair we want the data.
 * @param interval Candlestick interval.
 */
@Param(recvWindow = false, timestamp = false)
public record KlinesParams(@Mandatory String symbol, @Mandatory CandlestickInterval interval) implements Params {
}