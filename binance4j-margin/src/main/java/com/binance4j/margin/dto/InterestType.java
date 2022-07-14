package com.binance4j.margin.dto;

public enum InterestType {
	/** interest charged per hour */
	PERIODIC,
	/** first interest charged on borrow */
	ON_BORROW,
	/** interest charged per hour converted into BNB */
	PERIODIC_CONVERTED,
	/** first interest charged on borrow converted into BNB */
	ON_BORROW_CONVERTED
}
