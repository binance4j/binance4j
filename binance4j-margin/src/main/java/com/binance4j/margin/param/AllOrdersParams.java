package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getAllOrders} params. */
public class AllOrdersParams extends Params {
	/** The starting timestamp of the results */
	private Long startTime;
	/** The ending timestamp of the results */
	private Long endTime;

	/** The order symbol */
	private String symbol;
	/** Is the order isolated? */
	private Boolean isIsolated;
	/** The order id */
	private Long orderId;
	/** The result limit */
	private Long limit;

	/** @param symbol The order symbol */
	public AllOrdersParams(String symbol) {
		super(200);
		this.symbol = symbol;
	}

	/** @return the symbol */
	public String getSymbol() {
		return symbol;
	}

	/** @param symbol the symbol to set */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/** @return the isIsolated */
	public Boolean isIsolated() {
		return isIsolated;
	}

	/** @param isIsolated the isIsolated to set */
	public void isIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
	}

	/** @return the orderId */
	public Long getOrderId() {
		return orderId;
	}

	/** @param orderId the orderId to set */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/** @return the limit */
	public Long getLimit() {
		return limit;
	}

	/** @param limit the limit to set */
	public void setLimit(Long limit) {
		this.limit = limit;
	}

	/** @return the startTime */
	public Long getStartTime() {
		return startTime;
	}

	/** @param startTime the startTime to set */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/** @return the endTime */
	public Long getEndTime() {
		return endTime;
	}

	/** @param endTime the endTime to set */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}
