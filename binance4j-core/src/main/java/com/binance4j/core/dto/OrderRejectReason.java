package com.binance4j.core.dto;

/** Order reject reason values. */
public enum OrderRejectReason {
	/** None. */
	NONE,
	/** Unknown instrument. */
	UNKNOWN_INSTRUMENT,
	/** Market closed. */
	MARKET_CLOSED,
	/** Price quantity exceed hard limits. */
	PRICE_QTY_EXCEED_HARD_LIMITS,
	/** Unknown order. */
	UNKNOWN_ORDER,
	/** Duplicate order. */
	DUPLICATE_ORDER,
	/** Unknown account. */
	UNKNOWN_ACCOUNT,
	/** Insufficient balance. */
	INSUFFICIENT_BALANCE,
	/** Account inactive. */
	ACCOUNT_INACTIVE,
	/** Account cannot settle. */
	ACCOUNT_CANNOT_SETTLE,
	/** Order would trigger immediately. */
	ORDER_WOULD_TRIGGER_IMMEDIATELY
}