package com.binance4j.core.dto;

/** Order reject reason values. */
public enum OrderRejectReason {
	/** none. */
	NONE,
	/** unknown instrument. */
	UNKNOWN_INSTRUMENT,
	/** market closed. */
	MARKET_CLOSED,
	/** price quantity exceed hard limits. */
	PRICE_QTY_EXCEED_HARD_LIMITS,
	/** unknown order. */
	UNKNOWN_ORDER,
	/** duplicate order. */
	DUPLICATE_ORDER,
	/** unknown account. */
	UNKNOWN_ACCOUNT,
	/** insufficient balance. */
	INSUFFICIENT_BALANCE,
	/** account inactive. */
	ACCOUNT_INACTIVE,
	/** account cannot settle. */
	ACCOUNT_CANNOT_SETTLE,
	/** order would trigger immediately. */
	ORDER_WOULD_TRIGGER_IMMEDIATELY
}