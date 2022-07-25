package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;

/** The parameters to get the fees of a trading pair */
public class TradeFeeParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();
	/** The trading pair we want the fees. */
	private String symbol;

	/** Constructor */
	public TradeFeeParams() {
		super(1);
	}

	/**
	 * @param symbol The symbol.
	 */
	public TradeFeeParams(String symbol) {
		this();
		this.symbol = symbol;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
