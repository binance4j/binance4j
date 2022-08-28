package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * [MarketClient.getKlines] params.
 * 
 * @param symbol   Trading pair we want the data.
 * @param interval Candlestick interval.
 */
@Param(recvWindow = false, timestamp = false)
data class KlinesParams(
String symbol, String interval):Params
{

	/**
	 * Creates an instance of the class.
	 * 
	 * @param symbol   Trading pair we want the data.
	 * @param interval Candlestick interval.
	 */
	public KlinesParams(String symbol, String interval) {
		this.symbol = symbol;
		this.interval = interval;
	}

	/**
	 * Creates an instance of the class.
	 * 
	 * @param symbol   Trading pair we want the data.
	 * @param interval Candlestick interval.
	 */
	public KlinesParams(String symbol, CandlestickInterval interval) {
		this(symbol, interval.toString());
	}
}