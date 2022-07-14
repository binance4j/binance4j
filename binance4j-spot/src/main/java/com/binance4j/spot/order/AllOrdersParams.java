package com.binance4j.spot.order;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to display past orders
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AllOrdersParams extends IntervalParams {
	/** The trading pair we want the orders. */
	private String symbol;
	/**
	 * If orderId is set, it will get orders &gt;= that orderId. Otherwise, most
	 * recent orders are returned. If startTime and/or endTime provided,
	 * orderId is not required.
	 */
	private Long orderId;

	/** The result size. Default 500; max 1000. */
	private Integer limit = 500;

	/**
	 * Default constructor
	 *
	 * @param symbol The symbol we want the orders
	 */
	public AllOrdersParams(String symbol) {
		super(10);
		this.symbol = symbol;
	}

	/**
	 * Default constructor
	 *
	 * @param symbol The symbol we want the orders
	 */
	public AllOrdersParams(String symbol, Integer limit) {
		this(symbol);
		this.limit = limit;
	}

	/**
	 * with search after orderId
	 *
	 * @param symbol  The symbol we want the orders
	 * @param orderId The order id to get &gt;= orders
	 */
	public AllOrdersParams(String symbol, long orderId) {
		this(symbol);
		this.orderId = orderId;
	}

	/**
	 * with startTime and endTime
	 *
	 * @param symbol    The symbol we want the orders
	 * @param startTime The starting time of results
	 * @param endTime   The ending time of results
	 */
	public AllOrdersParams(String symbol, long startTime, long endTime) {
		this(symbol);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
	}
}
