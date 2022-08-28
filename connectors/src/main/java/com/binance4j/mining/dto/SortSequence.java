package com.binance4j.mining.dto;

/** Sorting. */
public enum SortSequence {
	/** Positive. */
	POSITIVE("0"),
	/** Negative. */
	NEGATIVE("1");

	/** The value. */
	String value;

	/**
	 * @property value Value.
	 */
	private SortSequence(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}