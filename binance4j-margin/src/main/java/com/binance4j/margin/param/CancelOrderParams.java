package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;

/** The request to cancel an order. */
public class CancelOrderParams extends Params {
	/** The trade symbol */
	@Mandatory
	String symbol;
	/** The order id */
	@Mandatory
	Long orderId;
	/** The original client order id */
	String origClientOrderId;
	/** The new client order id */
	String newClientOrderId;

	/**
	 * @param symbol  The related symbol.
	 * @param orderId The order id.
	 */
	public CancelOrderParams(String symbol, Long orderId) {
		super(10);
		this.symbol = symbol;
		this.orderId = orderId;
	}

	/**
	 * @param symbol            The related symbol.
	 * @param origClientOrderId Origin client order id.
	 */
	public CancelOrderParams(String symbol, String origClientOrderId) {
		super(10);
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
	 * @return the newClientOrderId
	 */
	public String getNewClientOrderId() {
		return newClientOrderId;
	}

	/**
	 * @param newClientOrderId the newClientOrderId to set
	 */
	public void setNewClientOrderId(String newClientOrderId) {
		this.newClientOrderId = newClientOrderId;
	}

}