package com.binance4j.market.param;

import com.binance4j.core.param.Params;
import com.binance4j.market.dto.OrderBookLimit;

/** The parameters to get the market depth of a symbol */
public class OrderBookParams extends Params {
	/** The trading pair we want the depth. */
	private String symbol;
	/** The market depth size. */
	private Integer limit;

	/**
	 * Default constructor
	 *
	 * @param symbol The trading pair we want the depth
	 */
	public OrderBookParams(String symbol) {
		super(1);
		this.symbol = symbol;
	}

	/**
	 * with limit
	 *
	 * @param symbol The trading pair we want the depth
	 * @param limit  The depth size
	 */
	public OrderBookParams(String symbol, OrderBookLimit limit) {
		super(getWeight(limit));
		this.symbol = symbol;
		this.limit = limit.getValue();
	}

	/**
	 * with limit
	 *
	 * @param symbol The trading pair we want the depth
	 * @param limit  The depth size
	 */
	public OrderBookParams(String symbol, int limit) {
		super(getWeight(limit));
		this.symbol = symbol;
		this.limit = limit;
	}

	/**
	 * Gets the request weight according to the order book limit
	 *
	 * @param limit the depth size
	 * @return the request weight according to the order book limit
	 */
	private static int getWeight(OrderBookLimit limit) {
		switch (limit) {
		case LIMIT_500:
			return 5;
		case LIMIT_1000:
			return 10;
		case LIMIT_5000:
			return 50;
		default:
			return 1;
		}
	}

	/**
	 * Gets the request weight according to the order book limit
	 *
	 * @param limit the depth size
	 * @return the request weight according to the order book limit
	 */
	private static int getWeight(int limit) {
		switch (limit) {
		case 500:
			return 5;
		case 1000:
			return 10;
		case 5000:
			return 50;
		default:
			return 1;
		}
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
}