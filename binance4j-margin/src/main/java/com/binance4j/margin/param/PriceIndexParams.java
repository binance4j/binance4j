package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getPriceIndex} params. */
@Param(weight = 10)
public class PriceIndexParams implements Params {
	/** The symbol */
	@Mandatory
	String symbol;

	/**
	 * @param symbol The symbol.
	 */
	public PriceIndexParams(String symbol) {
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