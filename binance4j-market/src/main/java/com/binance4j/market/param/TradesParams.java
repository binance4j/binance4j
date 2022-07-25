package com.binance4j.market.param;

/** The parameters to get recent trades */
public class TradesParams extends MarketParams {
	/** The symbol we want the trades. */
	String symbol;
	/** The trades size. Default 500; max 1000. */
	Integer limit = 500;

	/**
	 * Default constructor
	 *
	 * @param symbol The symbol we want the trades.
	 */
	public TradesParams(String symbol) {
		super(1);
		this.symbol = symbol;
	}

	/**
	 * @param symbol The symbol we want the trades.
	 * @param limit  The trades size. Default 500; max 1000.
	 */
	public TradesParams(String symbol, int limit) {
		this(symbol);
		this.limit = limit;
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

}
