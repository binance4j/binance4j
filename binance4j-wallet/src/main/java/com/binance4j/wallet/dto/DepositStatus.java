package com.binance4j.wallet.dto;

/** The coin deposit status. */
public enum DepositStatus {
	/** Pending */
	PENDING("0"),
	/** Cannot withdraw */
	CANNOT_WITHDRAW("6"),
	/** Success */
	SUCCESS("1");

	/** The status number. */
	final String value;

	/**
	 * @param value
	 */
	private DepositStatus(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	static public DepositStatus fromValue(String value) {
		for (DepositStatus e : DepositStatus.values()) {
			if (e.toString().equals(value)) {
				return e;
			}
		}
		return null;
	}
}
