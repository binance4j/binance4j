package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#getOrderStatus} params.
 * 
 * @param symbol            Trading pair we want the order status.
 * @param origClientOrderId Client id we want the order status.
 * @param orderId           Order id we want the order status.
 */
@Param(weight = 2)
public record OrderStatusParams(String symbol, String origClientOrderId, Long orderId) implements Params {
	/**
	 * Creates an instance of {@link OrderStatusParams}.
	 */
	public OrderStatusParams() {
		this(null, null, null);
	}

	/**
	 * Creates an instance of {@link OrderStatusParams}.
	 * 
	 * @param symbol Trading pair we want the order status.
	 */
	public OrderStatusParams(String symbol) {
		this(symbol, null, null);
	}

	/**
	 * Creates an instance of {@link OrderStatusParams}.
	 * 
	 * @param symbol            Trading pair we want the order status.
	 * @param origClientOrderId Client id we want the order status.
	 */
	public OrderStatusParams(String symbol, String origClientOrderId) {
		this(symbol, origClientOrderId, null);
	}

	/**
	 * Creates an instance of {@link OrderStatusParams}.
	 * 
	 * @param symbol  Trading pair we want the order status.
	 * @param orderId Order id we want the order status.
	 */
	public OrderStatusParams(String symbol, Long orderId) {
		this(symbol, null, orderId);
	}
}