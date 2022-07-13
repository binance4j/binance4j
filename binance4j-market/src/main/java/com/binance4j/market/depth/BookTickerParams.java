package com.binance4j.market.depth;

import com.binance4j.core.param.Params;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to get the the best price/qty on the order book for a symbol
 * or
 * symbols.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BookTickerParams extends Params {
	/**
	 * Ticker symbol.
	 */
	private String symbol;

	/**
	 * Constructor to get the ticker of all symbols
	 */
	public BookTickerParams() {
		super(2);
	}

	/**
	 * Constructor to get the ticker of a symbol
	 *
	 * @param symbol The trading pair we want the ticker
	 */
	public BookTickerParams(String symbol) {
		super(1);
		this.symbol = symbol;
	}
}
