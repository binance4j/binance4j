package com.binance4j.market.param;

import com.binance4j.core.param.Params;

/**
 * The parameters to get the the best price/qty on the order book for a symbol or symbols.
 */
public class BookTickerParams extends Params {
	/** Ticker symbol. */
	private String symbol;

	/** to get the ticker of all symbols. */
	public BookTickerParams() {
		super(2);
	}

	/**
	 * to get the ticker of a symbol
	 *
	 * @param symbol The trading pair we want the ticker.
	 */
	public BookTickerParams(String symbol) {
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