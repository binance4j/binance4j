package com.binance4j.margin.dto;

/** The transfer type */
public enum TransferType {
	/** Main to margin */
	MAIN_TO_MARGIN(1),
	/** Margin to main */
	MARGIN_TO_MAIN(2);

	/** The value */
	private final int value;

	/** @param value The value */
	private TransferType(int value) {
		this.value = value;
	}

	/** @return the value */
	public int getValue() {
		return value;
	}
}
