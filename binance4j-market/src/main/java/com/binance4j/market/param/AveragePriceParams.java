package com.binance4j.market.param;

import com.binance4j.core.annotation.Mandatory;

/** The parameters to get the average price of a trading pair */
public class AveragePriceParams extends MarketParams {
	/** The trading pair we want the price. */
	@Mandatory
	String symbol;

	/**
	 * Default constructor
	 *
	 * @param symbol The trading pair we want the price.
	 */
	public AveragePriceParams(String symbol) {

		this.symbol = symbol;
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

}
