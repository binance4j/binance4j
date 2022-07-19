package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getIsolatedAccount} params. */
public class IsolatedAccountParams extends FramedParams {
	/** Max 5 symbols can be sent; separated by "," */
	private String symbols;

	/** Default constructor */
	public IsolatedAccountParams() {
		super(10);
	}

	/** @return the symbols */
	public String getSymbols() {
		return symbols;
	}

	/** @param symbols the symbols to set */
	public void setSymbols(String symbols) {
		this.symbols = symbols;
	}
}