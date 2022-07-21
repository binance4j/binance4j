package com.binance4j.fiat.dto;

public enum TransactionType {
	DEPOSIT("0"), WITHDRAW("1");

	String value;

	/**
	 * @param value
	 */
	private TransactionType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}