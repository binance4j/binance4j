package com.binance4j.fiat.dto;

/** Transaction type. */
public enum TransactionType {
	/** Deposit. */
	DEPOSIT("0"),
	/** Withdraw. */
	WITHDRAW("1");

	/** The value */
	String value;

	/**
	 * @param value Value
	 */
	private TransactionType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}