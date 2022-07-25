package com.binance4j.spot.param;

import com.binance4j.core.param.Params;

/** The parameters to fetch open orders from one or all pairs */
public class OpenOrdersStatusParams extends Params {

	/** The pair we want the open orders. */
	private String symbol;

	/** toi get all open orders. */
	public OpenOrdersStatusParams() {
		super(1);
	}

	/**
	 * to get the open orders of a specific pair
	 *
	 * @param symbol The pair we want the open orders.
	 */
	public OpenOrdersStatusParams(String symbol) {
		this();
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

}