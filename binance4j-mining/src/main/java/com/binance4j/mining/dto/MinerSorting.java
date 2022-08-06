package com.binance4j.mining.dto;

/** Miner sorting. */
public enum MinerSorting {
	/** Miner name. */
	MINER_NAME("1"),
	/** Real time computing_power. */
	REAL_TIME_COMPUTING_POWER("1"),
	/** Daily average computing_power. */
	DAILY_AVERAGE_COMPUTING_POWER("1"),
	/** Real time rejection rate. */
	REAL_TIME_REJECTION_RATE("1"),
	/** Last submission time. */
	LAST_SUBMISSION_TIME("1");

	String value;

	/**
	 * @param value
	 */
	private MinerSorting(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
