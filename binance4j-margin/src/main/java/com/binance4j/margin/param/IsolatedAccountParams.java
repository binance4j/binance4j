package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getIsolatedAccount} params. */
@Param(weight = 10)
public class IsolatedAccountParams implements Params {
	/** Max 5 symbols can be sent; separated by "," */
	String symbols;

	/** @return the symbols */
	public String getSymbols() {
		return symbols;
	}

	/** @param symbols the symbols to set */
	public void setSymbols(String symbols) {
		this.symbols = symbols;
	}

}