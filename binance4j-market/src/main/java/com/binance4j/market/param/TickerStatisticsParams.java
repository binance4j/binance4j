package com.binance4j.market.param;

/**
 * The parameters to get the 24 hour rolling window price change statistics. Careful when accessing this with no symbol.
 */
public class TickerStatisticsParams extends MarketParams {
	/** The trading pair we want the ticker stats. */
	String symbol;

	/** to get all ticker stats. */
	public TickerStatisticsParams() {
		super(40);
	}

	/**
	 * to get the ticker stats of a symbol
	 *
	 * @param symbol The trading pair we want the ticker stats.
	 */
	public TickerStatisticsParams(String symbol) {
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