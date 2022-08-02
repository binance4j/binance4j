package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#getMyTrades} params.
 * 
 * @param symbol  The symbol of the trade.
 * @param orderId The order id of the trade.
 * @param fromId  The id from which we search trades.
 */
@Param(weight = 10)
public record TradesParams(String symbol, Long orderId, Long fromId) implements Params {
	/**
	 * Creates an instance of {@link TradesParams}.
	 * 
	 * @param symbol The symbol of the trade.
	 */
	public TradesParams(String symbol) {
		this(symbol, null, null);
	}

	/**
	 * Creates an instance of {@link TradesParams}.
	 * 
	 * @param symbol  The symbol of the trade.
	 * @param orderId The order id of the trade.
	 */
	public TradesParams(String symbol, Long orderId) {
		this(symbol, orderId, null);
	}

	/**
	 * Creates an instance of {@link TradesParams}.
	 * 
	 * @param fromId The id from which we search trades.
	 * @param symbol The symbol of the trade.
	 */
	public TradesParams(Long fromId, String symbol) {
		this(symbol, null, fromId);
	}
}