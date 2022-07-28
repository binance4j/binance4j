package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/** The parameters to get the latest price for a symbol or symbols. */
@Param(weight = 2, recvWindow = false, timestamp = false)
public class PriceTickerParams implements Params {
	/** Ticker symbol. */
	String symbol;

	/** for all symbols ticker. */
	public PriceTickerParams() {
	}

	/**
	 * for a unique symbol
	 *
	 * @param symbol The symbol we want the ticker.
	 */
	public PriceTickerParams(String symbol) {
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