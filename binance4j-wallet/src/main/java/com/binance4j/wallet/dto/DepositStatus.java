package com.binance4j.wallet.dto;

import java.util.Arrays;

/** The coin deposit status */
public enum DepositStatus {
	/** Pending */
	PENDING(0),
	/** Cannot withdraw */
	CANNOT_WITHDRAW(6),
	/** Success */
	SUCCESS(1);

	/** The status number. */
	final int value;

	/**
	 * @param value
	 */
	private DepositStatus(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value The integer value
	 * @return The enum corresponding to the integer if present.
	 */
	public static DepositStatus valueOf(int value) {
		return Arrays.stream(values()).filter(e -> e.getValue() == value).findFirst().orElse(null);
	}
}
