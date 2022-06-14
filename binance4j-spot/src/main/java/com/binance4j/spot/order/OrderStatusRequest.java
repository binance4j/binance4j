package com.binance4j.spot.order;

import com.binance4j.core.request.FramedRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to check an order status
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderStatusRequest extends FramedRequest {
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
	public OrderStatusRequest(String symbol, Long orderId) {
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
	public OrderStatusRequest(String symbol, String origClientOrderId) {
		super(1);
		this.symbol = symbol;
		this.origClientOrderId = origClientOrderId;
	}
}
