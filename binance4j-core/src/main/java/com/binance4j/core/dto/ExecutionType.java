package com.binance4j.core.dto;

/** Order execution type. */
public enum ExecutionType {
	/** Order is new. */
	NEW,
	/** Order is canceled. */
	CANCELED,
	/** Order is replaced. */
	REPLACED,
	/** Order is rejected. */
	REJECTED,
	/** Order is trade. */
	TRADE,
	/** Order is expired. */
	EXPIRED
}
