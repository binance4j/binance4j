package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#getTrades} params.
 * 
 * @param symbol  Symbol of the trade.
 * @param orderId Order id of the trade.
 * @param fromId  Id from which we search trades.
 */
@Param(weight = 10)
public record TradesParams(String symbol, Long orderId, Long fromId) implements Params {
	/**
	 * Creates an instance of {@link TradesParams}.
	 * 
	 * @param symbol  Symbol of the trade.
	 * @param orderId Order id of the trade.
	 * @param fromId  Id from which we search trades.
	 */
	public TradesParams(String symbol, Long orderId, Long fromId) {
		this.symbol = symbol;
		this.orderId = orderId;
		this.fromId = fromId;
	}

	/**
	 * Creates an instance of {@link TradesParams}.
	 * 
	 * @param symbol Symbol of the trade.
	 */
	public TradesParams(String symbol) {
		this(symbol, null, null);
	}

	/**
	 * Creates an instance of {@link TradesParams}.
	 * 
	 * @param symbol  Symbol of the trade.
	 * @param orderId Order id of the trade.
	 */
	public TradesParams(String symbol, Long orderId) {
		this(symbol, orderId, null);
	}

	/**
	 * Creates an instance of {@link TradesParams}.
	 * 
	 * @param fromId Id from which we search trades.
	 * @param symbol Symbol of the trade.
	 */
	public TradesParams(Long fromId, String symbol) {
		this(symbol, null, fromId);
	}
}