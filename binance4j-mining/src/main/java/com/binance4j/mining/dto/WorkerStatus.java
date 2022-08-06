package com.binance4j.mining.dto;

/** Worker status. */
public enum WorkerStatus {
	/** All. */
	ALL("0"),
	/** Valid. */
	VALID("1"),
	/** Invalid. */
	INVALID("2"),
	/** Failure. */
	FAILURE("3");

	String value;

	/**
	 * @param value
	 */
	private WorkerStatus(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}