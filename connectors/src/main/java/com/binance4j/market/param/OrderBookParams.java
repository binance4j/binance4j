package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;
import com.binance4j.market.dto.OrderBookLimit;

/**
 * [MarketClient.getOrderBook] params.
 * 
 * @param symbol Trading pair we want the depth.
 * @param limit  Market depth size.
 */
@Param(recvWindow = false, timestamp = false)
data class OrderBookParams(
String symbol, String limit):Params
{

	/**
	 * Creates an instance of {@link OrderBookParams}.
	 * 
	 * @param symbol Trading pair we want the depth.
	 * @param limit  Market depth size.
	 */
	public OrderBookParams(String symbol, String limit) {
		this.symbol = symbol;
		this.limit = limit;
	}

	/**
	 * Creates an instance of {@link OrderBookParams}.
	 * 
	 * @param symbol Trading pair we want the depth.
	 */
	public OrderBookParams(String symbol) {
		this(symbol, "100");
	}

	/**
	 * Creates an instance of {@link OrderBookParams}.
	 * 
	 * @param symbol Trading pair we want the depth.
	 * @param limit  Order book limit.
	 */
	public OrderBookParams(String symbol, OrderBookLimit limit) {
		this(symbol, limit.toString());
	}
}