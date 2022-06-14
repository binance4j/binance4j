package com.binance4j.wallet.snapshot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The account snapshot type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum AccountSnapshotType {
	/**
	 * .
	 */
	SPOT,
	/**
	 * .
	 */
	MARGIN,
	/**
	 * .
	 */
	FUTURES
}