package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#getOrderStatus} params.
 */
@Param(weight = 2)
public class OrderStatusParams implements Params {
	/** The trading pair we want the order status. */
	String symbol;
	/** The client id we want the order status. */
	String origClientOrderId;
	/** The order id we want the order status. */
	Long orderId;

	/**
	 * with orderId
	 *
	 * @param symbol  The trading pair we want the order status.
	 * @param orderId The order id.
	 */
	public OrderStatusParams(String symbol, Long orderId) {
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