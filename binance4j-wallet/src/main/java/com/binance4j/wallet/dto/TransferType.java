package com.binance4j.wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Status of a submitted order. */
@AllArgsConstructor
public enum TransferType {
	SPOT_TO_MARGIN("1"), MARGIN_TO_SPOT("2");

	@Getter
	final String value;
}
