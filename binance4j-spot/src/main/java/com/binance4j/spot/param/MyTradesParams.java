package com.binance4j.spot.param;

import com.binance4j.core.param.Params;

/** The parameters to get trades for a specific account and symbol. */
public class MyTradesParams extends Params {
	/** The starting timestamp of the results */
	private Long startTime;
	/** The ending timestamp of the results */
	private Long endTime;

	/** The symbol of the trade. */
	private String symbol;
	/** The order id of the trade. */
	private Long orderId;
	/** The id from which we search trades. */
	private Long fromId;
	/** The size of the result. Default 500; max 1000. */
	private Integer limit;

	/**
	 * Default constructor
	 *
	 * @param symbol The symbol we want the trades.
	 */
	public MyTradesParams(String symbol) {
		super(10);
		this.symbol = symbol;
	}

	/**
	 * @param symbol The symbol we want the trades.
	 * @param limit  The result size.
	 */
	public MyTradesParams(String symbol, Integer limit) {
		this(symbol);
		this.limit = limit;
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
	 * @return the fromId
	 */
	public Long getFromId() {
		return fromId;
	}

	/**
	 * @param fromId the fromId to set
	 */
	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
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
