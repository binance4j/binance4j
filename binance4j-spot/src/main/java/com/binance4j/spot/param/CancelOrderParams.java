package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#cancelOrder} params.
 * 
 * @param symbol            Trade symbol.
 * @param orderId           Order id.
 * @param origClientOrderId Original client order id.
 * @param newClientOrderId  New client order id.
 */
@Param(weight = 10)
public record CancelOrderParams(String symbol, Long orderId, String origClientOrderId, String newClientOrderId) implements Params {
	/**
	 * Creates an instance of {@link OpenOrdersStatusParams}.
	 * 
	 * @param symbol            Trade symbol.
	 * @param orderId           Order id.
	 * @param origClientOrderId Original client order id.
	 * @param newClientOrderId  New client order id.
	 */
	public CancelOrderParams(String symbol, Long orderId, String origClientOrderId, String newClientOrderId) {
		this.symbol = symbol;
		this.orderId = orderId;
		this.origClientOrderId = origClientOrderId;
		this.newClientOrderId = newClientOrderId;
	}

	/**
	 * Creates an instance of {@link OpenOrdersStatusParams}.
	 * 
	 * @param symbol  Trade symbol.
	 * @param orderId Order id.
	 */
	public CancelOrderParams(String symbol, Long orderId) {
		this(symbol, orderId, null, null);
	}

	/**
	 * Creates an instance of {@link OpenOrdersStatusParams}.
	 * 
	 * @param symbol            Trade symbol.
	 * @param orderId           Order id.
	 * @param origClientOrderId Original client order id.
	 */
	public CancelOrderParams(String symbol, Long orderId, String origClientOrderId) {
		this(symbol, orderId, origClientOrderId, null);
	}
}