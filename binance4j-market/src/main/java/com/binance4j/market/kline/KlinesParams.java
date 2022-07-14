package com.binance4j.market.kline;

import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to get candlestick data about a trading pair
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class KlinesParams extends IntervalParams {
	/** The trading pair we want the data. */
	private String symbol;
	/** The candlestick interval. */
	private String interval;
	/** The result size. Default 500; max 1000. */
	private Integer limit;

	/**
	 * with CandlestickInterval
	 *
	 * @param symbol   The trading pair we want the data
	 * @param interval The candlestick interval
	 */
	public KlinesParams(String symbol, CandlestickInterval interval) {
		super(1);
		this.symbol = symbol;
		this.interval = interval.getValue();
	}

	/**
	 * Default constructor
	 *
	 * @param symbol   The trading pair we want the data
	 * @param interval The candlestick interval
	 */
	public KlinesParams(String symbol, String interval) {
		super(1);
		this.symbol = symbol;
		this.interval = interval;
	}

	/**
	 * with CandlestickInterval
	 *
	 * @param symbol   The trading pair we want the data
	 * @param interval The candlestick interval
	 * @param limit    The result limit. max 1000.
	 */
	public KlinesParams(String symbol, CandlestickInterval interval, int limit) {
		this(symbol, interval);
		this.limit = limit;
	}

	/**
	 * with limit
	 *
	 * @param symbol   The trading pair we want the data
	 * @param interval The candlestick interval
	 * @param limit    The result limit. max 1000.
	 */
	public KlinesParams(String symbol, String interval, int limit) {
		this(symbol, interval);
		this.limit = limit;
	}

	/**
	 * with Framed results
	 *
	 * @param symbol    The trading pair we want the data
	 * @param interval  The candlestick interval
	 * @param startTime The starting timestamp of the results (in ms)
	 * @param endTime   The ending timestamp of the results (in ms)
	 */
	public KlinesParams(String symbol, String interval, long startTime, long endTime) {
		this(symbol, interval);
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * with Framed results
	 *
	 * @param symbol    The trading pair we want the data
	 * @param interval  The candlestick interval
	 * @param startTime The starting timestamp of the results (in ms)
	 * @param endTime   The ending timestamp of the results (in ms)
	 */
	public KlinesParams(String symbol, CandlestickInterval interval, long startTime, long endTime) {
		this(symbol, interval);
		this.startTime = startTime;
		this.endTime = endTime;
	}

}
