package com.binance4j.wallet.dto;

/** The status of a withdraw. */
public enum WithdrawStatus {
	/** Email sent. */
	EMAIL_SENT("0"),
	/** Cancelled. */
	CANCELLED("1"),
	/** Awaiting approval. */
	AWAITING_APPROVAL("2"),
	/** Rejected. */
	REJECTED("3"),
	/** Processing. */
	PROCESSING("4"),
	/** Failure. */
	FAILURE("5"),
	/** Completed. */
	COMPLETED("6");

	final String value;

	/**
	 * @param value The value.
	 */
	private WithdrawStatus(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}