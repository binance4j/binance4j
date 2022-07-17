package com.binance4j.wallet.dto;

import lombok.AllArgsConstructor;

/** A wallet type */
@AllArgsConstructor
public enum WalletType {
	SPOT(0), FUNDING(1);

	final int value;

	public int getValue() {
		return value;
	}
}