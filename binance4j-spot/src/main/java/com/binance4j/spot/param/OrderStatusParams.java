package com.binance4j.spot.param;

import com.binance4j.core.param.FramedParams;

/** The parameters to check an order status */
public class OrderStatusParams extends FramedParams {
	/** The trading pair we want the order status. */
	private String symbol;
	/** The client id we want the order status. */
	private String origClientOrderId;
	/** The order id we want the order status. */
	private Long orderId;

	/**
	 * with orderId
	 *
	 * @param symbol  The trading pair we want the order status.
	 * @param orderId The order id.
	 */
	public OrderStatusParams(String symbol, Long orderId) {
		super(1);
		this.symbol = symbol;
		this.orderId = orderId;
	}

	/**
	 * with origClientOrderId
	 *
	 * @param symbol            The trading pair we want the order status.
	 * @param origClientOrderId The client id.
	 */
	public OrderStatusParams(String symbol, String origClientOrderId) {
		super(1);
		this.symbol = symbol;
		this.origClientOrderId = origClientOrderId;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the origClientOrderId
	 */
	public String getOrigClientOrderId() {
		return origClientOrderId;
	}

	/**
	 * @param origClientOrderId the origClientOrderId to set
	 */
	public void setOrigClientOrderId(String origClientOrderId) {
		this.origClientOrderId = origClientOrderId;
	}

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
