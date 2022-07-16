package com.binance4j.margin.dto;

/**
 * The interest type of an {@link InterestRecord}
 */
public enum InterestType {
	/** Interest charged per hour. */
	PERIODIC,
	/** First interest charged on borrow. */
	ON_BORROW,
	/** Interest charged per hour converted into BNB. */
	PERIODIC_CONVERTED,
	/** First interest charged on borrow converted into BNB. */
	ON_BORROW_CONVERTED
}
