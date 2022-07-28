package com.binance4j.market.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.dto.OrderBookLimit;

/** The parameters to get the market depth of a symbol */
@Param(recvWindow = false, timestamp = false)
public class OrderBookParams implements Params {
	/** The trading pair we want the depth. */
	@Mandatory
	String symbol;
	/** The market depth size. */
	OrderBookLimit limit;

	/**
	 * @param symbol The trading pair we want the depth.
	 */
	public OrderBookParams(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @param symbol The trading pair we want the depth.
	 * @param limit  The depth size.
	 */
	public OrderBookParams(String symbol, OrderBookLimit limit) {
		this.symbol = symbol;
		this.limit = limit;
	}

	/**
	 * @param symbol The trading pair we want the depth.
	 * @param limit  The depth size.
	 */
	public OrderBookParams(String symbol, String limit) {
		this.symbol = symbol;
		this.limit = OrderBookLimit.valueOf(limit);
	}

	/**
	 * @return the request weight according to the order book limit.
	 */
	@Override
	public int weight() {
		return switch (limit) {
		case LIMIT_500 -> 5;
		case LIMIT_1000 -> 10;
		case LIMIT_5000 -> 50;
		default -> 1;
		};
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
	 * @return the limit
	 */
	public OrderBookLimit getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(OrderBookLimit limit) {
		this.limit = limit;
	}
}