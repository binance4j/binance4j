package com.binance4j.wallet.dto;

/** A wallet type */
public enum WalletType {
	/** Spot */
	SPOT("0"),
	/** Funding */
	FUNDING("1");

	/** Value. */
	final String value;

	/**
	 * @param value
	 */
	private WalletType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}