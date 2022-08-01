package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#cancelOrder} params.
 * 
 * @param symbol            Trade symbol.
 * @param orderId           Order id.
 * @param origClientOrderId Original client order id.
 * @param newClientOrderId  New client order id.
 */
@Param(weight = 10)
public record CancelOrderParams(String symbol, Long orderId, String origClientOrderId, String newClientOrderId) implements Params {
	/**
	 * Creates an instance of {@link CancelOrderParams}
	 * 
	 * @param symbol The related symbol.
	 */
	public CancelOrderParams(String symbol) {
		this(symbol, null, null, null);
	}

	/**
	 * Creates an instance of {@link CancelOrderParams}
	 * 
	 * @param symbol  The related symbol.
	 * @param orderId The order id.
	 */
	public CancelOrderParams(String symbol, Long orderId) {
		this(symbol, orderId, null, null);
	}

	/**
	 * Creates an instance of {@link CancelOrderParams}
	 * 
	 * @param symbol            The related symbol.
	 * @param orderId           The order id.
	 * @param origClientOrderId Original client order id.
	 */
	public CancelOrderParams(String symbol, String origClientOrderId) {
		this(symbol, null, origClientOrderId, null);
	}

	/**
	 * Creates an instance of {@link CancelOrderParams}
	 * 
	 * @param symbol            The related symbol.
	 * @param origClientOrderId Original client order id.
	 * @param newClientOrderId  New client order id.
	 */
	public CancelOrderParams(String symbol, String origClientOrderId, String newClientOrderId) {
		this(symbol, null, origClientOrderId, newClientOrderId);
	}

	/**
	 * Creates an instance of {@link CancelOrderParams}
	 * 
	 * @param symbol            The related symbol.
	 * @param orderId           The order id.
	 * @param origClientOrderId Original client order id.
	 */
	public CancelOrderParams(String symbol, Long orderId, String origClientOrderId) {
		this(symbol, orderId, origClientOrderId, null);
	}
}