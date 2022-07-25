package com.binance4j.market.param;

import com.binance4j.core.dto.CandlestickInterval;

/** The parameters to get candlestick data about a trading pair */
public class KlinesParams extends MarketParams {
	/** The starting timestamp of the results */
	private Long startTime;
	/** The ending timestamp of the results */
	private Long endTime;

	/** The trading pair we want the data. */
	private String symbol;
	/** The candlestick interval. */
	private String interval;
	/** The result size. Default 500; max 1000. */
	private Integer limit;

	/**
	 * with CandlestickInterval
	 *
	 * @param symbol   The trading pair we want the data.
	 * @param interval The candlestick interval.
	 */
	public KlinesParams(String symbol, CandlestickInterval interval) {
		super(1);
		this.symbol = symbol;
		this.interval = interval.toString();
	}

	/**
	 * Default constructor
	 *
	 * @param symbol   The trading pair we want the data.
	 * @param interval The candlestick interval.
	 */
	public KlinesParams(String symbol, String interval) {
		super(1);
		this.symbol = symbol;
		this.interval = interval;
	}

	/**
	 * with CandlestickInterval
	 *
	 * @param symbol   The trading pair we want the data.
	 * @param interval The candlestick interval.
	 * @param limit    The result limit. max 1000.
	 */
	public KlinesParams(String symbol, CandlestickInterval interval, int limit) {
		this(symbol, interval);
		this.limit = limit;
	}

	/**
	 * with limit
	 *
	 * @param symbol   The trading pair we want the data.
	 * @param interval The candlestick interval.
	 * @param limit    The result limit. max 1000.
	 */
	public KlinesParams(String symbol, String interval, int limit) {
		this(symbol, interval);
		this.limit = limit;
	}

	/**
	 * with Framed results
	 *
	 * @param symbol    The trading pair we want the data.
	 * @param interval  The candlestick interval.
	 * @param startTime The starting timestamp of the results (in ms).
	 * @param endTime   The ending timestamp of the results (in ms).
	 */
	public KlinesParams(String symbol, String interval, long startTime, long endTime) {
		this(symbol, interval);
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * with Framed results
	 *
	 * @param symbol    The trading pair we want the data.
	 * @param interval  The candlestick interval.
	 * @param startTime The starting timestamp of the results (in ms).
	 * @param endTime   The ending timestamp of the results (in ms).
	 */
	public KlinesParams(String symbol, CandlestickInterval interval, long startTime, long endTime) {
		this(symbol, interval);
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * @return the symbol.
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set.
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the interval.
	 */
	public String getInterval() {
		return interval;
	}

	/**
	 * @param interval the interval to set.
	 */
	public void setInterval(String interval) {
		this.interval = interval;
	}

	/**
	 * @return the limit.
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set.
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