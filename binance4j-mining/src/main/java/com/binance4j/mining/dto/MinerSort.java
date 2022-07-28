package com.binance4j.mining.dto;

public enum MinerSort {
	/** */
	MINER_NAME(1),
	/** */
	REAL_TIME_COMPUTING_POWER(1),
	/** */
	DAILY_AVERAGE_COMPUTING_POWER(1),
	/** */
	REAL_TIME_REJECTION_RATE(1),
	/** */
	LAST_SUBMISSION_TIME(1);

	int value;

	/**
	 * @param value
	 */
	private MinerSort(int value) {
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
