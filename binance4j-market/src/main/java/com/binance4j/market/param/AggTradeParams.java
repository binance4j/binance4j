package com.binance4j.market.param;

import com.binance4j.core.param.Params;

/**
 * The parameters to get compressed, aggregate trades. Trades that fill at the time, from the same order, with the same
 * price will have the quantity aggregated.
 */
public class AggTradeParams extends Params {
	/** The agg trade pair. */
	private String symbol;
	/** id to get aggregate trades from (inclusive). */
	private Long fromId;
	/** Default 500; max 1000. */
	private Integer limit;
	/** Timestamp in ms to get aggregate trades from (inclusive). */
	private Long startTime;
	/** Timestamp in ms to get aggregate trades until (inclusive). */
	private Long endTime;

	/**
	 * Default constructor
	 *
	 * @param symbol The agg trade pair
	 */
	public AggTradeParams(String symbol) {
		super(1);
		this.symbol = symbol;
	}

	/**
	 * with limit
	 *
	 * @param symbol The agg trade pair
	 * @param limit  The result size. Default 500; max 1000.
	 */
	public AggTradeParams(String symbol, Integer limit) {
		this(symbol);
		this.limit = limit;
	}

	/**
	 * with fromId
	 *
	 * @param symbol The agg trade pair
	 * @param fromId The id to get aggregate trades from (inclusive).
	 */
	public AggTradeParams(String symbol, Long fromId) {
		this(symbol);
		this.fromId = fromId;
	}

	/**
	 * with fromId and limit
	 *
	 * @param symbol The agg trade pair
	 * @param fromId The id to get aggregate trades from (inclusive).
	 * @param limit  The result size. Default 500; max 1000.
	 */
	public AggTradeParams(String symbol, Long fromId, Integer limit) {
		this(symbol, limit);
		this.fromId = fromId;
	}

	/**
	 * with fromId
	 *
	 * @param symbol The agg trade pair
	 * @param fromId The id to get aggregate trades from (inclusive).
	 */
	public AggTradeParams(String symbol, String fromId) {
		this(symbol, Long.getLong(fromId));
	}

	/**
	 * with fromId and limit
	 *
	 * @param symbol The agg trade pair
	 * @param fromId The id to get aggregate trades from (inclusive).
	 * @param limit  The result size. Default 500; max 1000.
	 */
	public AggTradeParams(String symbol, String fromId, Integer limit) {
		this(symbol, limit);
		this.fromId = Long.getLong(fromId);
	}

	/**
	 * with start and end time (time interval must be lower to one hour)
	 *
	 * @param symbol    The agg trade pair
	 * @param startTime Timestamp in ms to get aggregate trades from (inclusive).
	 * @param endTime   Timestamp in ms to get aggregate trades until (inclusive).
	 */
	public AggTradeParams(String symbol, Long startTime, Long endTime) {
		this(symbol);
		this.startTime = startTime;
		this.endTime = endTime;
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

	/**
	 * @return the startTime
	 */
	public Long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Long getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

}
