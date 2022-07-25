package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getIsolatedAccount} params. */
public class IsolatedAccountParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();
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

	/** @return the timestamp */
	public long getTimestamp() {
		return timestamp;
	}

	/** @param timestamp the timestamp to set */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}