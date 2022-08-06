package com.binance4j.fiat.dto;

/** Payment type. */
public enum PaymentType {
	/** Buy. */
	BUY("0"),
	/** Sell. */
	SELL("1");

	/** The value. */
	String value;

	/**
	 * @param value Value
	 */
	private PaymentType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}