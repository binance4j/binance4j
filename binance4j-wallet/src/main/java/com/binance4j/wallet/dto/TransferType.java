package com.binance4j.wallet.dto;

/** Status of a submitted order. */
public enum TransferType {

	/** Spot to margin */
	SPOT_TO_MARGIN("1"),
	/** Margin to spot */
	MARGIN_TO_SPOT("2");

	/**
	 * @param value
	 */
	private TransferType(String value) {
		this.value = value;
	}

	final String value;

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}