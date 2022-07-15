package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum TransferType {
	MAIN_TO_MARGIN(1), MARGIN_TO_MAIN(2);

	private final int value;

	private TransferType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
