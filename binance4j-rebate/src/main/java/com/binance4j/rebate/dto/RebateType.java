package com.binance4j.rebate.dto;

/** The rebate type. */
public enum RebateType {
	/** commission rebate */
	COMMISSION_REBATE(1),
	/** referral kickback */
	REFERRAL_KICKBACK(2);

	/**
	 * @param value The value.
	 */
	private RebateType(int value) {
		this.value = value;
	}

	/** The error code. */
	final int value;

	/**
	 * @return the value.
	 */
	public int getValue() {
		return value;
	}
}