package com.binance4j.wallet.dto;

/** A wallet type */
public enum WalletType {
	/** Spot */
	SPOT(0),
	/** Funding */
	FUNDING(1);

	/** Value. */
	final int value;

	/**
	 * @param value
	 */
	private WalletType(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
}