package com.binance4j.mining.dto;

/** Worker status. */
public enum WorkerStatus {
	/** All. */
	ALL(0),
	/** Valid. */
	VALID(1),
	/** Invalid. */
	INVALID(2),
	/** Failure. */
	FAILURE(3);

	int value;

	/**
	 * @param value
	 */
	private WorkerStatus(int value) {
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