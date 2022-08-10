package com.binance4j.core.dto;

/** The request signature. */
public enum Signature {
	/** Endpoint can be accessed freely. */
	NONE,
	/** Endpoint requires sending a valid API-Key and signature. */
	TRADE,
	/** Endpoint requires sending a valid API-Key and signature. */
	MARGIN,
	/** Endpoint requires sending a valid API-Key and signature. */
	USER_DATA,
	/** Endpoint requires sending a valid API-Key. */
	USER_STREAM,
	/** Endpoint requires sending a valid API-Key. */
	MARKET_DATA,
}
