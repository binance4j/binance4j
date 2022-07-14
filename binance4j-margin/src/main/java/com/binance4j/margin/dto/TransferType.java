package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum TransferType {
	MAIN_TO_MARGIN(1), MARGIN_TO_MAIN(2);

	/** @param value */
	private TransferType(int value) {
		this.value = value;
	}

	private final int value;

	/** @return the value */
	public int getValue() {
		return value;
	}
}
