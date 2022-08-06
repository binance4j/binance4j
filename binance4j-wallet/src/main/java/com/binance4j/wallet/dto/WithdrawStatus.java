package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModelProperty;

/** The status of a withdraw. */
public enum WithdrawStatus {
	/** Email sent. */
	EMAIL_SENT("0"), @ApiModelProperty("")
	/** Cancelled. */
	CANCELLED("1"), @ApiModelProperty("")
	/** Awaiting approval. */
	AWAITING_APPROVAL("2"), @ApiModelProperty("")
	/** Rejected. */
	REJECTED("3"), @ApiModelProperty("")
	/** Processing. */
	PROCESSING("4"), @ApiModelProperty("")
	/** Failure. */
	FAILURE("5"), @ApiModelProperty("")
	/** Completed. */
	COMPLETED("6");

	final String value;

	/**
	 * @param value The value.
	 */
	private WithdrawStatus(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}