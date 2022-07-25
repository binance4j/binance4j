package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getOpenOrders} params. */
public class OpenOrdersParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();
	/** The symbol */
	private String symbol;
	/** Is the order isolated? */
	private Boolean isIsolated;

	/** */
	public OpenOrdersParams() {
		super(10);
	}

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

	/** @return the timestamp */
	public long getTimestamp() {
		return timestamp;
	}

	/** @param timestamp the timestamp to set */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
