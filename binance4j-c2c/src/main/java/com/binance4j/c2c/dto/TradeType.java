package com.binance4j.c2c.dto;

/** Trade type. */
public enum TradeType {
	/** Buy. */
	BUY("BUY"),
	/** Sell. */
	SELL("SELL");

	String value;

	TradeType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
