package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * The parameters to get the the best price/quantity on the order book for a symbol or symbols.
 */
@Param(weight = 2, recvWindow = false, timestamp = false)
public class BookTickerParams implements Params {
	/** Ticker symbol. */
	String symbol;

	/** Constructor. */
	public BookTickerParams() {
	}

	/**
	 * to get the ticker of a symbol
	 *
	 * @param symbol The trading pair we want the ticker.
	 */
	public BookTickerParams(String symbol) {

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