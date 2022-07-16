package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getOrder} params. */
public class OrderParams extends FramedParams {
	/** The order id */
	private long orderId;
	/** The symbol */
	private String symbol;
	/** Is the order isolated? */
	private Boolean isIsolated;
	/** THe origin client order id */
	private String origClientOrderId;

	/**
	 * @param symbol The symbol
	 */
	public OrderParams(String symbol) {
		super(10);
		this.symbol = symbol;
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
	 * @return the isIsolated
	 */
	public Boolean isIsolated() {
		return isIsolated;
	}

	/**
	 * @param isIsolated the isIsolated to set
	 */
	public void isIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
	}

	/**
	 * @return the orderId
	 */
	public long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(long orderId) {
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

}