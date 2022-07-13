package com.binance4j.spot.order;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to check an order status
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderStatusParams extends FramedParams {
	/**
	 * The trading pair we want the order status
	 */
	private String symbol;
	/**
	 * The client id we want the order status
	 */
	private String origClientOrderId;
	/**
	 * The order id we want the order status
	 */
	private Long orderId;

	/**
	 * Constructor with orderId
	 *
	 * @param symbol  The trading pair we want the order status
	 * @param orderId The order id
	 */
	public OrderStatusParams(String symbol, Long orderId) {
		super(1);
		this.symbol = symbol;
		this.orderId = orderId;
	}

	/**
	 * Constructor with origClientOrderId
	 *
	 * @param symbol            The trading pair we want the order status
	 * @param origClientOrderId The client id
	 */
	public OrderStatusParams(String symbol, String origClientOrderId) {
		super(1);
		this.symbol = symbol;
		this.origClientOrderId = origClientOrderId;
	}
}
