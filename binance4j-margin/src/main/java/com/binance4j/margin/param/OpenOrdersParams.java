package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getOpenOrders} params. */
@Param(weight = 10)
public class OpenOrdersParams implements Params {
	/** The symbol */
	String symbol;
	/** Is the order isolated? */
	Boolean isIsolated;

	/** @return the symbol */
	public String getSymbol() {
		return symbol;
	}

	/** @param symbol the symbol to set */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/** @return the isIsolated */
	public Boolean isIsolated() {
		return isIsolated;
	}

	/** @param isIsolated the isIsolated to set */
	public void isIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
	}

}
