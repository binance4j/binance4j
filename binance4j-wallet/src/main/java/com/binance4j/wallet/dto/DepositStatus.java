package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModelProperty;

/** The coin deposit status */
public enum DepositStatus {
	/** Pending */
	PENDING("0"), @ApiModelProperty("")
	/** Cannot withdraw */
	CANNOT_WITHDRAW("6"), @ApiModelProperty("")
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
}
