package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModelProperty;

/** Worker status. */
public enum WorkerStatus {
	/** All. */
	ALL("0"), @ApiModelProperty("")
	/** Valid. */
	VALID("1"), @ApiModelProperty("")
	/** Invalid. */
	INVALID("2"), @ApiModelProperty("")
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