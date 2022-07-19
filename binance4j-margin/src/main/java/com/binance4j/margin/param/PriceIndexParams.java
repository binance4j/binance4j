package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getPriceIndex} params. */
public class PriceIndexParams extends Params {
	/** The symbol */
	private String symbol;

	/**
	 * @param symbol The symbol.
	 */
	public PriceIndexParams(String symbol) {
		super(10);
		this.symbol = symbol;
	}

	/** @return the symbol */
	public String getSymbol() {
		return symbol;
	}

	/** @param symbol the symbol to set */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}