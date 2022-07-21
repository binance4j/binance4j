package com.binance4j.fiat.dto;

public enum PaymentType {
	BUY("0"), SELL("1");

	String value;

	/**
	 * @param value
	 */
	private PaymentType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}