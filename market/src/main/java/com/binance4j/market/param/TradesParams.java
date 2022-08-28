package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * [MarketClient.getTrades] params.
 * 
 * @param symbol Symbol we want the trades.
 * @param limit  Trades size. Default 500; max 1000.
 */
@Param(recvWindow = false, timestamp = false)
data class TradesParams(
String symbol, Integer limit):Params
{

	/**
	 * Creates an instance of {@link TradesParams}.
	 * 
	 * @param symbol Symbol we want the trades.
	 * @param limit  Trades size. Default 500; max 1000.
	 */
	public TradesParams(String symbol, Integer limit) {
		this.symbol = symbol;
		this.limit = limit;
	}

	/**
	 * Creates an instance of {@link TradesParams}.
	 * 
	 * @param symbol Symbol we want the trades.
	 */
	public TradesParams(String symbol) {
		this(symbol, null);
	}
}
