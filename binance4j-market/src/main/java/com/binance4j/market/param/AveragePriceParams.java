package com.binance4j.market.param;

/** The parameters to get the average price of a trading pair */
public class AveragePriceParams extends MarketParams {
	/** The trading pair we want the price. */
	private String symbol;

	/**
	 * Default constructor
	 *
	 * @param symbol The trading pair we want the price.
	 */
	public AveragePriceParams(String symbol) {
		super(1);
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
