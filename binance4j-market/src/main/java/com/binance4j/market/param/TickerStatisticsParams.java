package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * The parameters to get the 24 hour rolling window price change statistics. Careful when accessing this with no symbol.
 */
@Param(weight = 40, recvWindow = false, timestamp = false)
public class TickerStatisticsParams implements Params {
	/** The trading pair we want the ticker stats. */
	String symbol;

	/**
	 * to get the ticker stats of a symbol
	 *
	 * @param symbol The trading pair we want the ticker stats.
	 */
	public TickerStatisticsParams(String symbol) {

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