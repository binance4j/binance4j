package com.binance4j.margin.dto;

/** The transfer type */
public enum TransferType {
	/** Main to margin */
	MAIN_TO_MARGIN("1"),
	/** Margin to main */
	MARGIN_TO_MAIN("2");

	/** The value */
	final String value;

	/** @param value The value */
	private TransferType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
