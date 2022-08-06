package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModelProperty;

/** Sorting. */
public enum SortSequence {
	/** Positive. */
	POSITIVE("0"), @ApiModelProperty("")
	/** Negative. */
	NEGATIVE("1");

	/** The value. */
	String value;

	/**
	 * @param value The value.
	 */
	private SortSequence(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}