package com.binance4j.mining.dto;

public enum SortSequence {
	POSITIVE(0), NEGATIVE(1);

	int value;

	/**
	 * @param value
	 */
	private SortSequence(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}
}