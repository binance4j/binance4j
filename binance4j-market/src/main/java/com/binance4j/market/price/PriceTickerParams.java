package com.binance4j.market.price;

import com.binance4j.core.param.Params;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to get the latest price for a symbol or symbols.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PriceTickerParams extends Params {
	/** Ticker symbol. */
	private String symbol;

	/** for all symbols ticker. */
	public PriceTickerParams() {
		super(2);
	}

	/**
	 * for a unique symbol
	 *
	 * @param symbol The symbol we want the ticker
	 */
	public PriceTickerParams(String symbol) {
		super(1);
		this.symbol = symbol;
	}
}
